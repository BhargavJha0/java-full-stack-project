package fooddeliverymainLO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class Add  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		String address=req.getParameter("address");
		String modepayement=req.getParameter("mode");
		
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery","root","Bhargav1@");
			PreparedStatement ps = con.prepareStatement("INSERT INTO ordered (name,address, mode) VALUES (?, ? ,?)");
			ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, modepayement);
            
			int count =ps.executeUpdate();
			RequestDispatcher rd= req.getRequestDispatcher("messege.html");
			rd.forward(req, resp);
		
			
			if(count>0) {
				System.out.println("successfull");
			}
			else {
				PrintWriter out = resp.getWriter();
				out.println(" <h1>Already exist </h1>");
				System.out.println("not");
			}
				
		}
		catch (Exception e) {
			
		}
				
				
				
				
	


	}
	}
