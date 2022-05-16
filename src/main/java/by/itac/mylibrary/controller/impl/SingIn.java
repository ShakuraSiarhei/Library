package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.service.ClientService;
import by.itac.mylibrary.service.ServiceProvider;

public class SingIn implements Command {
	
	public String execute(String request) {
		String login = null;
		String password = null;
		
		String response = null;
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientService();
		
		try {
			clientService.clientLogin(login, password);;
			response = "Welcome!";
		} catch (Exception e) {
			response = "Error during login procedyre!";
		}
		
		return response;
	}
	
	

}
