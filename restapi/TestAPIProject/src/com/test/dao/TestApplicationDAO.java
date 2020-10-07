package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.dto.Register;
import com.test.dto.StudentDto;



public class TestApplicationDAO {
	
	ArrayList tempVal=new ArrayList();
	public  ArrayList callDB() {
		System.out.println("inside");
		
		//TestDTO testDto=new TestDTO();
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/stuinfo","root","");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT  id,student_name, student_email, section, subjects, dob, gender FROM sdudetails WHERE 1");  
			//System.out.println(rs);
			
			while(rs.next())  {
				StudentDto stuInfo=new StudentDto();
				stuInfo.set_id(rs.getInt("id"));
				stuInfo.setStudent_name(rs.getString("student_name"));
				stuInfo.setStudent_email(rs.getString("student_email"));
				stuInfo.setSection(rs.getString("section"));
				tempVal.add(stuInfo);
				System.out.println(stuInfo.getStudent_name());
			}
		
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		return tempVal; 
		
	}
	
	public int callDB(StudentDto stuInfo) {
		int rs=0;
		System.out.println(stuInfo.getDob());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/stuinfo"
					+ "","root","");  
			String sql = "INSERT INTO sdudetails(student_name, student_email, section, subjects, dob, gender) VALUES('"+stuInfo.getStudent_name()+"','"+stuInfo.getStudent_email()+"','"+stuInfo.getSection()+"','"+stuInfo.getSubjects()+"','"+stuInfo.getDob()+"','"+stuInfo.getGender()+"')";
			System.out.println(sql);
			Statement stmt=con.createStatement();  
			 rs=stmt.executeUpdate(sql);
			System.out.println(rs+"<==rs");
			con.close(); 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return rs;
		}
//	public static void main(String[] args) {
//		Register register=new Register();
//		callDB(register);
//	}

}
