package by.itac.mylibrary.start;

import by.itac.mylibrary.controller.Controller;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.dao.impl.FileCRUDBookDAO;
import by.itac.mylibrary.entity.Book;

public class Main {

	public static void main(String[] args) throws DAOException {
		Controller start = new Controller();
		System.out.println(start.executeTask("ADD_BOOK 1__ __Base_title__ __Base_author__ __1999__ __Base_status"));
	}
	
}
