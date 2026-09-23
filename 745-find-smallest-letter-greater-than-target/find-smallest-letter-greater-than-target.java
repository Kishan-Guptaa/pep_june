class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int[] arr = new int[letters.length];
        for(int i=0; i<letters.length; i++){
            arr[i] = letters[i] - target;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return letters[i];
            }
        }

        return letters[0];
    }
}