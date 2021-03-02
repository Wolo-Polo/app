package com.example.app.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * This method is used to convert the string to infix (Biểu thức đại số dạng trung tố)
     * @param expression
     * @return
     */
//    private String[] convertInfix(String expression){
//        String[] listString = expression.split("\\+|\\-|\\*|\\/|\\%|\\^|\\)|\\(");
//
//        return listString;
//    }
    private List<String> convertInfix(String expression){
        List<String> result = new ArrayList<>();
        int j=0;
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
                    || expression.charAt(i) == '/' || expression.charAt(i) == '(' || expression.charAt(i) == ')'){
                result.add(expression.substring(j, i));
                result.add(expression.substring(i, i+1));
                j=i+1;
            }else if(i == expression.length() - 1){
                result.add(expression.substring(j, i+1));
            }
        }

        return result;
    }

    private List<String> convertPostfix(List<String> infix){
        List<String> postFix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int index = 0;
        for(String i: infix){
            if(i.matches("[0-9]{1,13}(\\\\.[0-9]*)?")){
                postFix.add(i);
                continue;
            }else if(i.equals("(")){
                stack.push(i);
            }else if(i.equals(")")){
                String temp = stack.pop();
                while (!temp.equals("(")){
                    postFix.add(temp);
                    temp = stack.pop();
                };
            }else {
                while (stack.size() > 0 && getPriority(i) <= getPriority(stack.peek())){
                    postFix.add(stack.pop());
                }
                stack.push(i);
            }
        }

        while (!stack.empty()){
            postFix.add(stack.pop());
        }

        return postFix;
    }
    public int getPriority(String op)
    {
        if (op.equals("*") || op.equals("/") || op.equals("%"))
            return 2;
        if (op.equals("+") || op.equals("-"))
            return 1;
        return 0;
    }
    public Double calculate(String expression){
        List<String> postFix = convertPostfix(convertInfix(expression));
        Stack<Double> stack = new Stack<>();
        for(String i : postFix){
            if(i.matches("[0-9]{1,13}(\\\\.[0-9]*)?")){
                stack.push(Double.valueOf(i));
            }else if(i.equals("*") || i.equals("/") || i.equals("%") || i.equals("+") || i.equals("-")){
                Double num2 = stack.pop();
                Double num1 = stack.pop();
                Double result = null;
                if(i.equals("*")){
                    result = num1 * num2;
                }else if(i.equals("/")){
                    result = num1 / num2;
                }else if(i.equals("+")){
                    result = num1 + num2;
                }else if(i.equals("-")){
                    result = num1 - num2;
                }else if(i.equals("%")){
                    result = num1 % num2;
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }
}
