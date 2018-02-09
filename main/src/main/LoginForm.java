package main;



import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import main.MyConnection;
import main.MainForm;

@SuppressWarnings("serial")
public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField TextField_Username;
	private JPasswordField PasswordField;


	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public LoginForm() {
		setLocationByPlatform(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 517);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 617, 478);
		panel.setBackground(new Color(144, 238, 144));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(204, 71, 135, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(72, 61, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(82, 195, 74, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(82, 269, 74, 23);
		panel.add(lblPassword);
		
		TextField_Username = new JTextField();
		TextField_Username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TextField_Username.setBounds(166, 198, 211, 20);
		panel.add(TextField_Username);
		TextField_Username.setColumns(10);
		
		PasswordField = new JPasswordField();
		PasswordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasswordField.setBounds(166, 272, 211, 20);
		panel.add(PasswordField);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setIconTextGap(8);
		btnCancel.setIcon(new ImageIcon(LoginForm.class.getResource("/Images/delete_remove_close_exit_trash-32.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(82, 336, 129, 38);
		panel.add(btnCancel);
		
		JLabel lbl_U = new JLabel("*");
		lbl_U.setForeground(new Color(255, 69, 0));
		lbl_U.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_U.setBounds(390, 195, 9, 23);
		panel.add(lbl_U);
		
		JLabel lbl_P = new JLabel("*");
		lbl_P.setForeground(new Color(255, 69, 0));
		lbl_P.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_P.setBounds(390, 269, 9, 23);
		panel.add(lbl_P);
		lbl_U.setVisible(false);
		lbl_P.setVisible(false);
		
		JButton Button_Login = new JButton("Login");
		Button_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		//	lbl_U.setVisible(false);
		//	lbl_P.setVisible(false);
			if(TextField_Username.getText().equals("")) {
				lbl_U.setVisible(true);
			} if(String.valueOf(PasswordField.getPassword()).equals("")) {
				lbl_P.setVisible(true);
			}
			else {
				Connection conn = MyConnection.getConnection();
				PreparedStatement ps;
				
				try {
					ps = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
					ps.setString(1, TextField_Username.getText() );
					ps.setString(2, String.valueOf(PasswordField.getPassword()));
					
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						MainForm mf = new MainForm();
						mf.setVisible(true);
						mf.pack();
						mf.setLocationRelativeTo(null);
						mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
					    mf.getLblUsername().setText("Welcome<"+TextField_Username.getText()+">");
					    
					    MainForm.getLblStudentsCount().setText("Students count = "+Integer.toString(MyFunction.countData("student")));
					    MainForm.getLblCoursesCount().setText("Courses count = "+Integer.toString(MyFunction.countData("course")));
				        dispose();
						
						
					}else {
						System.out.println("NO");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
			} 
		});
		Button_Login.setIcon(new ImageIcon(LoginForm.class.getResource("/Images/if_logout_54331.png")));
		Button_Login.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_Login.setIconTextGap(8);
		Button_Login.setBounds(255, 336, 122, 38);
		panel.add(Button_Login);
		
	}
}
