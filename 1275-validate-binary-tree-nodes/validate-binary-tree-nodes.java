class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent,-1);

        for(int i=0; i<n; i++){
            if(leftChild[i] != -1){
                if(parent[leftChild[i]] != -1){
                    return false;
                }
                parent[leftChild[i]] = i;
            }

            if(rightChild[i] != -1){
                if(parent[rightChild[i]] != -1){
                    return false;
                }
                parent[rightChild[i]] = i;
            }
        }

        int root = -1;
        int roots = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == -1){
                root = i;
                roots++;
            }
        }

        if(roots != 1){
            return false;
        }

        boolean[] visited = new boolean[n];

        if(!dfs(root, visited, leftChild, rightChild)){
            return false;
        }

        for(boolean node : visited){
            if(!node){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, boolean[] visited, int[] left, int[] right){
        if(node == -1){
            return true;
        }
        if(visited[node]){
            return false;
        }

        visited[node] = true;

        return dfs(left[node],visited,left,right) && dfs(right[node],visited,left,right);

    }
}