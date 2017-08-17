import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    JFrame frame = new JFrame("Calculator");
    JTextArea displayArea = new JTextArea();
    JPanel operationPanel = new JPanel();
    JPanel digitsPanel = new JPanel();
    JButton additionButton = new JButton("+");
    JButton subtractionButton = new JButton("-");
    JButton multiplicationButton = new JButton("*");
    JButton divisionButton = new JButton("/");
    JButton equalSignButton = new JButton("=");
    JButton floatCommaButton = new JButton(".");

    JButton nullButton = new JButton("0");
    JButton firstButton = new JButton("1");
    JButton secondButton = new JButton("2");
    JButton thirdButton = new JButton("3");
    JButton fourthButton = new JButton("4");
    JButton fifthButton = new JButton("5");
    JButton sixthButton = new JButton("6");
    JButton seventhButton = new JButton("7");
    JButton eightButton = new JButton("8");
    JButton ninthButton = new JButton("9");

    public void go() {
        frame.setSize(450, 450);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        operationPanel.add(additionButton);
        operationPanel.add(subtractionButton);
        operationPanel.add(multiplicationButton);
        operationPanel.add(divisionButton);
        operationPanel.add(equalSignButton);
        operationPanel.add(floatCommaButton);

        nullButton.addActionListener(e -> displayArea.append("0"));
        firstButton.addActionListener(e -> displayArea.append("1"));
        secondButton.addActionListener(e -> displayArea.append("2"));
        thirdButton.addActionListener(e -> displayArea.append("3"));
        fourthButton.addActionListener(e -> displayArea.append("4"));
        fifthButton.addActionListener(e -> displayArea.append("5"));
        sixthButton.addActionListener(e -> displayArea.append("6"));
        seventhButton.addActionListener(e -> displayArea.append("7"));
        eightButton.addActionListener(e -> displayArea.append("8"));
        ninthButton.addActionListener(e -> displayArea.append("9"));
        additionButton.addActionListener(new OperationSign(displayArea, "+"));
        subtractionButton.addActionListener(new OperationSign(displayArea, "-"));
        multiplicationButton.addActionListener(new OperationSign(displayArea,"*"));
        divisionButton.addActionListener(new OperationSign(displayArea,"/"));
        floatCommaButton.addActionListener(new OperationSign(displayArea, "."));
        equalSignButton.addActionListener(e -> {
            String displayText = displayArea.getText();
            StringBuilder stringToDigit = new StringBuilder();
            double firstDigit = 0;
            char operSign = 0;
            if (displayText.charAt(0) == '-' || Character.isDigit(displayText.charAt(0))) {
                stringToDigit.append(displayText.charAt(0));
            }
            for (int i = 1; i < displayText.length(); i++) {
                char temp = displayText.charAt(i);
                if (Character.isDigit(temp) || temp == '.') {
                    stringToDigit.append(temp);
                } else if (stringToDigit.length() == 0 && temp == '-' && !Character.isDigit(displayText.charAt(i - 1))) {
                    stringToDigit.append(temp);
                } else {
                    operSign = temp;
                    firstDigit = Double.parseDouble(stringToDigit.toString());
                    stringToDigit.setLength(0);
                }
            }
            double secondDigit = Double.parseDouble(stringToDigit.toString());
            stringToDigit.setLength(0);
            Calculator calculator = new Calculator();
            switch (operSign) {
                case '+':
                    displayArea.setText(String.valueOf(calculator.addition(firstDigit, secondDigit)));
                    break;
                case '-':
                    displayArea.setText(String.valueOf(calculator.subtraction(firstDigit, secondDigit)));
                    break;
                case '/':
                    displayArea.setText(String.valueOf(calculator.division(firstDigit, secondDigit)));
                    break;
                case '*':
                    displayArea.setText(String.valueOf(calculator.multiplication(firstDigit, secondDigit)));
                    break;
            }
        });

        digitsPanel.setLayout(new BoxLayout(digitsPanel, BoxLayout.Y_AXIS));
        digitsPanel.add(nullButton);
        digitsPanel.add(firstButton);
        digitsPanel.add(secondButton);
        digitsPanel.add(thirdButton);
        digitsPanel.add(fourthButton);
        digitsPanel.add(fifthButton);
        digitsPanel.add(sixthButton);
        digitsPanel.add(seventhButton);
        digitsPanel.add(eightButton);
        digitsPanel.add(ninthButton);

        displayArea.setRows(1);
        displayArea.setColumns(4);
        displayArea.setEditable(false);

        frame.getContentPane().add(operationPanel, BorderLayout.EAST);
        frame.getContentPane().add(digitsPanel, BorderLayout.NORTH);
        frame.getContentPane().add(displayArea, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.go();
    }
}
