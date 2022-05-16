package by.itac.mylibrary.service;

import by.itac.mylibrary.service.impl.BookServiceImpl;
import by.itac.mylibrary.service.impl.ClientServiceImpl;
import by.itac.mylibrary.service.impl.StatusBookServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private BookService bookService = new BookServiceImpl();
	private StatusBookService statusBookService = new StatusBookServiceImpl();
	private ClientService clientService = new ClientServiceImpl();
		
	public BookService getBookService() {
		return bookService;
	}

	public StatusBookService getStatusBookService() {
		return statusBookService;
	}

	public ClientService getClientService() {
		return clientService;
	}

	private ServiceProvider() { }
	
	public static ServiceProvider getInstance() {
		return instance;
	}

}
