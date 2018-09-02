/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infix;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ldcha
 */
public class EvalExceptions extends Exception{
    JFrame errorFrame = new JFrame();
     Font f = new Font("Roboto", Font.PLAIN, 30);
    public EvalExceptions(String message){
       JOptionPane.showMessageDialog(errorFrame, message);
    }
}
