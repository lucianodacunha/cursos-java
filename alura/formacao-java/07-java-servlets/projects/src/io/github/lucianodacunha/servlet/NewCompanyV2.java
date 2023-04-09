package io.github.lucianodacunha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewCompanyV2
 */
@WebServlet("/newCompanyV2")
public class NewCompanyV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String empresa = req.getParameter("empresa");
		
		PrintWriter out = resp.getWriter();
		out.println(String.format(
				"Nova empresa %s cadastrada com sucesso.", empresa));
		
		System.out.println("Parametro recebido: " + empresa);
		System.out.println("Servlet finalizado");
	}

}
