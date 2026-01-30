import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    //Adding the jpanels, jbuttons and jTexfield for the calculator.
    JPanel buttonPanel = new JPanel();
    JButton[] buttons = new JButton[10];
    String[] operators = {"+", "-", "/", "*",};
    JButton[] symbols = new JButton[operators.length];


    String operator = null;
    String a = null;
    String b = null;


    JPanel numberLabelPanel = new JPanel();
    JPanel operatorPanel = new JPanel();
    JLabel numberLabel = new JLabel("0");



    Calculator(){
        addButtons();
        addNumberField();
    }

    /**
     * This method is simply to display the window.
     * */
    void displayScreen(){
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(numberLabelPanel, BorderLayout.NORTH);
        this.add(operatorPanel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    /**
     * This method adds the number buttons to the frame. It also sets the buttons Panel preferred size
     * */
    private void addButtons(){
        buttonPanel.setPreferredSize(new Dimension(400, 500));
        buttonPanel.setLayout(new GridLayout(4,3));
        for (int i=0; i<buttons.length; i++){
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.RED);
            buttons[i].setForeground(Color.ORANGE);
            int finalI = i;
            buttons[i].addActionListener((e -> {
                if (numberLabel.getText().equals("0")){
                    numberLabel.setText("");
                }
                numberLabel.setText(String.valueOf(numberLabel.getText() + buttons[finalI].getText()));
                System.out.println(buttons[finalI].getText());
            }));
            buttonPanel.add(buttons[i]);
        }
        /**
         * This is for operators. It decides the operator the computer is going to use to do the calculations
         * */
        operatorPanel.setPreferredSize(new Dimension(100, 100));
        operatorPanel.setLayout(new GridLayout(1, 4));
        for (int i=0; i<operators.length; i++){
            symbols[i] = new JButton(operators[i]);
            symbols[i].setFocusable(false);
            symbols[i].setBackground(Color.RED);
            symbols[i].setForeground(Color.ORANGE);

            int finalI = i;
            symbols[i].addActionListener((e -> {
                operator = String.valueOf(symbols[finalI].getText());

                if (symbols[finalI].getText().equals(operators[0])){
                    if (operator != null){
                        a = numberLabel.getText();
                        System.out.println(a);
                        numberLabel.setText("0");
                    }
                }
                if (symbols[finalI].getText().equals(operators[1])){
                    if (operator != null){
                        a = numberLabel.getText();
                        System.out.println(a);
                        numberLabel.setText("0");
                    }
                }
                if (symbols[finalI].getText().equals(operators[2])){
                    if (operator != null){
                        a = numberLabel.getText();
                        System.out.println(a);
                        numberLabel.setText("0");
                    }
                }
                if (symbols[finalI].getText().equals(operators[3])){
                    if (operator != null){
                        a = numberLabel.getText();
                        System.out.println(a);
                        numberLabel.setText("0");
                    }
                }

                System.out.println(operator);
            }));
            operatorPanel.add(symbols[i]);
        }
        /**
         * Adding the two special buttons for erasing and getting answers. Buttons AC & =
         * */
        JButton equals = new JButton("=");
        equals.setFocusable(false);
        equals.setBackground(Color.RED);
        equals.setForeground(Color.ORANGE);
        equals.addActionListener(e -> {
            if (a!=null && operator != null){
                b = numberLabel.getText();

                if (operator.equals(operators[0])){
                    numberLabel.setText(add(Double.parseDouble(a), Double.parseDouble(b)));
                }
                else if (operator.equals(operators[1])){
                    numberLabel.setText(sub(Double.parseDouble(a), Double.parseDouble(b)));
                }
                else if (operator.equals(operators[2])){
                    numberLabel.setText(divide(Double.parseDouble(a), Double.parseDouble(b)));
                }
                else if (operator.equals(operators[3])){
                    numberLabel.setText(multiply(Double.parseDouble(a), Double.parseDouble(b)));
                }

                a = null;
                operator = null;
            }
        });

        JButton clear = new JButton("AC");
        clear.setFocusable(false);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.ORANGE);
        clear.addActionListener(e -> {
            a = null;
            b = null;
            numberLabel.setText("0");
        });
        buttonPanel.add(equals);
        buttonPanel.add(clear);

    }
/**
 * This method adds the bar to the screen. on this text field the user will see
 * their numbers, and answers
 * */
    private void addNumberField(){
        numberLabel.setText("0");
        numberLabel.setPreferredSize(new Dimension(50,50));
        numberLabelPanel.setPreferredSize(new Dimension(400, 100));
        numberLabelPanel.add(numberLabel);
    }

    /**
     * These next few methods are simply to handle the operations of the calculator
     * */
    private String add(double a, double b){
        return String.valueOf((a + b));
    }
    private String sub(double a, double b){
        return String.valueOf((a - b));
    }
    private String multiply(double a, double b){
        return String.valueOf((a * b));
    }
    private String divide(double a, double b){
        String ans = null;
        if (b == 0){
            return "0";
        }else {
            ans = String.valueOf((a/b));
        }

        return ans;
    }
}
