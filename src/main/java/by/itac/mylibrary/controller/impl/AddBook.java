package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class AddBook implements Command {

	public String execute(String request) {
		ServiceProvider service = ServiceProvider.getInstance();
		BookService bookService = service.getBookService();
		String response = null;
		String[] bookInfo = request.split("__");
		Book book = new Book (Long.parseLong(bookInfo[0]), bookInfo[2], bookInfo[4], Integer.parseInt(bookInfo[6]), bookInfo[8]);
		
		try {
			bookService.save(book);
			response = "Книга успешно сохранена.";
		} catch (ServiceException e) {
			response = "При сохранениии книги возникла ошибка.";
		}
		return response;
	}

}
