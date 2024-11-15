package employe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 		                                                    
	{
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/amazomemp","root","root");
			Statement str=con.createStatement();
			String query="insert into logindetails(name,password) values('"+name+"','"+pass+"')";
			int rs=str.executeUpdate(query);
			if(rs>0)
			{
				out.print("Register succesfull");
			}
			else
			{
				out.print("Date npt insert");
			}
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
