package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindBookByID implements Command {

	@Override
	public String execute(String request) {
		ServiceProvider service = ServiceProvider.getInstance();
		BookService bookService = service.getBookService();
		
		String response = null;
		
		try {
			Long id = Long.parseLong(request);
			Book book = bookService.findByID(id);
			if (book == null) {
				response = "Книга с таким ID отсутствует в библиотеке.";
			} else {
			response = book.toString();
			}
		} catch (ServiceException e) {
			response = "При поиске книги произошла ошибка!";
		}
		
		return response;
	}

}
