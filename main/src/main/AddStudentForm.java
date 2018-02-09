package main;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import javax.swing.JTextArea;

import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

import java.util.Date;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class AddStudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_FN;
	private JTextField textField_LN;
	private JTextField textField_Phone;
	private JTextArea textArea_Adres;
	private JDateChooser dateChooser;
	private String bdate;

    student std = new student();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentForm frame = new AddStudentForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


public boolean verifText() {
		
		if(textField_FN.getText().equals("") || textField_LN.getText().equals("") || textField_Phone.getText().equals("") || textArea_Adres.getText().equals("") || dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "One or more empty fields");
			return false;
		}
		else if(dateChooser.getDate().compareTo(new Date()) > 0) {
			JOptionPane.showMessageDialog(null, "Date must be valid");
			return false;
		}
		else {
			return true;
		}
	}
	 
	
	public AddStudentForm() {
		
		
		
		setVisible(true);
		//pack();
		setLocationRelativeTo(null);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 500, 500));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 421, 534);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(138, 11, 163, 29);
		panel.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(37, 88, 85, 14);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(37, 128, 85, 14);
		panel.add(lblLastName);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSex.setBounds(64, 170, 47, 14);
		panel.add(lblSex);
		
		JLabel lblBirthdate = new JLabel("BirthDate:");
		lblBirthdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBirthdate.setBounds(37, 211, 85, 14);
		panel.add(lblBirthdate);
		
		JLabel lblPhone = new JLabel("Phone:");
		
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(37, 261, 85, 14);
		panel.add(lblPhone);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdress.setBounds(37, 309, 85, 14);
		panel.add(lblAdress);
		
		textField_FN = new JTextField();
		textField_FN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_FN.setBounds(124, 87, 251, 20);
		panel.add(textField_FN);
		textField_FN.setColumns(10);
		
		textField_LN = new JTextField();
		textField_LN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_LN.setColumns(10);
		textField_LN.setBounds(124, 125, 251, 20);
		panel.add(textField_LN);
		
		JRadioButton RadioBtnMale = new JRadioButton("Male");
		RadioBtnMale.setBounds(124, 168, 59, 23);
		panel.add(RadioBtnMale);
		RadioBtnMale.setSelected(true);
		
		JRadioButton RadioBtnFMale = new JRadioButton("Female");
		RadioBtnFMale.setBounds(205, 168, 70, 23);
		panel.add(RadioBtnFMale);
		
		textField_Phone = new JTextField();
		textField_Phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		textField_Phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(124, 260, 251, 20);
		panel.add(textField_Phone);
		
		
		textArea_Adres = new JTextArea();
		textArea_Adres.setBounds(124, 311, 251, 117);
		panel.add(textArea_Adres);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(124, 211, 251, 20);
		panel.add(dateChooser);
		
	
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname = textField_FN.getText();
				String lname = textField_LN.getText();
				String phone = textField_Phone.getText();
				String address = textArea_Adres.getText();
				String sex = "Male";
				
				if(RadioBtnFMale.isSelected()) {
					sex = "Female";
			}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					bdate = dateFormat.format(dateChooser.getDate());	
				} catch (NullPointerException e2) {
					e2.printStackTrace();
				}
				
				if(verifText()) {
					student std = new student();
					std.insertUpdateDeleteStudent('i', null , fname, lname, sex, bdate, phone, address);
					try {
						MainForm.getLblStudentsCount().setText("Students count = "+Integer.toString(MyFunction.countData("student")));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					manageStudentsForm.getTable().setModel(new DefaultTableModel(null,new Object[] {"Id","First Name","Last Name","Sex","Birthdate","Phone", "Address"}));
					std.fillStudentJtable(manageStudentsForm.getTable(), "");
				}
				
			}
		});
		btnAdd.setIcon(new ImageIcon(AddStudentForm.class.getResource("/Images/if_Plus_green_1891032.png")));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(267, 468, 108, 36);
		panel.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(AddStudentForm.class.getResource("/Images/if_close_61762 (1).png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(121, 468, 114, 36);
		panel.add(btnCancel);
		 
		
	}

}
