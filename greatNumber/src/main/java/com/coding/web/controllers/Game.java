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
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	System.out.println("Metodo POST");
    	HttpSession session = request.getSession();
    	int random = (int)session.getAttribute("random");
    	
    	String userNumber = request.getParameter("userNumber");
    	Integer number = Integer.parseInt(userNumber);
    	if(number > random) {
    		session.setAttribute("message","Too high!");
    	}else if(number < random) {
    		session.setAttribute("message","Too low!!");
    	}else {
    		session.setAttribute("message",random + " was the number!");
    		session.setAttribute("reset",true);
    	}
    	request.setAttribute("message",session.getAttribute("message"));
    	request.setAttribute("reset",session.getAttribute("reset"));
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);
    }

}
