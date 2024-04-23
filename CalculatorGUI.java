 import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField display;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        display = new JTextField();
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sin", "cos", "tan", "C"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("=")) {
                String result = Calculator.evaluate(display.getText());
                display.setText(result);
            } else if (command.equals("C")) {
                display.setText("");
            } else if (command.equals("sin")) {
                double value = Double.parseDouble(display.getText());
                display.setText(Double.toString(Math.sin(Math.toRadians(value))));
            } else if (command.equals("cos")) {
                double value = Double.parseDouble(display.getText());
                display.setText(Double.toString(Math.cos(Math.toRadians(value))));
            } else if (command.equals("tan")) {
                double value = Double.parseDouble(display.getText());
                display.setText(Double.toString(Math.tan(Math.toRadians(value))));
            } else {
                display.setText(display.getText() + command);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI());
    }

}
