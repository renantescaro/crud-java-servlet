package br.com.dynamicweb;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class Inicial extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reponses) throws IOException{
		PrintWriter html = reponses.getWriter();
		
		String nome = request.getParameter("nome");
		
		if(nome == null){
			nome = "";
		}
		
		html.println("<html>");
		html.println("<body>");
		html.println("<p>Bem Vindo ao Servlet "+nome+"</p>");
		html.println("</body>");
		html.println("</html>");
	}
}
