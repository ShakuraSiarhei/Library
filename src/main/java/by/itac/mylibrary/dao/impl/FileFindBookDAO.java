package by.itac.mylibrary.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.impl.LibraryInitialization;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileFindBookDAO implements FindBookDAO {

	@Override
	public Book findByID(long id) throws DAOException {
		
		DAOProvider dao = DAOProvider.getInstance();
		LibraryInitialization libraryInitialization = dao.getLibraryInitialized();
		
		List<Book> books = libraryInitialization.getLibrary();
		for (Book b : books) {
			if (b.getId() == id) {
				return b;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByTitle(String title) throws DAOException {
		
		DAOProvider dao = DAOProvider.getInstance();
		LibraryInitialization libraryInitialization = dao.getLibraryInitialized();
		List<Book> books = libraryInitialization.getLibrary();
		
		List<Book> response = new ArrayList<Book>();
		
		for (Book b : books) {
			if (b.getTitle().equals(title)) {
				response.add(b);
			}
		}
		
		return response;
		
	}

	@Override
	public List<Book> findByAuthor(String author) throws DAOException {
		
		DAOProvider dao = DAOProvider.getInstance();
		LibraryInitialization libraryInitialization = dao.getLibraryInitialized();
		List<Book> books = libraryInitialization.getLibrary();
		
		List<Book> response = new ArrayList<Book>();
		
		for (Book b : books) {
			if (b.getAuthor().equals(author)) {
				response.add(b);
			}
		}
		
		return response;
	
	}

}
