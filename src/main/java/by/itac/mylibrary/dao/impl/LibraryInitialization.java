package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public final class LibraryInitialization {
	
	private final List<Book> library = new ArrayList<Book>();;
	private boolean isActual = false;
	private String libraryAdress = "db-home-library.txt";

	
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
		
		try (FileReader fr = new FileReader(libraryAdress)) {
			BufferedReader read = new BufferedReader(fr);
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
			throw new DAOException();
		}
		 
	}
	
	public void writeLibraryToFile() throws DAOException {
				
		try {
			FileWriter writer = new FileWriter(libraryAdress, false); 
			for (Book b : library ) {
				StringBuilder textToDataBase;
				textToDataBase = new StringBuilder(b.getId() + "__ " + "__" + b.getTitle() + "__ " + "__" + b.getAuthor() + "__ "
					+ "__" + b.getYearOfWriting() + "__ " + "__" + b.getStatus());		
				writer.write(textToDataBase.toString());
				writer.append('\n');
			}
			writer.close();
			isActual = true;
		} catch (IOException e) {
			throw new DAOException();
		}
	}
}
	


