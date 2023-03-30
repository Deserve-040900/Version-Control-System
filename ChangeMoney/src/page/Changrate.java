package layout;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Controller;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Changrate extends JFrame {

	private JPanel contentPane;
	private static JTextField txtrate;
	private static JComboBox cb_country;
	private static JTextField txtMoney;
	private static JTextField txtRate1;

	public static void new_lay() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Changrate frame = new Changrate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Changrate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		String[] currencies = Controller.getArrCon();
		
		JLabel lblNewLabel = new JLabel("1 ");
		contentPane.add(lblNewLabel);
		cb_country = new JComboBox(currencies);
		contentPane.add(cb_country);
		
		JLabel lblNewLabel_1 = new JLabel("equal");
		contentPane.add(lblNewLabel_1);
		
		String co=cb_country.getSelectedItem().toString();
		txtrate = new JTextField();
		contentPane.add(txtrate);
		txtrate.setColumns(10);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newdata();
			}
		});
		contentPane.add(btnNew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_2 = new JLabel("New Money");
		contentPane.add(lblNewLabel_2);
		
		txtMoney = new JTextField();
		contentPane.add(txtMoney);
		txtMoney.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New rate");
		contentPane.add(lblNewLabel_3);
		
		txtRate1 = new JTextField();
		contentPane.add(txtRate1);
		txtRate1.setColumns(10);
	}
	
	public static void delete() {
        String currency = cb_country.getSelectedItem().toString();
		Controller.deleteRate(currency);
	}
	public static void update() {
		double amount = Double.parseDouble(txtrate.getText());
        String currency = cb_country.getSelectedItem().toString();
        Controller.Updatedata(currency, amount);
	}
	public static void newdata() {
		double amount = Double.parseDouble(txtRate1.getText());
        String currency = txtMoney.getText().toString();
        Controller.insertRate(currency, amount);
	}
	public static String rate(String currency) {
		currency = cb_country.getSelectedItem().toString();
		return String.valueOf(Controller.getRate(currency));
	}

}
