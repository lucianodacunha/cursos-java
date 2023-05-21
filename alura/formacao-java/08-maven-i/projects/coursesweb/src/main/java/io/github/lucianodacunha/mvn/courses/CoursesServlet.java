package io.github.lucianodacunha.mvn.courses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/courses")
public class CoursesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		PrintWriter out = resp.getWriter();
		out.println(String.format("<html><body>Ola %s, tudo bem?</body></html", 
				name));
		out.close();
		System.out.println("Servlet processado");
	}
}
