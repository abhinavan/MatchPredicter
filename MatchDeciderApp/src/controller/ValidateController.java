package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;

/**
 * Servlet implementation class ValidateController
 */
@WebServlet("/ValidateController")
public class ValidateController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ValidateController() 
    {
    	System.out.println("In constructor");
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserDao udao=new UserDaoImpl();
    	String uname=request.getParameter("uname");
    	String password=request.getParameter("password");
    	try 
    	{
    		boolean flag=udao.validateUser(uname, password);
    		if(flag!=false)
    		{
    			HttpSession userSession=request.getSession();
    			userSession.setAttribute("uname",uname);
    			userSession.setAttribute("password",password);
    			response.sendRedirect("predictPage.jsp");
    		}
    		else
    		{
    			response.sendRedirect("login.html");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	
		
	}

}
