package by.itac.mylibrary.controller.impl;

import java.util.List;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindBookByAuthor implements Command {
	

	@Override
	public String execute(String request) {
		ServiceProvider service = ServiceProvider.getInstance();
		BookService bookService = service.getBookService();
		
		String response = null;
		
		try {
			String author = request;
			List<Book> book = bookService.findByAuthor(author);
			if (book.isEmpty()) {
				response = "Книги этого автора отсутствуют в библиотеке.";
			} else {
				for (Book b : book) {
				response = response + b.toString() + '\n';
				}
			}
		} catch (ServiceException e) {
			response = "При поиске книги произошла ошибка!";
		}
		
		return response;
	}

}
