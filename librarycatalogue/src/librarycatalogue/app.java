package librarycatalogue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Paper> library = new LinkedList<Paper>();
		library = load();
		String command;
		Paper filter = new Paper();
		Paper.setCount(library.size());
		clearFilter(filter);
		for (;;) {
			System.out.println("Type in command.");
			command = input.nextLine();
			if (command.equalsIgnoreCase("add")) {
				add(input, library);
			} else if (command.equalsIgnoreCase("remove")) {
				library = remove(library, input);
				Paper.setCount(Paper.getCount() - 1);
			} else if (command.equalsIgnoreCase("save")) {
				save(library);
			} else if (command.equalsIgnoreCase("print")) {
				print(library, filter);
			} else if (command.equalsIgnoreCase("close")) {
				break;
			} else if (command.equalsIgnoreCase("addFilter")) {
				addFilter(filter, input);
			} else if (command.equalsIgnoreCase("clearfilter")) {
				clearFilter(filter);
			} else if (command.equalsIgnoreCase("sort")) {
				sort(library, filter, input);
			} else
				System.out.println("Wrong command.");
		}
		save(library);

		input.close();
	}

	static void add(Scanner input, List<Paper> library) {
		System.out.println("What kind of paper would you like to add?");
		String type = input.nextLine();
		if (type.equalsIgnoreCase("book")) {
			library.add(new Book(input));
		} else if (type.equalsIgnoreCase("newspaper")) {
			library.add(new Newspaper(input));
		} else if (type.equalsIgnoreCase("letter")) {
			library.add(new Letter(input));
		} else {
			System.out.println("Wrong type of paper.");
		}
	}

	static List<Paper> remove(List<Paper> library, Scanner input) {
		System.out.println("Type in the ID of book you want to remove from database.");
		int id = Integer.parseInt(input.nextLine());
		library.remove(id - 1);
		for (id--; id < library.size(); id++) {
			library.get(id).setId(id + 1);
		}
		return library;
	}

	static void save(List<Paper> library) {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("database.bin"))) {
			os.writeObject(library);
		} catch (IOException e) {
			System.out.println("Could not read file: database.bin");
		}
	}

	@SuppressWarnings("unchecked")
	static List<Paper> load() {
		List<Paper> library = new LinkedList<Paper>();
		try (ObjectInputStream os = new ObjectInputStream(new FileInputStream("database.bin"))) {
			library = (LinkedList<Paper>) os.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file database.bin");
		} catch (IOException e) {
			System.out.println("Can't read file database.bin");
		} catch (ClassNotFoundException e) {
			System.out.println("Error occured while loading database.");
		}
		return library;
	}

	static void print(List<Paper> library, Paper filter) {
		System.out.printf("ID\tTitle\tAuthor\tRelease date\tISBN\n");
		for (Paper paper : library) {
			if ((filter.getTitle().equals("null") | filter.getTitle().equalsIgnoreCase(paper.getTitle()))
					& (filter.getAuthor().equals("null") | filter.getAuthor().equalsIgnoreCase(paper.getAuthor()))
					& (filter.getISBN() == 0 | filter.getISBN() == paper.getISBN())) {
				System.out.println(paper.toString());
			}
		}
	}

	static Paper addFilter(Paper filter, Scanner input) {
		System.out.println("What filter do u want to add?");
		String newFilter = input.nextLine();
		if (newFilter.equalsIgnoreCase("title")) {
			System.out.println("What title do u want to add to filter?");
			filter.setTitle(input.nextLine());
		} else if (newFilter.equalsIgnoreCase("Author")) {
			System.out.println("What author name do u want to add to filter?");
			filter.setAuthor(input.nextLine());
		} else if (newFilter.equalsIgnoreCase("isbn")) {
			System.out.println("What ISBN number do u want to add to filter?");
			filter.setISBN(Integer.parseInt(input.nextLine()));
		} else
			System.out.println("There's no such filter.");
		return filter;
	}

	static void clearFilter(Paper filter) {
		filter.setAuthor("null");
		filter.setDate(0);
		filter.setISBN(0);
		filter.setTitle("null");
	}

	static void sort(List<Paper> library, Paper filter, Scanner input) {
		System.out.println("By what do you want to sort?");
		String sortBy = input.nextLine();
		if (sortBy.equalsIgnoreCase("author")) {
			Collections.sort(library, new Comparator<Paper>() {
				public int compare(Paper arg0, Paper arg1) {
					return arg0.getAuthor().compareTo(arg1.getAuthor());
				}
			});
		} else if (sortBy.equalsIgnoreCase("title")) {
			Collections.sort(library, new Comparator<Paper>() {
				public int compare(Paper arg0, Paper arg1) {
					return arg0.getTitle().compareTo(arg1.getTitle());
				}
			});
		} else if (sortBy.equalsIgnoreCase("ISBN")) {
			Collections.sort(library, new Comparator<Paper>() {
				public int compare(Paper arg0, Paper arg1) {
					if (arg0.getISBN() > arg1.getISBN()) {
						return 1;
					} else if (arg0.getISBN() < arg1.getISBN()) {
						return -1;
					} else
						return 0;
				}
			});
		} else if (sortBy.equalsIgnoreCase("date")) {
			Collections.sort(library, new Comparator<Paper>() {
				public int compare(Paper arg0, Paper arg1) {
					if (arg0.getDate() > arg1.getDate()) {
						return 1;
					} else if (arg0.getDate() < arg1.getDate()) {
						return -1;
					} else
						return 0;
				}
			});
		} else {
			System.out.println("There's no such way to sort.");
		}
		print(library, filter);
		Collections.sort(library, new Comparator<Paper>() {					//////////      !!!!!!!!!!!!! find a way to print it without sorting twice
			public int compare(Paper arg0, Paper arg1) {
				if (arg0.getId() > arg1.getId()) {
					return 1;
				} else if (arg0.getId() < arg1.getId()) {
					return -1;
				} else
					return 0;
			}
		});
	}
}