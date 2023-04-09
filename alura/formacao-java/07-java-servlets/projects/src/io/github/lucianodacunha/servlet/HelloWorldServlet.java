package io.github.lucianodacunha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/hello")
public class HelloWorldServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		String msg = "<p>Hello world,  \n" + 
				"<span style=\"color: red; font-weight: bold;font-size: 2rem;\">\n" + 
				"this is my first servlet.\n" + 
				"</span>		\n" + 
				"</p>";
		out.println("<html>");
		out.println("<body>");
		out.println(msg);
		out.println("</body>");
		out.println("</html>");
		System.out.println("Servlet terminated");
	}
}
