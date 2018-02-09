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
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@SuppressWarnings("serial")
public class manageStudentsForm extends JFrame {
	
	private static int id;
	private static int rowIndex;
	private static String sex;
	private static JTable table;
	private static String bdate;
	private static String fname;
	private static String lname;
	private static String phone;
	private static String address;
	private JTextField textField_FN;
	private JTextField textField_LN;
	private JTextField textField_ID;
	private JTextField textField_Phone;
	private JTextField textField_Search;
    private DefaultTableModel model;
	private student std = new student();
	private JFrame frame = new JFrame();
	private JPanel contentPane = new JPanel();

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageStudentsForm frame = new manageStudentsForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
public boolean verifText() {
	     Date date = null;
	     try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(bdate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		if(fname.equals("") || lname.equals("") || phone.equals("") || address.equals("") || bdate.equals("") || sex.equals("") ) {
			JOptionPane.showMessageDialog(null, "One or more empty fields");
			return false; 
		}
		
		else if(date.compareTo(new Date()) > 0) { 
			JOptionPane.showMessageDialog(null, "Date must be valid");
			return false;
		}
		else {
			return true; 
		} 
	}
    
	public manageStudentsForm() {
		
		setVisible(true);
		setLocationRelativeTo(null);
	    
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1311, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1295, 669);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 139, 139));
		contentPane.add(panel);
		
		JLabel lblManageStudent = new JLabel("Manage Student");
		lblManageStudent.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblManageStudent.setBounds(378, 0, 310, 44);
		panel.add(lblManageStudent);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(37, 88, 85, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Last Name:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(37, 128, 85, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Sex:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(64, 170, 47, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("BirthDate:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(37, 211, 85, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Phone:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(37, 261, 85, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Adress:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(37, 309, 85, 14);
		panel.add(label_6);
		
		textField_FN = new JTextField();
		textField_FN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_FN.setColumns(10);
		textField_FN.setBounds(124, 85, 251, 20);
		panel.add(textField_FN);
		
		textField_LN = new JTextField();
		textField_LN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_LN.setColumns(10);
		textField_LN.setBounds(124, 125, 251, 20);
		panel.add(textField_LN);
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setSelected(true);
		radioButton.setBounds(124, 168, 59, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Female");
		radioButton_1.setBounds(205, 168, 70, 23);
		panel.add(radioButton_1);
		
		textField_Phone = new JTextField();
		textField_Phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(124, 260, 251, 20);
		panel.add(textField_Phone);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(124, 311, 251, 117);
		panel.add(textArea);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(124, 211, 251, 20);
		panel.add(dateChooser);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentForm AddSf = new AddStudentForm();
			    AddSf.setLocationRelativeTo(null);
			    AddSf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setIcon(new ImageIcon(manageStudentsForm.class.getResource("/Images/if_Plus_green_1891032.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(352, 468, 114, 36);
		panel.add(button);
		
		JButton button_Remove = new JButton("Remove");
		button_Remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_ID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No Student Selected");
				}else {
				int id = Integer.valueOf(textField_ID.getText());
				std.insertUpdateDeleteStudent('d', id , null, null, null, null, null, null);
				std.fillStudentJtable(table, "");
				table.setModel(new DefaultTableModel(null,new Object[] {"Id","First Name","Last Name","Sex","Birthdate","Phone", "Address"}));
				std.fillStudentJtable(table, textField_Search.getText());
				MainForm.getLblStudentsCount().setText("Students count = "+Integer.toString(MyFunction.countData("student")));
				textField_ID.setText("");
				textArea.setText("");
				textField_FN.setText("");
				textField_LN.setText("");
				textField_Phone.setText("");
				radioButton_1.setSelected(false);
				radioButton.setSelected(false);
				dateChooser.setDate(null);
			} }
		});
		button_Remove.setIcon(new ImageIcon(manageStudentsForm.class.getResource("/Images/if_close_61762 (1).png")));
		button_Remove.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_Remove.setBounds(25, 468, 124, 36);
		panel.add(button_Remove);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(80, 56, 31, 14);
		panel.add(lblId);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ID.setColumns(10);
		textField_ID.setBounds(124, 53, 251, 20);
		panel.add(textField_ID);
		
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(397, 102, 888, 329);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
					
					 rowIndex = table.getSelectedRow();
					textField_ID.setText(model.getValueAt(rowIndex, 0).toString());
					textField_FN.setText(model.getValueAt(rowIndex, 1).toString());
					textField_LN.setText(model.getValueAt(rowIndex, 2).toString());
					textField_Phone.setText(model.getValueAt(rowIndex, 5).toString());
					textArea.setText(model.getValueAt(rowIndex, 6).toString());
					
					if(model.getValueAt(rowIndex, 3).toString().equals("Male"))
					{
						radioButton_1.setSelected(false);
						radioButton.setSelected(true);
					}else{
						radioButton.setSelected(false);
						radioButton_1.setSelected(true);
					}
					Date bdate;
					try {
						bdate = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 4).toString());
						dateChooser.setDate(bdate);
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    rowIndex = table.getSelectedRow();
			    model = (DefaultTableModel)table.getModel();
			    
				
				if(model.getValueAt(rowIndex, 3).toString().equals("Male"))
				{
					radioButton_1.setSelected(false);
					radioButton.setSelected(true);
				}else{
					radioButton.setSelected(false);
					radioButton_1.setSelected(true);
				}
				textField_ID.setText(model.getValueAt(rowIndex, 0).toString());
				textField_FN.setText(model.getValueAt(rowIndex, 1).toString());
				textField_LN.setText(model.getValueAt(rowIndex, 2).toString());
				textField_Phone.setText(model.getValueAt(rowIndex, 5).toString());
				textArea.setText(model.getValueAt(rowIndex, 6).toString());
				
				Date bdate;
				try {
					bdate = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 4).toString());
					dateChooser.setDate(bdate);
				} catch (ParseException e1) {
				
					e1.printStackTrace();
				}
			}
		});
		
		scrollPane.setViewportView(table);
        frame.getContentPane().setLayout(null);
        
      
		Object[] columns = {"Id","First Name","Last Name","Sex","Birthdate","Phone","Adress"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        table.setShowGrid(true);
	    table.setGridColor(Color.yellow);
	    table.setSelectionBackground(Color.BLACK);
        
        std.fillStudentJtable(table, "");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton_1);
        bg.add(radioButton);
        
        textField_Search = new JTextField();
        textField_Search.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		table.setModel(new DefaultTableModel(null,new Object[] {"Id","First Name","Last Name","Sex","Birthdate","Phone", "Address"}));
        		std.fillStudentJtable(table, textField_Search.getText());
        	}
        });
        textField_Search.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_Search.setColumns(10);
        textField_Search.setBounds(916, 68, 369, 23);
        panel.add(textField_Search);
        
        JLabel lblEnterValueTo = new JLabel("Enter Value To Search:");
        lblEnterValueTo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEnterValueTo.setBounds(736, 69, 170, 20);
        panel.add(lblEnterValueTo);
        
        
        
    	JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     fname = textField_FN.getText(); 
			     lname = textField_LN.getText();
				 phone = textField_Phone.getText();
				 address = textArea.getText();
				 sex = "";
				 id = Integer.valueOf(textField_ID.getText());
				if(radioButton_1.isSelected()) {
					sex = "Female";
			}else if(radioButton.isSelected()){
				sex = "Male";
			}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					 bdate = dateFormat.format(dateChooser.getDate());	
				} catch (NullPointerException e2) {
					e2.printStackTrace();
				}
				
				if(verifText()) {
					student std = new student();
					std.insertUpdateDeleteStudent('u', id , fname, lname, sex, bdate, phone, address);
					try {
						MainForm.getLblStudentsCount().setText("Students count = "+Integer.toString(MyFunction.countData("student")));
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
			} 
		}});
		btnEdit.setIcon(new ImageIcon(manageStudentsForm.class.getResource("/Images/if_radial_arrows_1216559.png")));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(190, 468, 114, 36);
		panel.add(btnEdit);
			
	}
	
	public static JTable getTable() {
		return table;
	}
}
