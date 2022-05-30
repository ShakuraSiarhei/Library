 	 	package by.itac.mylibrary.start;

import java.util.List;

import by.itac.mylibrary.controller.Controller;
import by.itac.mylibrary.entity.Book;

public class Main {

	public static void main(String[] args) {
		Controller start = new Controller();
		System.out.println(start.executeTask("ADD_BOOK 11__ __Base_Title11__ __Base_Author11__ __1000__ __Base_Status"));
		System.out.println(start.executeTask("FIND_BOOK_BY_AUTHOR Base_Author101"));
		
	}
	
}
