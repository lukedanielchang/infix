/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infix;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Beach Haven
 */
public class Evaluation{

    public static String calculateExpression(String expression) throws EvalExceptions {

        Stack<Long> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        if (!isValidExpression(expression)) {
            System.out.println("Not a valid expression to evaluate");
            return "0";
        }

        int i = 0;
        String currentInteger = null;
        while (i < expression.length()) {

            // System.out.println(expression.charAt(i));
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {

                currentInteger = expression.charAt(i) + "";
                i++;
                while (i != expression.length() && (expression.charAt(i) >= '0' && expression.charAt(i) <= '9')) {
                    currentInteger = currentInteger + expression.charAt(i);
                    i++;
                }

                operandStack.push(Long.parseLong(currentInteger));
            } else {

                if (expression.charAt(i) == ')') {

                    while (operatorStack.peek() != '(') {
                        performArithmeticOperation(operandStack, operatorStack);
                    }
                    operatorStack.pop();
                } else {

                    Character currentOperator = expression.charAt(i);
                    Character lastOperator = (operatorStack.isEmpty() ? null : operatorStack.peek());

                    if (lastOperator != null && checkPrecedence(currentOperator, lastOperator)) {
                        performArithmeticOperation(operandStack, operatorStack);
                    }
                    operatorStack.push(expression.charAt(i));

                }
                i++;
            }

        }

        while (!operatorStack.isEmpty()) {
            performArithmeticOperation(operandStack, operatorStack);
        }

        Long result = operandStack.pop();
        return result.toString();

    }

    public static void performArithmeticOperation(Stack<Long> operandStack, Stack<Character> operatorStack) throws EvalExceptions {
        try {
            long value1 = operandStack.pop();
            long value2 = operandStack.pop();
            char operator = operatorStack.pop();

            long intermediateResult = arithmeticOperation(value1, value2, operator);
            operandStack.push(intermediateResult);
        } catch (EmptyStackException e) {
            throw new EvalExceptions("Not a Valid Expression");
        }
    }

    public static boolean checkPrecedence(Character operator1, Character operator2) {

        List<Character> precedenceList = new ArrayList<>();
        precedenceList.add('(');
        precedenceList.add(')');
        precedenceList.add('/');
        precedenceList.add('*');
        precedenceList.add('%');
        precedenceList.add('+');
        precedenceList.add('-');

        if (operator2 == '(') {
            return false;
        }

        if (precedenceList.indexOf(operator1) > precedenceList.indexOf(operator2)) {
            return true;
        } else {
            return false;
        }

    }

    public static long arithmeticOperation(long value2, long value1, Character operator) throws EvalExceptions{
        
        long result = 0;

        switch (operator) {

            case '+':
                result = value1 + value2;
                break;

            case '-':
                result = value1 - value2;
                break;

            case '*':
                result = value1 * value2;
                break;

            case '/':
               if(value2>0){
                    result = value1 / value2;
                } 
               else{
                   throw new EvalExceptions("You cannot divide by 0");
                }
                break;

            case '%':
                result = value1 % value2;
                break;

            default:
                result = value1 + value2;

        }
        return result;
    }

    public static boolean isValidExpression(String expression) {

        if ((!Character.isDigit(expression.charAt(0)) && !(expression.charAt(0) == '('))
                || (!Character.isDigit(expression.charAt(expression.length() - 1)) && !(expression.charAt(expression.length() - 1) == ')'))) {
            return false;
        }

        ArrayList<Character> validCharactersSet = new ArrayList<>();
        validCharactersSet.add('*');
        validCharactersSet.add('+');
        validCharactersSet.add('-');
        validCharactersSet.add('/');
        validCharactersSet.add('%');
        validCharactersSet.add('(');
        validCharactersSet.add(')');

        Stack<Character> validParenthesisCheck = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            if (!Character.isDigit(expression.charAt(i)) && !validCharactersSet.contains(expression.charAt(i))) {
                return false;
            }

            if (expression.charAt(i) == '(') {
                validParenthesisCheck.push(expression.charAt(i));
            }

            if (expression.charAt(i) == ')') {

                if (validParenthesisCheck.isEmpty()) {
                    return false;
                }
                validParenthesisCheck.pop();
            }
        }

        if (validParenthesisCheck.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
