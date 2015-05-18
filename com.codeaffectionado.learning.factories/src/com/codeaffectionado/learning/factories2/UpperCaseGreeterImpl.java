package com.codeaffectionado.learning.factories2;

import java.util.Map;

import org.osgi.framework.BundleContext;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.metatype.Configurable;

import com.codeaffectionado.learning.factories.api.Greeter;
import com.codeaffectionado.learning.factories.api.GreeterConfig;

@Component(provide=Greeter.class,designateFactory=GreeterConfig.class)
public class UpperCaseGreeterImpl implements Greeter {
	private String greeting = "Field Level Greeting";
	
	
	@Override
	public String getGreeting() { 
		String result = greeting + " \r\rinstance: "+this.toString();
		return result.toUpperCase();
	}
	
	public void setMessage(String message){
		this.greeting = message;
	}
	
	@Activate
	private void activate(BundleContext ctx, Map<String,Object> map){
		GreeterConfig config = Configurable.createConfigurable(GreeterConfig.class, map);
		this.greeting = config.greeting();
	}

		
}
