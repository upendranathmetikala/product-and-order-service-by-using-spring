package org.jsp.orderservice.util;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DispatcherServletIntialize implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfiguration.class);
		
		DispatcherServlet servlet = new DispatcherServlet(context);
		Dynamic dynamic = servletContext.addServlet("DispatcherServlet", servlet);
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
		
	}
	
}