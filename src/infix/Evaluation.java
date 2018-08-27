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
    Stack<Integer> values = new Stack<Integer>();
    Stack<Character> operators = new Stack<Character>();
       
    
     public String evaluate(String fromInput) {
            char[] tokens = fromInput.toCharArray();
            
            for(int i=0; i <tokens.length; i++){        
                //skip white spaces
                if (tokens[i] == ' ')
                continue;
                
                System.out.println(tokens[i]);
     }
            
               return newResult;
     }
                
            
             
    
     
     public static boolean isOperator(char c){
         return( (c=='+') || (c=='/') ||(c=='*')||(c=='/'));   
     }
}
