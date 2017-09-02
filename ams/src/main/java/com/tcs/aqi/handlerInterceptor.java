package com.tcs.aqi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class handlerInterceptor extends HandlerInterceptorAdapter  {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session= request.getSession(false);
		String path= request.getServletPath();
		
		String userType= (String) session.getAttribute("userType");
		System.out.print("inside handler: "+userType+path+"jim ");
		if(userType==null){
			System.out.println("\n\n\ncnjn\n\n");
			
			if(path.equals("/search") || path.equals("/getNotification") || path.equals("/adminInput") || path.equals("/addscl") || path.equals("/form"))
				response.sendRedirect("/ams/");
		}
		else if(userType!=null){
			
			if(path.equals("/registerForm"))
				response.sendRedirect("/ams/");
			else if(userType.equals("user") && (path.equals("/adminInput") || path.equals("/addscl") || path.equals("/form")))
				response.sendRedirect("/ams/");
		}
		return true;
	}
}
