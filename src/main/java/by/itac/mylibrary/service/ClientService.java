package by.itac.mylibrary.service;

import by.itac.mylibrary.entity.Client;
import by.itac.mylibrary.service.exception.ServiceException;

public interface ClientService {
	
	void clientRegistration(Client client) throws ServiceException;
	void clientLogin(String login, String password) throws ServiceException;
	
}
