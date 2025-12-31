package com.riderent.riderent.controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.riderent.riderent.Doa.UserDAO;
import com.riderent.riderent.model.User;

@WebServlet("/RegisterServlet") // Yeh URL mapping hai
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Form se data nikalna
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		System.out.println("Register Servlet is working");
		// 2. User Object banya
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		
		// 3. DAO call karke save karna
		UserDAO dao = new UserDAO();
		boolean f = dao.registerUser(user);
		
		// 4. Result ke hisab se page redirect karna
		if(f) {
			// Success: Login page pe bhejo
			request.setAttribute("msg", "Registration Successful! Please Login.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			// Fail: Wapas Register page pe error ke sath
			request.setAttribute("msg", "Something went wrong on server!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}