package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import dao.TeamDao;
import dao.TeamDaoImpl;

/**
 * Servlet implementation class TeamController
 */
@WebServlet("/TeamController")
public class TeamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TeamController()
    {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String fteam=request.getParameter("fteam");
		String steam=request.getParameter("steam");
		String stadium=request.getParameter("stadium");
		
		try
		{
			TeamDao tdao=new TeamDaoImpl();
			int status=tdao.validateTeam(fteam, steam, stadium);
			
			if(status!=0)
			{
				System.out.println(status);
				String team=tdao.startPrediction(fteam, steam, stadium, status);
				switch (team)
				{
				case "mumbai indians":
					response.sendRedirect("jsp/mumbai.jsp?teamName="+team+"&stadium="+stadium+"");
					break;
				case "royal challengers bangalore":
					response.sendRedirect("jsp/bangalore.jsp?teamName="+team+"&stadium="+stadium+"");
					break;
				case "rising pune supergiant":
					response.sendRedirect("jsp/pune.jsp?teamName="+team+"&stadium="+stadium+"");
					break;
				case "sunrisers hyderabad":
					response.sendRedirect("jsp/hyderabad.jsp?teamName="+team+"&stadium="+stadium+"");
					break;
				default:
					response.sendRedirect("predictPage.jsp");
					break;
				}
				
			}
			else
			{
				System.out.println("Invalid teams");
				response.sendRedirect("predictPage.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
