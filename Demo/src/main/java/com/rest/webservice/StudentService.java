package com.rest.webservice;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.sql.*;


import javax.ws.rs.POST;

@Path("student")
public class StudentService 
{	
	private Student s;
	public StudentService()
	{
		s=new Student();
	}
	@POST
	//@Path("student")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById()
	{
		try
		{
			String url="jdbc:mysql://localhost:3306/S_Database";
			String uname="root";
			String pass="root";
		
			
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("class is loaded...........");
			Connection con=DriverManager.getConnection(url,uname,pass);
			String sql="select * from student1";
			PreparedStatement pstmt=con.prepareStatement(sql);
			//pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				Student s=new Student();
				s.setSTUDENT_NO(rs.getInt(1));
				s.setSTUDENT_NAME(rs.getString(2));
				s.setSTUDENT_DOB(rs.getString(3));
				s.setSTUDENT_DOJ(rs.getString(4));
				
				//student.add(s);
				return s;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
}
