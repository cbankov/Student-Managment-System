package main;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class manageCourseForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageCourseForm frame = new manageCourseForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public manageCourseForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 896, 420);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 139, 139));
		contentPane.add(panel);
		
		JLabel lblManageCourse = new JLabel("Manage Course");
		lblManageCourse.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblManageCourse.setBackground(Color.WHITE);
		lblManageCourse.setBounds(333, 5, 293, 44);
		panel.add(lblManageCourse);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(173, 143, 251, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Label:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(102, 146, 53, 14);
		panel.add(label_1);
		
		JLabel lblHours = new JLabel("Hours:");
		lblHours.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHours.setBounds(102, 194, 61, 14);
		panel.add(lblHours);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		spinner.setBounds(173, 191, 82, 20);
		panel.add(spinner);
		
		JButton button = new JButton("Add");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(333, 305, 114, 36);
		panel.add(button);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemove.setBounds(55, 305, 124, 36);
		panel.add(btnRemove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(467, 92, 408, 298);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Object[] columns = {"Id","Label","Hours"};
		DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_1.setColumns(10);
        textField_1.setBounds(173, 98, 251, 20);
        panel.add(textField_1);
        
        JLabel lblIdl = new JLabel("Id:");
        lblIdl.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblIdl.setBounds(102, 103, 53, 14);
        panel.add(lblIdl);
        
        JButton btnEdit = new JButton("Edit");
        btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnEdit.setBounds(198, 305, 114, 36);
        panel.add(btnEdit);
	}
}
