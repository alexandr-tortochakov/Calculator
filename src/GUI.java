import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    JFrame frmCalculator;
    JTextField displayArea;
    StringBuilder builder = new StringBuilder();
    boolean equalWasPressed = false;


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

        displayArea = new JTextField();
        displayArea.setHorizontalAlignment(SwingConstants.RIGHT);
        displayArea.setEditable(false);
        displayArea.setBounds(10, 10, 215, 40);
        frmCalculator.getContentPane().add(displayArea);
        displayArea.setColumns(10);

        JButton btn7 = new JButton("7");
        btn7.addActionListener(new DigitButton(builder, displayArea, '7'));
        btn7.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn7.setBounds(10, 60, 50, 50);
        frmCalculator.getContentPane().add(btn7);

        JButton btn8 = new JButton("8");
        btn8.addActionListener(new DigitButton(builder, displayArea, '8'));
        btn8.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn8.setBounds(65, 60, 50, 50);
        frmCalculator.getContentPane().add(btn8);

        JButton btn9 = new JButton("9");
        btn9.addActionListener(new DigitButton(builder, displayArea, '9'));
        btn9.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn9.setBounds(120, 60, 50, 50);
        frmCalculator.getContentPane().add(btn9);

        JButton btn6 = new JButton("6");
        btn6.addActionListener(new DigitButton(builder, displayArea, '6'));
        btn6.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn6.setBounds(10, 115, 50, 50);
        frmCalculator.getContentPane().add(btn6);

        JButton btn5 = new JButton("5");
        btn5.addActionListener(new DigitButton(builder, displayArea, '5'));
        btn5.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn5.setBounds(65, 115, 50, 50);
        frmCalculator.getContentPane().add(btn5);

        JButton btn4 = new JButton("4");
        btn4.addActionListener(new DigitButton(builder, displayArea, '4'));
        btn4.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn4.setBounds(120, 115, 50, 50);
        frmCalculator.getContentPane().add(btn4);

        JButton btn3 = new JButton("3");
        btn3.addActionListener(new DigitButton(builder, displayArea, '3'));
        btn3.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn3.setBounds(10, 170, 50, 50);
        frmCalculator.getContentPane().add(btn3);

        JButton btn2 = new JButton("2");
        btn2.addActionListener(new DigitButton(builder, displayArea, '2'));
        btn2.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn2.setBounds(65, 170, 50, 50);
        frmCalculator.getContentPane().add(btn2);

        JButton btn1 = new JButton("1");
        btn1.addActionListener(new DigitButton(builder, displayArea, '1'));
        btn1.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn1.setBounds(120, 170, 50, 50);
        frmCalculator.getContentPane().add(btn1);

        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new OperationSign(displayArea, '+', builder));
        btnPlus.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnPlus.setBounds(175, 60, 50, 50);
        frmCalculator.getContentPane().add(btnPlus);

        JButton btnMinus = new JButton("-");
        btnMinus.addActionListener(new OperationSign(displayArea, '-', builder));
        btnMinus.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnMinus.setBounds(175, 115, 50, 50);
        frmCalculator.getContentPane().add(btnMinus);

        JButton btnDivision = new JButton("/");
        btnDivision.addActionListener(new OperationSign(displayArea, '/', builder));
        btnDivision.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnDivision.setBounds(175, 170, 50, 50);
        frmCalculator.getContentPane().add(btnDivision);

        JButton btn0 = new JButton("0");
        btn0.addActionListener(new DigitButton(builder, displayArea, '0'));
        btn0.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btn0.setBounds(10, 225, 50, 50);
        frmCalculator.getContentPane().add(btn0);

        JButton btnComma = new JButton(".");
        btnComma.addActionListener(new OperationSign(displayArea, '.', builder));
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
            double temp = 0;
            switch (operSign) {
                case '+':
                    temp = calculator.addition(firstDigit, secondDigit);
                    break;
                case '-':
                    temp = calculator.subtraction(firstDigit, secondDigit);
                    break;
                case '/':
                    temp = calculator.division(firstDigit, secondDigit);
                    break;
                case '*':
                    temp = calculator.multiplication(firstDigit, secondDigit);
                    break;
            }
            double fractionalPart = temp - (int) temp;
            String tempString;
            if (fractionalPart < 1.e-8) {
                tempString = String.valueOf((int) temp);
            } else tempString = String.valueOf(temp);
            displayArea.setText(tempString);
            builder.setLength(0);
            builder.append(tempString);
            equalWasPressed = true;
        });
        btnEqualsSign.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnEqualsSign.setBounds(120, 225, 50, 50);
        frmCalculator.getContentPane().add(btnEqualsSign);

        JButton btnMultiply = new JButton("*");
        btnMultiply.addActionListener(new OperationSign(displayArea, '*', builder));
        btnMultiply.setFont(new Font("Sitka Text", Font.BOLD, 15));
        btnMultiply.setBounds(175, 225, 50, 50);
        frmCalculator.getContentPane().add(btnMultiply);

        frmCalculator.setVisible(true);

    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }

    public class DigitButton implements ActionListener {
        StringBuilder builder;
        JTextField field;
        char digit;

        public DigitButton(StringBuilder builder, JTextField field, char digit) {
            this.builder = builder;
            this.field = field;
            this.digit = digit;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (equalWasPressed) {
                builder.setLength(0);
                equalWasPressed = false;
            }
            builder.append(digit);
            field.setText(builder.toString());
        }
    }

    public class OperationSign implements ActionListener {
        JTextField displayArea;
        char sign;
        StringBuilder builder;

        public OperationSign(JTextField displayArea, char sign, StringBuilder builder) {
            this.displayArea = displayArea;
            this.sign = sign;
            this.builder = builder;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            equalWasPressed = false;
            if (displayArea.getText().length() == 0 && sign != '-') {
                return;
            } else if (displayArea.getText().length() == 0 && sign == '-') {
                builder.append(sign);
                displayArea.setText(builder.toString());
                return;
            }
            char lastChar = displayArea.getText().charAt(displayArea.getText().length() - 1);
            if (Character.isDigit(lastChar) ) {
                builder.append(sign);
                displayArea.setText(builder.toString());
            }
        }
    }
}
