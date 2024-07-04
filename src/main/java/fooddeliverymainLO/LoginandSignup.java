package fooddeliverymainLO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/gologin")
public class LoginandSignup extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		if(email.equals("admin@gmail.com")&& password.equals("password")) {
			
		RequestDispatcher rd= req.getRequestDispatcher("index1.html");
		rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("Signupfood.html");
			rd.forward(req, resp);
		}
		
		
		}
	

}
