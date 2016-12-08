package librarycatalogue;

public class Paper {
	protected int id;
	protected String title = null;
	protected int date;
	protected static int count = 0;
	
	void remove(){
		id=0;		//Won't remove the object, because it costs too much. Cheaper not to save it after the end of work.
	}

	public int getId() {
		return id;
	}
	
}

