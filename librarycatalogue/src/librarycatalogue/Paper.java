package librarycatalogue;

public class Paper {
	protected static int count = 0;
	protected int id;
	protected String title = null;
	protected int date;
	protected String author = null;
	protected int ISBN = 0;

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
