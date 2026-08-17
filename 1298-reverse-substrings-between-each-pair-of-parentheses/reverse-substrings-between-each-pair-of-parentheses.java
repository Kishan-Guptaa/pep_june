class Solution {
    public String reverseParentheses(String s) {

        char[] arr = s.toCharArray();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(') {
                st.push(i);
            }

            else if (arr[i] == ')') {

                int left = st.pop();
                int right = i;

                while (left + 1 < right) {

                    char temp = arr[left + 1];
                    arr[left + 1] = arr[right - 1];
                    arr[right - 1] = temp;

                    left++;
                    right--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : arr) {
            if (ch != '(' && ch != ')') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}