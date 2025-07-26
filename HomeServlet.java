package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.daoimp.RestaurantDAOimp;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class HomeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		RestaurantDAO daoimp = new RestaurantDAOimp();


		List<Restaurant> allRestaurants = daoimp.getAllRestaurants();


		for(Restaurant restaurant : allRestaurants)
		{
			System.out.println(restaurant);

		}

		req.setAttribute("allRestaurants", allRestaurants);


		RequestDispatcher rd = req.getRequestDispatcher("JSP/restaurant.jsp");
		rd.forward(req, resp);

	}

}
