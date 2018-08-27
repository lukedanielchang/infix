/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infix;

import java.util.Stack;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author ldcha
 */
public class Evaluation {

    public boolean isEmpty = false;
    public String newResult = "this will be the result";
    Stack<Integer> operands = new Stack<Integer>();
    Stack<Character> operators = new Stack<Character>();

    public String evaluate(String fromInput) {
        char[] token = fromInput.toCharArray();

        for (int i = 0; i < token.length; i++) {
            //skip white spaces
            if (token[i] == ' ') {
                continue;
            } else if (token[i] >= '0' && token[i] <= '9') {
                //cast token[i] to string buffer to allow Int parsing to put into operands stack
                StringBuffer operandsBuff = new StringBuffer();
                
            } 
            else if (token[i] == '(') {
                operators.push(token[i]);

            } 
            else if (token[i] == ')') {
                operators.push(token[i]);
            } 
            else if ((token[i] == '+') || (token[i] == '-') || (token[i] == '*') || (token[i] == '/')) {
                operators.push(token[i]);
            }

            return newResult;
        }
                
            
             
    
     
     

    

    public static boolean isOperator(char c) {
        return ((c == '+') || (c == '/') || (c == '*') || (c == '/'));
    }
}
