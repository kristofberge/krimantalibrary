package com.krimanta.library.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.krimanta.library.Factory;
import com.krimanta.library.db.LibraryDb;
import com.krimanta.library.meta.DataType;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		DataType dataType = (DataType)request.getSession().getAttribute("listType");
		String toDelete = request.getParameter("toDelete");
		
		System.out.println("To delete=" + toDelete);
		
		
		LibraryDb db = Factory.getDb();
		
		db.delete(dataType, toDelete);
		
		request.setAttribute(dataType.getTableName(), db.getAll(dataType));
		RequestDispatcher dispatcher = request.getRequestDispatcher("list/" + dataType.getTableName() + ".jsp");
		dispatcher.forward(request, response);
	}

}
