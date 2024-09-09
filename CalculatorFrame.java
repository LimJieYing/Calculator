import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorFrame implements ActionListener {
    
    private static String prevResult = "0";
    private static boolean clear = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setPreferredSize(new Dimension(300, 50));
        display.setEditable(true);
        display.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(display, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
                "Ans", "&", "^", "%",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(clear){
                        display.setText("");
                        clear = false;
                    }

                    if(label.equals("C")){
                        display.setText("");
                    }
                    else if(label.equals("Ans")){
                        display.setText(display.getText() + "Ans");

                    }
                    else if(label.equals("=")){
                        try{

                            String expression = display.getText().replace("Ans", prevResult);
                            prevResult = Integer.toString(Main.parseExp(expression));
                            display.setText(prevResult);

                        } catch (InvalidExpressionException ex){
                            display.setText("Error");
                            prevResult = "0";
                        }
                        clear = true;
                    }
                    else{
                        display.setText(display.getText() + label);
                    }
                }
            });

            buttonsPanel.add(button);

        }

        panel.add(buttonsPanel, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}