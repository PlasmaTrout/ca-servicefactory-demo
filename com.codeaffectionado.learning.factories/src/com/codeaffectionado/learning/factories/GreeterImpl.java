package com.codeaffectionado.learning.factories;

import java.util.Map;

import org.osgi.framework.BundleContext;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.metatype.Configurable;

import com.codeaffectionado.learning.factories.api.Greeter;
import com.codeaffectionado.learning.factories.api.GreeterConfig;

@Component(provide=Greeter.class,designateFactory=GreeterConfig.class,servicefactory=true)
public class GreeterImpl implements Greeter {
	private String greeting = "Field Level Greeting";
	private String instance = "";
	
	@Override
	public String getGreeting() { 
		return greeting + " \r\rinstance: "+this.instance;
	}
	
	public void setMessage(String message){
		this.greeting = message;
	}
	
	@Activate
	private void activate(BundleContext ctx, Map<String,Object> map){
		this.instance = this.toString();
		GreeterConfig config = Configurable.createConfigurable(GreeterConfig.class, map);
		this.greeting = config.greeting();
	}

		
}
