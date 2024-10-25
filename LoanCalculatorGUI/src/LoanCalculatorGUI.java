import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanCalculatorGUI extends JFrame{
    private JTextField LoanAmount;
    private JTextField Duration;
    private JTextField InterestRate;
    private JCheckBox EarlyPayment;
    private JTextField MonthlyPayment;
    private JButton calculatePaymentButton;
    private JButton exitButton;
    private JPanel LoanCalculatorGUI;

    public LoanCalculatorGUI(){
        setContentPane(LoanCalculatorGUI);
        setTitle("Kwendo C026-01-0973/2022");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);


        calculatePaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    double principal = Double.parseDouble(LoanAmount.getText());
                    int duration = Integer.parseInt(Duration.getText());
                    double rate = Double.parseDouble(InterestRate.getText());

                    // Calculate EMI
                    double monthlyRate = rate / (12 * 100);
                    double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, duration)) / (Math.pow(1 + monthlyRate, duration) - 1);

                    // Display EMI result
                    MonthlyPayment.setText(String.format("%.2f", emi));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid amount.");}
                            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
    }
        public static void main(String[] args){
        new LoanCalculatorGUI();
    }
}
