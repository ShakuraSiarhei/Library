package by.itac.mylibrary.dao;

import by.itac.mylibrary.controller.impl.LibraryInitialization;
import by.itac.mylibrary.dao.impl.FileCRUDBookDAO;
import by.itac.mylibrary.dao.impl.FileFindBookDAO;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private CRUDBookDAO bookDAO = new FileCRUDBookDAO();
	private FindBookDAO findDAO = new FileFindBookDAO();
	private LibraryInitialization libraryInitialized = new LibraryInitialization ();
 	
	
	public CRUDBookDAO getBookDAO() {
		return bookDAO;
	}


	public FindBookDAO getFindDAO() {
		return findDAO;
	}
	
	public LibraryInitialization getLibraryInitialized () {
		return libraryInitialized;
	}


	private DAOProvider () {}
	
		
	public static DAOProvider getInstance() {
		return instance;
	}

}
