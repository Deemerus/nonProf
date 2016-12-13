package librarycatalogue;

public class Paper {
	protected static int count = 0;
	protected int id =0;
	protected String title = null;
	protected int date = 0;
	protected String author = null;
	protected int ISBN = 0;

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	void remove() {
		id = 0; // Won't remove the object, because it costs too much. Cheaper
				// not to save it after the end of work.
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

}
