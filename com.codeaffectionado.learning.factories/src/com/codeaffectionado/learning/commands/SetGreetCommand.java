package com.codeaffectionado.learning.commands;

import org.apache.felix.service.command.CommandProcessor;

import com.codeaffectionado.learning.factories.api.Greeter;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;


@Component(provide=SetGreetCommand.class,properties={
	CommandProcessor.COMMAND_SCOPE+":String=tutorial",
	CommandProcessor.COMMAND_FUNCTION+":String=greetset"
})
public class SetGreetCommand {
	
	private Greeter greeter;
	
	public void greetset(String message){
		greeter.setMessage(message.toString());
	}
	
	@Reference
	private void setGreeter(Greeter greeter){
		this.greeter = greeter;
	}
	
}
