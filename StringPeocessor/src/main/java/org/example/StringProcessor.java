package org.example;

import java.util.Stack;
import java.util.Stack;
public class StringProcessor {
    public boolean isStrongPassword(String password){
        if(password == null || password.length() < 8) {
            return false;
        }
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = true;
        boolean symbol = true;
        
        for (char ch : password.toCharArray()){
            if (Character.isUpperCase(ch)){
                upperCase = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCase = true;
            } else if (Character.isDigit(ch)) {
                digit = true;
            } else if ("!@#$%^&*()-_+=<>?{}[]~".contains(String.valueOf(ch))) {
                symbol = true;
            }
        }
        return upperCase && lowerCase && digit && symbol;
    }

    public int calculateDigits(String sentence){
        int count = 0;
        for (char ch : sentence.toCharArray()){
            if (Character.isDigit(ch)){
                count += 1;
            }
        }
        return count;
    }

    public int calculateWords(String sentence){
        int count = 0;
        for (char ch : sentence.toCharArray()){
            if (ch == ' '){
                count += 1;
            }
        }
        return count + 1;
    }



    public static double calculateExpression(String expression) {
            char[] tokens = expression.toCharArray();

            Stack<Double> values = new Stack<>();
            Stack<Character> operators = new Stack<>();

            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i] == ' ')
                    continue;

                if (tokens[i] >= '0' && tokens[i] <= '9') {
                    StringBuilder sb = new StringBuilder();
                    while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')) {
                        sb.append(tokens[i++]);
                    }
                    values.push(Double.parseDouble(sb.toString()));
                    i--;
                } else if (tokens[i] == '(') {
                    operators.push(tokens[i]);
                } else if (tokens[i] == ')') {
                    while (operators.peek() != '(') {
                        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.pop();
                } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                    while (!operators.empty() && hasPrecedence(tokens[i], operators.peek())) {
                        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.push(tokens[i]);
                }
            }

            while (!operators.empty()) {
                values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
            }

            return values.pop();
        }

        private static boolean hasPrecedence(char op1, char op2) {
            return (op2 != '(' && op2 != ')') && (getPrecedence(op1) <= getPrecedence(op2));
        }

        private static double applyOperator(char operator, double b, double a) {
            switch (operator) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                    return a / b;
            }
            return 0;
        }

        private static int getPrecedence(char operator) {
            if (operator == '+' || operator == '-')
                return 1;
            else if (operator == '*' || operator == '/')
                return 2;
            return 0;
        }
}


