package by.itac.mylibrary.dao.impl;

import java.io.BufferedWriter;
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
		String delimetr = "__ __";
		textToDataBase = new StringBuilder();
		textToDataBase.append(book.getId());
		textToDataBase.append(delimetr);
		textToDataBase.append(book.getTitle());
		textToDataBase.append(delimetr);
		textToDataBase.append(book.getAuthor());
		textToDataBase.append(delimetr);
		textToDataBase.append(book.getYearOfWriting());
		textToDataBase.append(delimetr);
		textToDataBase.append(book.getStatus());		
		
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(libraryInitialization.getLibraryAdress(), true));
			bufferedWriter.append(textToDataBase.toString());
			bufferedWriter.append('\n');
			bufferedWriter.close();
			libraryInitialization.setActual(false);
		} catch (IOException e) {
			throw new DAOException(e);
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
