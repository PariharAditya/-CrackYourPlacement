import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char operation = '+';
        s = s.replaceAll("\\s", ""); // Remove all whitespaces

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0'); // Form the number
            }

            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (operation == '-') {
                    stack.push(-number);
                } else if (operation == '+') {
                    stack.push(number);
                } else if (operation == '*') {
                    stack.push(stack.pop() * number);
                } else if (operation == '/') {
                    stack.push(stack.pop() / number);
                }
                // due to this code will correctly handle sequences of numbers and operations in the input string
                operation = c;
                number = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        String expression = "3+2*2";
        System.out.println("Result: " + calculator.calculate(expression)); // Output: 7
    }
}
