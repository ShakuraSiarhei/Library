package by.itac.mylibrary.entity;

import java.io.Serializable;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String title;
	private String author;
	private int yearOfWriting;
	private String status;
	
	public Book () {}
	
	public Book(String title, String author, int yearOfWriting, String status) {
		this.title = title;
		this.author = author;
		this.yearOfWriting = yearOfWriting;
		this.status = status;
	}
	
	public Book(long id, String title, String author, int yearOfWriting, String status) {
		this (title, author, yearOfWriting, status);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearOfWriting() {
		return yearOfWriting;
	}

	public void setYearOfWriting(int yearOfWriting) {
		this.yearOfWriting = yearOfWriting;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + yearOfWriting;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearOfWriting != other.yearOfWriting)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", yearOfWriting=" + yearOfWriting
				+ ", status=" + status + "]";
	}
	
	

}
