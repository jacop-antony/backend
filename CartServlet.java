package com.tap.servlet;

import java.io.IOException;

import com.tap.daoimp.MenuDAOimp;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		Cart cart =(Cart)session.getAttribute("cart");
		int sessRestaurantId =(int)session.getAttribute("restaurantId");
		int newRestaurantId = Integer.parseInt(req.getParameter("resId"));
		
		if(cart==null || sessRestaurantId!=newRestaurantId ) {
			
			  cart = new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("restaurantId", newRestaurantId);
		}
		
		
	
		String action = req.getParameter("action");
		
		
		if(action.equalsIgnoreCase("add")) {	
			addItemToCart(req,cart);
		}else if(action.equalsIgnoreCase("update")) {
			updateItemToCart(req,cart);
		}
		else if(action.equalsIgnoreCase("delete")) {
			deleteItemFromCart(req,cart);
			
		}
		
	
  }

	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		
		
	}

	private void updateItemToCart(HttpServletRequest req, Cart cart) {
		
	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
		
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
//		try {
			MenuDAOimp impl = new MenuDAOimp();
//		
//		Menu menu=impl.getMenuId(menuId);
		
		
//	CartItem ci = new CartItem(menuId, menu.getRestaurantId(), menu.getItemName(),quantity , menu.getPrice());	
		
		
	}
}

