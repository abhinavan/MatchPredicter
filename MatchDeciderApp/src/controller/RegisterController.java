package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
    public RegisterController() 
    {
        super();
    
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("In post method");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		String email=request.getParameter("email");
		UserDao udao=new UserDaoImpl();
		try
		{
		if(Pattern.matches("[a-zA-Z]+", fname) && Pattern.matches("[a-zA-Z]+", lname))
		{
			boolean flag=udao.matchEmail(email);
			if(flag!=true)
			{
				System.out.println("Email is new");
				flag=udao.matchUserName(uname);
				if(flag!=true)
				{
					System.out.println("Username is new");
					StringBuilder sbf=udao.validatePassword(password, cpassword);
					if(sbf.equals("password contain at least one number"))
					{
						System.out.println("Inside success block");
						//int status=udao.insertUser(fname, lname, uname, email, cpassword);
						//System.err.println(status);
					}
					// for not matching password criteria
					else
					{
						System.out.println("Inside unsuccessful block");
						System.out.println(sbf);
					}
				}
				// for username found to be existing one 
				else
				{
					System.out.println("Please create another username .. this already exists");
				}
			}
			// for email found to be existing one 
			else
			{
				System.out.println("Email is not new");
			}
		}
		// if first name or last name contains any number or special characters 
		else
		{
			response.sendRedirect("register.html");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
