import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frmCalculator;
    JTextArea displayArea;

    public GUI() {
        initialize();
    }

    private void initialize() {
        frmCalculator = new JFrame();
        frmCalculator.setTitle("Calculator");
        frmCalculator.setResizable(false);
        frmCalculator.setBounds(100, 100, 240, 310);
        frmCalculator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frmCalculator.getContentPane().setLayout(null);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBounds(10, 10, 215, 40);
        frmCalculator.getContentPane().add(displayArea);
        displayArea.setColumns(10);

        JButton btn7 = new JButton("7");
        btn7.addActionListener(new OperationSign(displayArea, "7"));
        btn7.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn7.setBounds(10, 60, 50, 50);
        frmCalculator.getContentPane().add(btn7);

        JButton btn8 = new JButton("8");
        btn8.addActionListener(new OperationSign(displayArea, "8"));
        btn8.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn8.setBounds(65, 60, 50, 50);
        frmCalculator.getContentPane().add(btn8);

        JButton btn9 = new JButton("9");
        btn9.addActionListener(new OperationSign(displayArea, "9"));
        btn9.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn9.setBounds(120, 60, 50, 50);
        frmCalculator.getContentPane().add(btn9);

        JButton btn6 = new JButton("6");
        btn6.addActionListener(new OperationSign(displayArea, "6"));
        btn6.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn6.setBounds(10, 115, 50, 50);
        frmCalculator.getContentPane().add(btn6);

        JButton btn5 = new JButton("5");
        btn5.addActionListener(new OperationSign(displayArea, "5"));
        btn5.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn5.setBounds(65, 115, 50, 50);
        frmCalculator.getContentPane().add(btn5);

        JButton btn4 = new JButton("4");
        btn4.addActionListener(new OperationSign(displayArea, "4"));
        btn4.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn4.setBounds(120, 115, 50, 50);
        frmCalculator.getContentPane().add(btn4);

        JButton btn3 = new JButton("3");
        btn3.addActionListener(new OperationSign(displayArea, "3"));
        btn3.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn3.setBounds(10, 170, 50, 50);
        frmCalculator.getContentPane().add(btn3);

        JButton btn2 = new JButton("2");
        btn2.addActionListener(new OperationSign(displayArea, "2"));
        btn2.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn2.setBounds(65, 170, 50, 50);
        frmCalculator.getContentPane().add(btn2);

        JButton btn1 = new JButton("1");
        btn1.addActionListener(new OperationSign(displayArea, "1"));
        btn1.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn1.setBounds(120, 170, 50, 50);
        frmCalculator.getContentPane().add(btn1);

        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new OperationSign(displayArea, "+"));
        btnPlus.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnPlus.setBounds(175, 60, 50, 50);
        frmCalculator.getContentPane().add(btnPlus);

        JButton btnMinus = new JButton("-");
        btnMinus.addActionListener(new OperationSign(displayArea, "-"));
        btnMinus.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnMinus.setBounds(175, 115, 50, 50);
        frmCalculator.getContentPane().add(btnMinus);

        JButton btnDivision = new JButton("/");
        btnDivision.addActionListener(new OperationSign(displayArea, "/"));
        btnDivision.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnDivision.setBounds(175, 170, 50, 50);
        frmCalculator.getContentPane().add(btnDivision);

        JButton btn0 = new JButton("0");
        btn0.addActionListener(new OperationSign(displayArea, "0"));
        btn0.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn0.setBounds(10, 225, 50, 50);
        frmCalculator.getContentPane().add(btn0);

        JButton btnComma = new JButton(".");
        btnComma.addActionListener(new OperationSign(displayArea, "."));
        btnComma.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnComma.setBounds(65, 225, 50, 50);
        frmCalculator.getContentPane().add(btnComma);

        JButton btnEqualsSign = new JButton("=");
        btnEqualsSign.addActionListener(e -> {
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
        btnEqualsSign.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnEqualsSign.setBounds(120, 225, 50, 50);
        frmCalculator.getContentPane().add(btnEqualsSign);

        JButton btnMultiply = new JButton("*");
        btnMultiply.addActionListener(new OperationSign(displayArea, "*"));
        btnMultiply.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnMultiply.setBounds(175, 225, 50, 50);
        frmCalculator.getContentPane().add(btnMultiply);

        frmCalculator.setVisible(true);
    }


//    public void go() {
//        frame.setSize(350, 300);
//        frame.setResizable(false);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        operationPanel.add(additionButton);
//        operationPanel.add(subtractionButton);
//        operationPanel.add(multiplicationButton);
//        operationPanel.add(divisionButton);
//        operationPanel.add(equalSignButton);
//        operationPanel.add(floatCommaButton);
//
//        nullButton.addActionListener(e -> displayArea.append("0"));
//        firstButton.addActionListener(e -> displayArea.append("1"));
//        secondButton.addActionListener(e -> displayArea.append("2"));
//        thirdButton.addActionListener(e -> displayArea.append("3"));
//        fourthButton.addActionListener(e -> displayArea.append("4"));
//        fifthButton.addActionListener(e -> displayArea.append("5"));
//        sixthButton.addActionListener(e -> displayArea.append("6"));
//        seventhButton.addActionListener(e -> displayArea.append("7"));
//        eightButton.addActionListener(e -> displayArea.append("8"));
//        ninthButton.addActionListener(e -> displayArea.append("9"));
//        additionButton.addActionListener(new OperationSign(displayArea, "+"));
//        subtractionButton.addActionListener(new OperationSign(displayArea, "-"));
//        multiplicationButton.addActionListener(new OperationSign(displayArea,"*"));
//        divisionButton.addActionListener(new OperationSign(displayArea,"/"));
//        floatCommaButton.addActionListener(new OperationSign(displayArea, "."));
//        equalSignButton.addActionListener(e -> {
//            String displayText = displayArea.getText();
//            StringBuilder stringToDigit = new StringBuilder();
//            double firstDigit = 0;
//            char operSign = 0;
//            if (displayText.charAt(0) == '-' || Character.isDigit(displayText.charAt(0))) {
//                stringToDigit.append(displayText.charAt(0));
//            }
//            for (int i = 1; i < displayText.length(); i++) {
//                char temp = displayText.charAt(i);
//                if (Character.isDigit(temp) || temp == '.') {
//                    stringToDigit.append(temp);
//                } else if (stringToDigit.length() == 0 && temp == '-' && !Character.isDigit(displayText.charAt(i - 1))) {
//                    stringToDigit.append(temp);
//                } else {
//                    operSign = temp;
//                    firstDigit = Double.parseDouble(stringToDigit.toString());
//                    stringToDigit.setLength(0);
//                }
//            }
//            double secondDigit = Double.parseDouble(stringToDigit.toString());
//            stringToDigit.setLength(0);
//            Calculator calculator = new Calculator();
//            switch (operSign) {
//                case '+':
//                    displayArea.setText(String.valueOf(calculator.addition(firstDigit, secondDigit)));
//                    break;
//                case '-':
//                    displayArea.setText(String.valueOf(calculator.subtraction(firstDigit, secondDigit)));
//                    break;
//                case '/':
//                    displayArea.setText(String.valueOf(calculator.division(firstDigit, secondDigit)));
//                    break;
//                case '*':
//                    displayArea.setText(String.valueOf(calculator.multiplication(firstDigit, secondDigit)));
//                    break;
//            }
//        });
//
//        digitsPanel.setPreferredSize(new Dimension(50, 100));
//        digitsPanel.add(nullButton);
//        digitsPanel.add(firstButton);
//        digitsPanel.add(secondButton);
//        digitsPanel.add(thirdButton);
//        digitsPanel.add(fourthButton);
//        digitsPanel.add(fifthButton);
//        digitsPanel.add(sixthButton);
//        digitsPanel.add(seventhButton);
//        digitsPanel.add(eightButton);
//        digitsPanel.add(ninthButton);
//
//        displayArea.setEditable(false);
//
//        frame.getContentPane().add(operationPanel, BorderLayout.CENTER);
//        frame.getContentPane().add(digitsPanel, BorderLayout.SOUTH);
//        frame.getContentPane().add(displayArea, BorderLayout.NORTH);

//        frame.setVisible(true);
//    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
