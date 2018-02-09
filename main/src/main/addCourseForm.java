package main;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class addCourseForm extends JFrame {

	private JPanel contentPane;
	private JTextField CourseField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCourseForm frame = new addCourseForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	course c = new course();
	public addCourseForm() {
		
		
	    setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 874, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddCourse = new JLabel("Add Course");
		lblAddCourse.setBounds(333, 5, 207, 44);
		lblAddCourse.setBackground(new Color(255, 255, 255));
		lblAddCourse.setOpaque(true);
		lblAddCourse.setFont(new Font("Tahoma", Font.BOLD, 36));
		panel.add(lblAddCourse);
		
		CourseField = new JTextField();
		CourseField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CourseField.setColumns(10);
		CourseField.setBounds(173, 123, 251, 20);
		panel.add(CourseField);
		
		JLabel lblLabel = new JLabel("Label:");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLabel.setBounds(110, 126, 53, 14);
		panel.add(lblLabel);
		
		JLabel lblHourse = new JLabel("Hourse:");
		lblHourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHourse.setBounds(102, 168, 61, 14);
		panel.add(lblHourse);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		spinner.setBounds(173, 167, 82, 20);
		panel.add(spinner);
		
		JButton btnAddcoursebutton = new JButton("Add");
		btnAddcoursebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!c.isCourseExist(CourseField.getText())) {
						
					   String label = CourseField.getText();
					   int hours = Integer.valueOf(spinner.getValue().toString());
					   c.insertUpdateDeleteStudent('i', null, label, hours);
					   MainForm.getLblCoursesCount().setText("Course count = "+Integer.toString(MyFunction.countData("course")));
					}else {
						JOptionPane.showMessageDialog(null, "Course Already Exists");
					}
				} catch (NumberFormatException | HeadlessException | SQLException e1) {
					
					e1.printStackTrace();
				}
			   
			}
		});
		btnAddcoursebutton.setIcon(new ImageIcon(addCourseForm.class.getResource("/Images/if_Plus_green_1891032.png")));
		btnAddcoursebutton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddcoursebutton.setBounds(429, 305, 114, 36);
		panel.add(btnAddcoursebutton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnCancel.setIcon(new ImageIcon(addCourseForm.class.getResource("/Images/if_close_61762 (1).png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(131, 305, 124, 36);
		panel.add(btnCancel);
	}
}
