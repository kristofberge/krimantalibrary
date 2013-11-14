package com.krimanta.library.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krimanta.library.Factory;
import com.krimanta.library.db.LibraryDb;
import com.krimanta.library.meta.DataType;

/**
 * Servlet implementation class ListLanguages
 */
@WebServlet("/PrepareListServlet")
public class PrepareList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataType dataType = (DataType)request.getSession().getAttribute("listType");
		
		
		LibraryDb db = Factory.getDb();
		
		ResultSet all = db.getAll(dataType);
		request.setAttribute(dataType.getTableName(), all);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list/" + dataType.getTableName() + ".jsp");
		dispatcher.forward(request, response);
	}

}
