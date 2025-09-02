package Belajar;
import java.util.Stack;
public class PostFix {
    public static void main(String[] args) {
        String expr = "((3+5)*2)-7";
        System.out.println(toPostfix(expr));
    }

    static String toPostfix(String expr) {
        Stack<Character> stack = new Stack<>();
        StringBuilder out = new StringBuilder();
        
        for (char c : expr.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                out.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(')
                    out.append(stack.pop()).append(' ');
                stack.pop();
            } else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c))
                    out.append(stack.pop()).append(' ');
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            out.append(stack.pop()).append(' ');

        return out.toString().trim();
    }

    static int priority(char op) {
        return (op == '+' || op == '-') ? 1 : (op == '*' || op == '/') ? 2 : 0;
    }
}