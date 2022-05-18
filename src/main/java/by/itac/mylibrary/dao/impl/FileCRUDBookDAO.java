package by.itac.mylibrary.dao.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.itac.mylibrary.dao.impl.LibraryInitialization;
import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileCRUDBookDAO implements CRUDBookDAO {
	
	@Override
	public void save(Book book) throws DAOException {
	
		DAOProvider dao = DAOProvider.getInstance();
		LibraryInitialization libraryInitialization = dao.getLibraryInitialized();
	
		StringBuilder textToDataBase;
		textToDataBase = new StringBuilder(book.getId() + "__ " + "__" + book.getTitle() + "__ " + "__" + book.getAuthor() + "__ "
		+ "__" + book.getYearOfWriting() + "__ " + "__" + book.getStatus());		
		
		try {
			FileWriter writer = new FileWriter(libraryInitialization.getLibraryAdress(), true); 
			writer.write(textToDataBase.toString());
			writer.append('\n');
			writer.close();
			libraryInitialization.setActual(false);
		} catch (IOException e) {
			throw new DAOException();
		}
	}

	@Override
	public void update(int id, Book book) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book book) throws DAOException {
		DAOProvider dao = DAOProvider.getInstance();
		LibraryInitialization libraryInitialization = dao.getLibraryInitialized();
		
		List<Book> books = libraryInitialization.getLibrary();
		books.remove(book);
		libraryInitialization.writeLibraryToFile();
		
	}

	@Override
	public void delete(int id) throws DAOException {
		
		DAOProvider dao = DAOProvider.getInstance();
		LibraryInitialization libraryInitialization = dao.getLibraryInitialized();
		
		List<Book> books = libraryInitialization.getLibrary();
		for (Book b : books) {
			if (b.getId() == id) {
				books.remove(b);
			}
		}
		libraryInitialization.writeLibraryToFile();		
	}

	@Override
	public void updateStatus(int id, String newStatus) throws DAOException {
		
		DAOProvider dao = DAOProvider.getInstance();
		LibraryInitialization libraryInitialization = dao.getLibraryInitialized();
		
		List<Book> books = libraryInitialization.getLibrary();
		for (Book b : books) {
			if (b.getId() == id) {
				b.setStatus(newStatus);
			}
		}
		libraryInitialization.writeLibraryToFile();		
	}

}
