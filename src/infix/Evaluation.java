/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infix;

import java.util.Stack;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Evaluation {

    public boolean isEmpty = false;
    public String newResult = "";
    Stack<Integer> operands = new Stack<Integer>();
    Stack<Character> operators = new Stack<Character>();

    public String evaluate(String fromInput) {
        char[] token = fromInput.toCharArray();

        for (int i = 1; i < token.length; i++) {
            //skip white spaces
            if (token[i] == ' ') {
                continue;
            } else if (token[i] >= '0' && token[i] <= '9') {
                //cast token[i] to string buffer to allow Int parsing to put into operands stack
                StringBuffer operandsBuff = new StringBuffer();
                while (i < token.length && token[i] >= '0' && token[i] <= '9') {
                    operandsBuff.append(token[i++]);
                }
                operands.push(Integer.parseInt(operandsBuff.toString()));
            } else if (token[i] == '(') {
                operators.push(token[i]);

            } else if (token[i] == ')') {
                operators.push(token[i]);
                while (operators.peek() != '(') {
                    operands.push(doOp(operators.pop(), operands.pop(), operands.pop()));
                }
            } else if ((token[i] == '+') || (token[i] == '-') || (token[i] == '*') || (token[i] == '/')) {
                while (!operators.empty() && opPrecedence(token[i], operators.peek())) {
                    operands.push(doOp(operators.pop(), operands.pop(), operands.pop()));
                    operators.push(token[i]);

                }
            }
            while (!operators.empty()) {
                operands.push(doOp(operators.pop(), operands.pop(), operands.pop()));
            }
            System.out.println(i);
        }
        return operands.pop().toString();
    }

    public static boolean opPrecedence(char oper1, char oper2) {
        if (oper2 == '(' || oper2 == ')') {
            return false;
        }
        if ((oper1 == '*') || (oper1 == '/') && (oper2 == '+') || (oper2 == '-')) {
            return false;
        } else {
            return true;
        }
    }

    public static int doOp(char op, int a, int b) {
        switch (op) {
            case '+':
            
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == '0') {
                    throw new ArithmeticException("Cannot divide by 0");
                }
                return a / b;

        }
        return 0;
    }
}
