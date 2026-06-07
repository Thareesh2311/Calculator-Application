import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame
        implements ActionListener {
    JLabel titleLabel,
            num1Label,
            num2Label;

    JTextField num1Field,
            num2Field;

    JButton addButton,
            subButton,
            mulButton,
            divButton,
            clearButton;

    JTextArea resultArea;

    public CalculatorGUI() {

        setTitle("Calculator Application");

        setSize(600, 550);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(
                new Color(240, 248, 255));
        titleLabel = new JLabel(
                "CALCULATOR APPLICATION");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 26));

        titleLabel.setBounds(120, 20, 400, 40);

        add(titleLabel);

        num1Label = new JLabel("Enter Number 1:");

        num1Label.setFont(
                new Font("Arial", Font.PLAIN, 18));

        num1Label.setBounds(60, 100, 180, 30);

        add(num1Label);

        num1Field = new JTextField();

        num1Field.setBounds(250, 100, 220, 35);

        add(num1Field);

        num2Label = new JLabel("Enter Number 2:");

        num2Label.setFont(
                new Font("Arial", Font.PLAIN, 18));

        num2Label.setBounds(60, 170, 180, 30);

        add(num2Label);

        num2Field = new JTextField();

        num2Field.setBounds(250, 170, 220, 35);

        add(num2Field);

        addButton = new JButton("Add");

        addButton.setBounds(60, 260, 100, 45);

        addButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        addButton.addActionListener(this);

        add(addButton);

        subButton = new JButton("Subtract");

        subButton.setBounds(180, 260, 120, 45);

        subButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        subButton.addActionListener(this);

        add(subButton);
        mulButton = new JButton("Multiply");

        mulButton.setBounds(320, 260, 120, 45);

        mulButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        mulButton.addActionListener(this);

        add(mulButton);

        divButton = new JButton("Divide");

        divButton.setBounds(460, 260, 100, 45);

        divButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        divButton.addActionListener(this);

        add(divButton);

        clearButton = new JButton("Clear");

        clearButton.setBounds(220, 340, 150, 45);

        clearButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        clearButton.addActionListener(this);

        add(clearButton);

        resultArea = new JTextArea();

        resultArea.setBounds(100, 420, 380, 60);

        resultArea.setFont(
                new Font("Monospaced",
                        Font.BOLD, 18));

        resultArea.setEditable(false);

        add(resultArea);

        setVisible(true);
    }
    public double add(double a, double b) {

        return a + b;
    }

    public double subtract(double a, double b) {

        return a - b;
    }

    public double multiply(double a, double b) {

        return a * b;
    }

    public double divide(double a, double b) {

        return a / b;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if(e.getSource() == clearButton) {

                num1Field.setText("");
                num2Field.setText("");
                resultArea.setText("");

                return;
            }

            double num1 =
                    Double.parseDouble(
                            num1Field.getText());

            double num2 =
                    Double.parseDouble(
                            num2Field.getText());

            double result = 0;

            if(e.getSource() == addButton) {

                result = add(num1, num2);

                resultArea.setText(
                        "Addition = " + result);
            }

            else if(e.getSource() == subButton) {

                result = subtract(num1, num2);

                resultArea.setText(
                        "Subtraction = " + result);
            }

            else if(e.getSource() == mulButton) {

                result = multiply(num1, num2);

                resultArea.setText(
                        "Multiplication = " + result);
            }

            else if(e.getSource() == divButton) {

                if(num2 == 0) {

                    resultArea.setText(
                            "Cannot Divide By Zero!");

                    return;
                }

                result = divide(num1, num2);

                resultArea.setText(
                        "Division = " + result);
            }

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Please Enter Valid Numbers!");
        }
    }

    public static void main(String[] args) {

        new CalculatorGUI();
    }
}