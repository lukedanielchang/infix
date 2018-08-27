package infix;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Infix extends JFrame {
    //create input, button, and output components

    private JLabel inputLabel = new JLabel("input", JLabel.CENTER);
    private JLabel resultLabel = new JLabel("result", JLabel.CENTER);
    public JTextField inputText = new JTextField("");
    private JTextField resultText = new JTextField("");

    private JButton evaluateButton = new JButton("Evaluate");

    public String input = "";
    public String result = "test";

    //create GUI constructor
    public Infix() {
        //create inputPanel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setVisible(true);
        // inputPanel.setPreferredSize(new Dimension(600, 800));

        inputLabel = new JLabel("input");
        inputPanel.add(inputLabel);

        inputText = new JTextField("");
        inputText.setEditable(true);
        inputPanel.add(inputText);

        //create JButton panel
        JPanel buttonPanel = new JPanel();
        evaluateButton = new JButton("evaluate");
        evaluateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Evaluation eval = new Evaluation();
                
                String newResult = eval.evaluate(inputText.getText());
                
               // String getValue = inputText.getText();
               resultText.setText(newResult);
                resultText.setVisible(true);
            }
        }
        );
        buttonPanel.add(evaluateButton);

        //create resultPanel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.X_AXIS));
        resultLabel = new JLabel("result");
        resultPanel.add(resultLabel);
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

        /*    JFrame theFrame = new JFrame();
        theFrame.add(inputPanel);
        theFrame.add(buttonPanel);
        theFrame.add(resultPanel);
        theFrame.setVisible(true);
       theFrame.add(mainPanel);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
    }

    public static void main(String[] args) {
        Infix infix = new Infix();
        infix.setTitle("Infix Expression Evaluator");
        infix.setSize(2000, 600);
        infix.setVisible(true);
        infix.setLocationRelativeTo(null);
        infix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
