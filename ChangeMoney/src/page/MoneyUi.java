package page;
import javax.swing.*;

import data.Controller;

import java.awt.*;
import java.awt.event.*;

public class MoneyUi{
    JFrame frame;
    private JTextField textField;
    private JComboBox<String> comboBox;
    private JLabel lblConverted;
    public Controller controller= new Controller();
    public MoneyUi() {
        initialize();
    }

    private void initialize() {
    	
        frame = new JFrame("Currency Converter");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3, 5, 5));
        panel.setBounds(220, 70, 262, 150);
        frame.getContentPane().add(panel);

        for (int i = 1; i <= 9; i++) {
            final JButton button = new JButton(Integer.toString(i));
            button.setFont(new Font("Tahoma", Font.PLAIN, 12));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = textField.getText() + button.getText();
                    textField.setText(text);
                }
            });
            panel.add(button);
        }

        // Add button 0
        JButton button0 = new JButton("0");
        button0.setFont(new Font("Tahoma", Font.PLAIN, 12));
        button0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText() + "0";
                textField.setText(text);
            }
        });
        panel.add(button0);

        // Add button .
        JButton buttonDot = new JButton(".");
        buttonDot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonDot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText() + ".";
                textField.setText(text);
            }
        });
        panel.add(buttonDot);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAmount.setBounds(10, 10, 60, 20);
        frame.getContentPane().add(lblAmount);

        textField = new JTextField();
        textField.setBounds(80, 10, 120, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblCurrency = new JLabel("Currency:");
        lblCurrency.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCurrency.setBounds(10, 40, 60, 20);
        frame.getContentPane().add(lblCurrency);

        String[] currencies = Controller.getArrCon();
        comboBox = new JComboBox(currencies);
        comboBox.setBounds(80, 40, 120, 20);
        frame.getContentPane().add(comboBox);
        
        

        JLabel lblResult = new JLabel("Result of :");
        lblResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblResult.setBounds(10, 70, 60, 20);
        frame.getContentPane().add(lblResult);

        lblConverted = new JLabel("0.00");
        lblConverted.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblConverted.setBounds(80, 70, 120, 20);
        frame.getContentPane().add(lblConverted);

        // Add action listener to the text field
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        JButton btnConvert = new JButton("Convert");
        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });
        btnConvert.setBounds(220, 10, 100, 20);
        frame.getContentPane().add(btnConvert);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the text field and converted label
                textField.setText("");
                lblConverted.setText("0.00");
            }
        });
        btnClear.setBounds(220, 40, 100, 20);
        frame.getContentPane().add(btnClear);
       
        JButton btnSetting = new JButton("Setting");
        btnSetting.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	Changrate Cf = new Changrate();
            Cf.new_lay();
        	}
        });
        btnSetting.setBounds(337, 11, 85, 21);
        frame.getContentPane().add(btnSetting);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        frame.setVisible(true);
    }
    

    private void convert() {
        double amount = Double.parseDouble(textField.getText());
        String currency = comboBox.getSelectedItem().toString();
        double rate=Controller.getRate(currency);
        double converted = 0.0;
        converted = amount * (1/rate);
        lblConverted.setText(String.format("%.2f", converted));
    }
    
    public static void main(String[] args) {
        MoneyUi window = new MoneyUi();
    }
}

