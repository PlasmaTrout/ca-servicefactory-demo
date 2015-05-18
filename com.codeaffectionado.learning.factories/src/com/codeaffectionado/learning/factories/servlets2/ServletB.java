package com.codeaffectionado.learning.factories.servlets2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeaffectionado.learning.factories.api.Greeter;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@Component(name="Example Servlet B",provide=Servlet.class,properties={
	"alias:String=/servletb"
})
public class ServletB extends HttpServlet {
	
	private List<Greeter> greeters;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().write("<h1>Found Services:</h1><ol>");
		for(Greeter g : greeters){
			resp.getWriter().write("<li><h2>"+g.getGreeting()+"</h2></li>");
		}
		resp.getWriter().write("</ol>");
	}
	
	@Reference(dynamic=true,multiple=true)
	private void setGreeter(Greeter greeter){
		if(greeters == null){
			greeters = new ArrayList<Greeter>();
		}
		greeters.add(greeter);
	}
	
	@SuppressWarnings("unused")
	private void unsetGreeter(Greeter greeter){
		greeters.remove(greeter);
	}
	 
	private static final long serialVersionUID = 2818298156121717066L;

}
