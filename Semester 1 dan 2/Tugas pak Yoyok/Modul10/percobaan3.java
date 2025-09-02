package Modul10;
import java.util.Stack;
import java.util.Scanner;
public class percobaan3 {
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

private static String infixToPostfix(String expression) {
    StringBuilder output = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
        char c = expression.charAt(i);
        if (c == ' ') continue;

        if (Character.isDigit(c) || c == '.') {
            output.append(c);
            while (i + 1 < expression.length() &&
                  (Character.isDigit(expression.charAt(i + 1)) ||
                   expression.charAt(i + 1) == '.')) {
                output.append(expression.charAt(++i));
            }
            output.append(' ');
        }
        else if (c == '(') {
            stack.push(c);
        }
        else if (c == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                output.append(stack.pop()).append(' ');
            }
            stack.pop(); 
        }
        else { 
            while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                output.append(stack.pop()).append(' ');
            }
            stack.push(c);
        }
    }

    while (!stack.isEmpty()) {
        output.append(stack.pop()).append(' ');
    }

    return output.toString();
}
    private static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (c == ' ') continue;

            // Jika karakter adalah digit
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                // Baca seluruh digit bilangan
                while (i < postfix.length() && 
                      (Character.isDigit(postfix.charAt(i)) || 
                       postfix.charAt(i) == '.')) {
                    num.append(postfix.charAt(i++));
                }
                i--; 
                stack.push(Double.parseDouble(num.toString()));
            }
            else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '^':
                        stack.push(Math.pow(operand1, operand2));
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static double evaluateInfix(String expression) {
        String postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Test cases
        String[] testCases = {
            "3^5/2^7",
            "(3+5)*(2-7)",
            "(3+5)*2-7",
            "3+5*(2-7/(1+6))"
        };

        for (String testCase : testCases) {
            double result = evaluateInfix(testCase);
            System.out.println("Hasil " + testCase + " = " + result);
        }

        System.out.println("\nMode Interaktif (ketik 'exit' untuk keluar)");
        while (true) {
            System.out.print("Masukkan ekspresi aritmatika: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                double result = evaluateInfix(input);
                System.out.println("Hasil " + input + " = " + result);
            } catch (Exception e) {
                System.out.println("Ekspresi tidak valid: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}