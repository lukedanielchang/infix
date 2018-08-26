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
    public Stack operatorS = new Stack();
    public Stack operandS = new Stack();

    
     public String evaluate(String fromInput) {
            StringTokenizer tokenString = new StringTokenizer(fromInput);
            
            for (int i =1; tokenString.hasMoreTokens(); i++){
                System.out.println("Token " + i +":" + tokenString.nextToken());
            }
                return newResult;
    }
}
