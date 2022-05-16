package by.itac.mylibrary.dao.impl;

import java.io.FileWriter;
import java.io.IOException;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileCRUDBookDAO implements CRUDBookDAO {

	public void save(Book book) throws DAOException {
		
		try {
			StringBuilder textToDataBase;
			textToDataBase = new StringBuilder(book.getId() + "__ " + "__" + book.getTitle() + "__ " + "__" + book.getAuthor() + "__ "
			+ "__" + book.getYearOfWriting() + "__ " + "__" + book.getStatus());
			FileWriter writer = new FileWriter("D:/Java/Eclipse/home-library/src/main/resources/db-home-library.txt", true); 
			writer.write(textToDataBase.toString());
			writer.append('\n');
			writer.close();
		} catch (IOException e) {
			throw new DAOException();
		}
	}

	public void update(int id, Book book) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	public void delete(Book book) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	public void updateStatus(int id, int newStatus) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
