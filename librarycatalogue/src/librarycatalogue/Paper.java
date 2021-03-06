package librarycatalogue;

import java.io.Serializable;

public class Paper implements Serializable {
	private static final long serialVersionUID = -111203575547369020L;
	protected static int count = 0;
	protected int id = 0;
	protected String title = null;
	protected int date = 0;
	protected String author = null;
	protected int ISBN = 0;

	public static void setCount(int count) {
		Paper.count = count;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public static int getCount() {
		return count;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getDate() {
		return date;
	}

	public String getAuthor() {
		return author;
	}

	public int getISBN() {
		return ISBN;
	}

	public String toString() {
		return id + ":\t" + title + "\t" + author + "\t" + date + "\t" + ISBN;
	}

}
