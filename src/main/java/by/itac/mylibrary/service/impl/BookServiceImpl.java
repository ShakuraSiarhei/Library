package by.itac.mylibrary.service.impl;

import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;

public class BookServiceImpl implements BookService {	

	public void save(Book book) throws ServiceException {
		
		try {
			DAOProvider dao = DAOProvider.getInstance();
			CRUDBookDAO bookDAO = dao.getBookDAO();
			bookDAO.save(book);
		} catch (DAOException e) {
			throw new ServiceException(); 
		}
		
	}

	public Book findByID(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
