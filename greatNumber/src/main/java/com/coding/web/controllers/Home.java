package com.coding.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("Metodo get");
		 HttpSession session = request.getSession();
		 if(session.isNew()) {
				int setRandom = generarNumero();
				session.setAttribute("random", setRandom);
				session.setAttribute("message", "");
				session.setAttribute("reset",false);
			}
			request.setAttribute("reset",session.getAttribute("reset"));
			request.setAttribute("message",session.getAttribute("message"));
		 System.out.println(session.getAttribute("random")+ "numeroRandom");
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

    private int generarNumero() {
    	Integer numeroRandom = (int) (Math.random() * 100) + 1;
    	return numeroRandom;
    }

}
