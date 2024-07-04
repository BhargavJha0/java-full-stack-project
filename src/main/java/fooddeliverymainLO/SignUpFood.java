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
@WebServlet("/signupfood")
public class SignUpFood extends HttpServlet{
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String phonenumber=req.getParameter("phonenumber");
		String password = req.getParameter("password");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery","username","password");
			PreparedStatement ps = con.prepareStatement("INSERT INTO sign (name,password, phonenumber) VALUES (?, ? ,?)");
			ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, phonenumber);
            
			int count =ps.executeUpdate();
			RequestDispatcher rd= req.getRequestDispatcher("Loginfoodwebsite.html");
			rd.forward(req, resp);
		
			
			if(count>0) {
				
				
				
				
			System.out.println("successfull");
			}
			else {
				PrintWriter out = resp.getWriter();
				out.println(" <h1>Already exist </h1>");
				System.out.println("not");
				
			}
			
			
			
			
			
		} catch (Exception e) {
			
		}
			
	}
	}

