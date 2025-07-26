package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.dao.RestaurantDAO;
import com.tap.daoimp.MenuDAOimp;
import com.tap.daoimp.RestaurantDAOimp;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int resId  = Integer.parseInt(req.getParameter("restaurantId"));
		
		MenuDAO imp = new MenuDAOimp();
		
		List<Menu> allmenusByRestaurant = imp.getMenusByRestaurant(resId);
		
//		This below is for the restaurant Name.
		
		String name = req.getParameter("restaurantName");
		
		RestaurantDAO resName = new RestaurantDAOimp();
		
		String restaurantName = resName.getRestaurantNameById(resId);
		
	
		
		for(Menu menu : allmenusByRestaurant)
		{
			System.out.println(menu);
		}
		
		
		req.setAttribute("allmenusByRestaurant", allmenusByRestaurant);
		
		req.setAttribute("restaurantName", restaurantName);
		
	
		RequestDispatcher rd = req.getRequestDispatcher("JSP/menu.jsp");
		
		rd.forward(req, resp);
		
	}

}
