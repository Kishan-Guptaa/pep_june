class Solution{
    
    public static void printEvenRows1Based(int[][] arr){
        if (arr == null) return;
        for (int i = 0; i < arr.length; i++){
            if ((i + 1) % 2 != 0) continue; 
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10,11,12}
        };
        printEvenRows1Based(matrix); 
    }
}
