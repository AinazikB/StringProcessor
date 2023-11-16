package org.example;

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

    public double calculateExpression(String expression){
        return 0.0;
    }

}
