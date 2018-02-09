package main;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class MainForm extends JFrame {
	private JLabel lblUsername;
	private static JLabel lblStudentsCount;
	private static JLabel lblCoursesCount;

 
	public static void main(String[] args) {
		  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainForm() {
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnStudent = new JMenu("Student");
		mnStudent.setIcon(new ImageIcon(MainForm.class.getResource("/Images/if_student_309036.png")));
		menuBar.add(mnStudent);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddStudentForm AddSf = new AddStudentForm();
				
			  AddSf.setLocationRelativeTo(null);
			  AddSf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			});
		mntmNewMenuItem.setIcon(new ImageIcon(MainForm.class.getResource("/Images/if_InterfaceExpendet-10_592607 (1).png")));
		mnStudent.add(mntmNewMenuItem);
		
		JMenuItem mntmManage = new JMenuItem("Manage");
		mntmManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageStudentsForm mngSf = new manageStudentsForm();
			

			  mngSf.setLocationRelativeTo(null);
			  mngSf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			});
		mntmManage.setIcon(new ImageIcon(MainForm.class.getResource("/Images/if_user-group_285648.png")));
		mnStudent.add(mntmManage);
		
		JMenu mnNewMenu = new JMenu("Course");
		mnNewMenu.setIcon(new ImageIcon(MainForm.class.getResource("/Images/if_Courses_70613.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("AddCourse");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCourseForm Addcf = new addCourseForm();
				Addcf.setVisible(true);
				
				Addcf.setLocationRelativeTo(null);
				Addcf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			});
		mnNewMenu.add(mntmNewMenuItem_1);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 1921, 983);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblUsername = new JLabel("Welcome <#####>");
		
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblUsername.setBounds(194, 52, 232, 35);
		panel.add(lblUsername);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(160, 194, 342, 169);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblStudentsCount = new JLabel("Students Count = ");
		lblStudentsCount.setBounds(75, 65, 267, 29);
		lblStudentsCount.setForeground(new Color(255, 255, 255));
		lblStudentsCount.setFont(new Font("Tahoma", Font.ITALIC, 24));
		panel_1.add(lblStudentsCount);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(844, 194, 342, 169);
		panel.add(panel_2);
		
		lblCoursesCount = new JLabel("Courses Count = ");
		lblCoursesCount.setForeground(Color.WHITE);
		lblCoursesCount.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblCoursesCount.setBounds(75, 65, 279, 29);
		panel_2.add(lblCoursesCount);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainForm.class.getResource("/Images/if_icon_sets_school_outline_hand_drawn_iconfinder-01_2087709.png")));
		lblNewLabel.setBounds(24, 11, 134, 136);
		panel.add(lblNewLabel);
		
		getLblStudentsCount().setText("Students count = "+Integer.toString(MyFunction.countData("student")));
		getLblCoursesCount().setText("Courses count = "+Integer.toString(MyFunction.countData("course")));
		
		
		
	}
	
	public JLabel getLblUsername() {
		return lblUsername;
	} 

	public static JLabel getLblStudentsCount() {
		return lblStudentsCount;
	}
	public static JLabel getLblCoursesCount() {
		return lblCoursesCount;
	}
}
