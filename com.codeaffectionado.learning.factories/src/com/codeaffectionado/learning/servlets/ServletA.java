package com.codeaffectionado.learning.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.ComponentFactory;

import com.codeaffectionado.learning.factories.api.Greeter;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@Component(name="Example Servlet A",provide=Servlet.class,properties={
	"alias:String=/servleta"
})
public class ServletA extends HttpServlet {
	
	private Greeter greeter; 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("<h1>My Bound Reference Is:</h1><h2>"+greeter.getGreeting()+"</h2>");
		
	}
	
	@Reference
	private void setGreeter(Greeter greeter){
		this.greeter = greeter;
		System.out.println(greeter.toString()+" is set!");
	}
	 
	private static final long serialVersionUID = 2818298156121717066L;

}
