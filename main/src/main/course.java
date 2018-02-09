package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class course {
	
	
	public void insertUpdateDeleteStudent(char operation, Integer id, String label, Integer hours ) throws SQLException {
Connection con = MyConnection.getConnection();
PreparedStatement ps;

// i for insert
if(operation == 'i') {
try {
ps = con.prepareStatement("INSERT INTO `course`(`label`, `hours_number`) VALUES (?,?)");
ps.setString(1, label);
ps.setInt(2, hours);



if(ps.executeUpdate() > 0) {
JOptionPane.showMessageDialog(null, "New Course Added");
}

} catch (SQLException e) {

e.printStackTrace();
}
}

//u for update
if(operation == 'u') {
try {
ps = con.prepareStatement("UPDATE `course` SET `label`= ?,`hours_number`= ? WHERE `id` = ?");
ps.setString(1, label);
ps.setInt(2, hours);
ps.setInt(3, id);
if(ps.executeUpdate() > 0) {
JOptionPane.showMessageDialog(null, "Course Data Updated");
}

} catch (SQLException e) {

e.printStackTrace();
}
}

//d for delete
if(operation == 'd') {
try {
ps = con.prepareStatement("DELETE FROM `course` WHERE `id` = ?");
ps.setInt(1, id);
if(ps.executeUpdate() > 0) {
JOptionPane.showMessageDialog(null, "Course Deleted");
}

} catch (SQLException e) {

e.printStackTrace();
}
}
con.close();
}
	public boolean isCourseExist(String courseName) throws SQLException {
		
		   boolean isExist = false;
		   Connection con = MyConnection.getConnection();
		   PreparedStatement ps;
		   try {
			ps = con.prepareStatement("SELECT * FROM `course` WHERE `label` = ?");
			ps.setString(1,	 courseName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			isExist =  true;
			}else {
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.close();
		}
		return isExist;
	}
 
	   public void fillCourseTable(JTable table) throws SQLException  {
		   
		   
		   Connection con = MyConnection.getConnection();
		   PreparedStatement ps;
		   try {
			ps = con.prepareStatement("SELECT * FROM `student` WHERE CONCAT(`first_name`, `last_name`, `phone`, `address`) LIKE ?");
			//ps.setString(1,	 "%"+valueToSearch+"%");
			
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			Object[] row;
			while(rs.next()) {
				row = new Object[7];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);
				
				model.addRow(row);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.close();
		}
	   }
}
