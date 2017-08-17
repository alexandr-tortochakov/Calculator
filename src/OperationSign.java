import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationSign implements ActionListener {
    JTextArea displayArea;
    String sign;

    public OperationSign(JTextArea displayArea, String sign) {
        this.displayArea = displayArea;
        this.sign = sign;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (displayArea.getText().length() == 0 && !sign.equals("-")) {
            return;
        } else if (displayArea.getText().length() == 0 && sign.equals("-")) {
            displayArea.append(sign);
            return;
        }
        char lastChar = displayArea.getText().charAt(displayArea.getText().length() - 1);
        if (Character.isDigit(lastChar) ) {
            displayArea.append(sign);
        }
    }
}
