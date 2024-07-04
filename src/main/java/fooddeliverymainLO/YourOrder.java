package fooddeliverymainLO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

@WebServlet("/check")
public class YourOrder extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery","root","Bhargav1@");
	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from ordered");
			rs.next();
			
			PrintWriter out = resp.getWriter();
			out.println(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3));
			
		
				
		}
		catch (Exception e) {
			
		}
		
		
	}

}
