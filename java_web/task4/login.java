package com.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/LoginServlet")
public class login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals("admin") && password.equals("admin")) {
			//sent cookie
			Cookie userCookie = new Cookie("username", username);
			userCookie.setMaxAge(60 * 60);// 设置cookie存在时间为1小时（60*60（秒））
			response.addCookie(userCookie);

			RequestDispatcher rd = request.getRequestDispatcher("/welcome");
			rd.forward(request, response);
		}
	}
}
