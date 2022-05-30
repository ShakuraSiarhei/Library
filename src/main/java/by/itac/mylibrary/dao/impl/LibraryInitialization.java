package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public final class LibraryInitialization {
	
	private static final String FILE_NAME = "db-home-library.txt"; 	
	private String libraryAdress = getClass().getClassLoader().getResource(FILE_NAME).getFile();
	private final List<Book> library = new ArrayList<Book>();;
	private boolean isActual = false;
	
	public List<Book> getLibrary() throws DAOException {
		if (isActual) {
			return library;
		} else {
			
			readLibraryFromFile();
			isActual = true;
			return library;
		}
	}
	
	public String getLibraryAdress() {
		return libraryAdress;
	}
	
	public boolean isActual() {
		return isActual;
	}

	public void setActual(boolean isActual) {
		this.isActual = isActual;
	}

	private void readLibraryFromFile() throws DAOException {
		
		try (BufferedReader read = new BufferedReader(new FileReader(libraryAdress))) { 
			String line = read.readLine();
			
			while (line != null) {
				String[] books = line.split("__");
				
				Long id = Long.parseLong(books[0]);
				String title = books[2];
				String author = books[4];
				int year = Integer.parseInt(books[6]);
				String status = books[8];
				
				Book book = new Book (id, title, author, year, status);
				library.add(book);
				
				line = read.readLine();
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
		 
	}
	
	public void writeLibraryToFile() throws DAOException {
				
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(libraryAdress, false));
			for (Book b : library ) {
				String delimetr = "__ __";
				StringBuilder textToDataBase;
				textToDataBase = new StringBuilder();
				textToDataBase.append(b.getId());
				textToDataBase.append(delimetr);
				textToDataBase.append(b.getTitle());
				textToDataBase.append(delimetr);
				textToDataBase.append(b.getAuthor());
				textToDataBase.append(delimetr);
				textToDataBase.append(b.getYearOfWriting());
				textToDataBase.append(delimetr);
				textToDataBase.append(b.getStatus());	
				writer.append(textToDataBase.toString());
				writer.append('\n');
			}
			//writer.close();
			isActual = true;
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}
}
	


