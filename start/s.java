import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void reverseString(StringBuilder str) {
        Stack<String> stack = new Stack<>();

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                temp.append(str.charAt(i));
            } else {
                stack.push(temp.toString());
                temp.setLength(0);
            }
        }
        stack.push(temp.toString());
        str.setLength(0);
        while (!stack.isEmpty()) {
            str.append(stack.pop());
            if (!stack.isEmpty()) {
                str.append(" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringBuilder str = new StringBuilder(input);

        reverseString(str);

        System.out.println(str);

        sc.close();
    }
}