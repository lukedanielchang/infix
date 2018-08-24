package infix;

import java.awt.*;
import javax.swing.*;

public class Infix extends JFrame {
    //create input, button, and output components

    private JLabel inputLabel = new JLabel("input", JLabel.CENTER);
    private JLabel resultLabel = new JLabel("result", JLabel.CENTER);
    private JTextField inputText = new JTextField("");
    private JTextField resultText = new JTextField("");

    private JButton evaluateButton = new JButton("Evaluate");

    //create GUI constructor
    public Infix() {

        //create inputPanel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setVisible(true);

        inputLabel = new JLabel("input");
        inputPanel.add(inputLabel);

        inputText = new JTextField("");
        inputText.setEditable(true);
        inputPanel.add(inputText);
        
        //create JButton panel
        JPanel buttonPanel = new JPanel();
        evaluateButton = new JButton("evaluate");
        buttonPanel.add(evaluateButton);

        //create resultPanel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.X_AXIS));
        resultLabel = new JLabel("result");
        resultPanel.add(resultLabel);

        resultText = new JTextField("");
        resultText.setEditable(false);
        resultPanel.add(resultText);
        
        //create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 5, 5));
        mainPanel.setVisible(true);
        
        //add thePanel to mainPanel
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
              
        Infix infix = new Infix();
        infix.setTitle("Infix Expression Evaluator");
        infix.setSize(500, 250);
        infix.setVisible(true);
        infix.setBackground(Color.blue);
        infix.setLocationRelativeTo(null);
        infix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
