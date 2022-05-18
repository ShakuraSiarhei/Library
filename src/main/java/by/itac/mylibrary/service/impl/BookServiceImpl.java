package by.itac.mylibrary.service.impl;

import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;

public class BookServiceImpl implements BookService {	

	@Override
	public void save(Book book) throws ServiceException {
				//тут будет проверка данных
		try {
			DAOProvider dao = DAOProvider.getInstance();
			CRUDBookDAO bookDAO = dao.getBookDAO();
			bookDAO.save(book);
		} catch (DAOException e) {
			throw new ServiceException(); 
		}
		
	}

	@Override
	public Book findByID(long id) throws ServiceException {
		
		Book response;
		
		try {
			DAOProvider dao = DAOProvider.getInstance();
			FindBookDAO findBook = dao.getFindDAO();
			response = findBook.findByID(id);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return response;
	}

	@Override
	public List<Book> findByTitle(String title) throws ServiceException {
		
		List<Book> response;
		
		try {
			DAOProvider dao = DAOProvider.getInstance();
			FindBookDAO findBook = dao.getFindDAO();
			response = findBook.findByTitle(title);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return response;
	}

	@Override
	public List<Book> findByAuthor(String author) throws ServiceException {
		
		List<Book> response;
		
		try {
			DAOProvider dao = DAOProvider.getInstance();
			FindBookDAO findBook = dao.getFindDAO();
			response = findBook.findByAuthor(author);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return response;
	}

}
