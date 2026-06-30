class Solution{
    
    public static int recursiveLinearSearch(int[] arr, int index, int key){
        if (arr == null || index >= arr.length) return -1;
        if (arr[index] == key) return index;
        return recursiveLinearSearch(arr, index + 1, key);
    }

    public static void main(String[] args){
        int[] arr = {3, 5, 2, 7, 9};
        int key = 7;
        int idx = recursiveLinearSearch(arr, 0, key);
        if (idx == -1) System.out.println(key + " not found");
        else System.out.println(key + " found at index " + idx);
    }
}
