package com.krimanta.library.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krimanta.library.Factory;
import com.krimanta.library.db.LibraryDb;
import com.krimanta.library.dto.Language;

/**
 * Servlet implementation class AddLanguageServlet
 */
@WebServlet("/AddLanguageServlet")
public class AddLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String langName = request.getParameter("langName");
		LibraryDb db = Factory.getDb();
		Language newLang = db.addLanguage(langName);
		
		request.setAttribute("language", newLang);
		RequestDispatcher dispatcher = request.getRequestDispatcher("details/language.jsp");
		dispatcher.forward(request, response);
	}

}
