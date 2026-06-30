class Solution{
    
    public static int recursiveBinarySearch(int[] arr, int left, int right, int key){
        if (arr == null || left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == key) return mid;
        else if (arr[mid] > key) return recursiveBinarySearch(arr, left, mid - 1, key);
        else return recursiveBinarySearch(arr, mid + 1, right, key);
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 5, 7, 9, 11}; 
        int key = 5;
        int idx = recursiveBinarySearch(arr, 0, arr.length - 1, key);
        if (idx == -1) System.out.println(key + " not found");
        else System.out.println(key + " found at index " + idx);
    }
}
