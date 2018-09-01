package infix;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Infix extends JFrame {
    //create input, button, and output components

    public JTextField inputText = new JTextField(20);
    private JTextField resultText = new JTextField(20);

    private JButton evaluateButton = new JButton("Evaluate");

    //create GUI constructor
    public Infix() {
        //create JFrame
        JFrame frame = new JFrame("Infix Expression Evaluator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set Font
        Font f = new Font("Roboto", Font.PLAIN, 30);
        //create panels
        //create inputPanel
        JPanel inputPanel = new JPanel();
        //create JButton panel
        JPanel buttonPanel = new JPanel();
        //create resultPanel
        JPanel resultPanel = new JPanel();

        //create Labels
        JLabel inputLabel = new JLabel("input:  ", SwingConstants.CENTER);
        JLabel resultLabel = new JLabel("result:  ", SwingConstants.CENTER);
        resultText.setEditable(false);
        //create button
        evaluateButton = new JButton("evaluate");
        evaluateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Evaluation eval = new Evaluation();

                String newResult = eval.calculateExpression(inputText.getText());

                String getValue = inputText.getText();
                resultText.setText(newResult);
            }
        }
        );
        //Set Font to fields
        inputLabel.setFont(f);
        inputLabel.repaint();
        resultLabel.setFont(f);
        resultLabel.repaint();
        inputText.setFont(f);
        inputText.repaint();
        resultText.setFont(f);
        resultText.repaint();
        evaluateButton.setFont(f);
        evaluateButton.repaint();
        evaluateButton.setPreferredSize(new Dimension(500, 50));
        
        //add labels to Panels
        inputPanel.add(inputLabel);
        inputPanel.add(inputText);
        buttonPanel.add(evaluateButton);
        resultPanel.add(resultLabel);
        resultPanel.add(resultText);
        //add Panels to frame with BorderLayout
        frame.add(inputPanel, BorderLayout.PAGE_START);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.PAGE_END);
        frame.setSize(900, 275);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Infix infix = new Infix();
    }

}
