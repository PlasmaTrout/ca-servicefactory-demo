package com.codeaffectionado.learning.commands;

import org.apache.felix.service.command.CommandProcessor;

import com.codeaffectionado.learning.factories.api.Greeter;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;


@Component(provide=GreeterGreetCommand.class,properties={
	CommandProcessor.COMMAND_SCOPE+":String=tutorial",
	CommandProcessor.COMMAND_FUNCTION+":String=greet"
})
public class GreeterGreetCommand {
	
	private Greeter greeter;
	
	public String greet(){
		return greeter.getGreeting();
	}
	
	@Reference
	private void setGreeter(Greeter greeter){
		this.greeter = greeter;
	}
}
