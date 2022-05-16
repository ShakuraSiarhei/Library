package by.itac.mylibrary.controller;

import java.util.HashMap;
import java.util.Map;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.impl.*;

public final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
	
	CommandProvider () {
		repository.put(CommandName.SING_IN, new SingIn());
		repository.put(CommandName.REGISTRATION, new Register());
		repository.put(CommandName.ADD_BOOK, new AddBook());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (Exception e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		
		return command;
	}

}
