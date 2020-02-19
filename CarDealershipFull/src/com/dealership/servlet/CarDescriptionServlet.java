package com.dealership.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Car;
import com.user.Search;

/**
 * Servlet implementation class CarDescriptionServlet
 */
@WebServlet("/CarDescriptionServlet")
public class CarDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarDescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		final String path = "/Users/richardnava/Documents/dealership-files/Car_Lot.txt";

		ArrayList<Car> lot = new ArrayList<Car>();
		
		Search search = new Search();
		lot = search.getInventory();
		//String vin = request.getParameter("vin");
		
	
		String vin = request.getParameter("vin");
		
		System.out.println("*******WE IN THE DESCRIPT SERVLET*****");
		System.out.println(vin);
		
		lot = search.carDescription(vin, lot);
		
		session.setAttribute("lot", lot);
		
		RequestDispatcher rs = request.getRequestDispatcher("CarDescription.jsp");
		rs.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}