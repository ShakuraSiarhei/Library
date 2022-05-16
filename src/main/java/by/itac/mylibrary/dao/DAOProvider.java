package by.itac.mylibrary.dao;

import by.itac.mylibrary.dao.impl.FileCRUDBookDAO;
import by.itac.mylibrary.dao.impl.FileFindBookDAO;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private CRUDBookDAO bookDAO = new FileCRUDBookDAO();
	private FindBookDAO findDAO = new FileFindBookDAO();
	
	
	public CRUDBookDAO getBookDAO() {
		return bookDAO;
	}


	public FindBookDAO getFindDAO() {
		return findDAO;
	}


	private DAOProvider () {}
	
		
	public static DAOProvider getInstance() {
		return instance;
	}

}
