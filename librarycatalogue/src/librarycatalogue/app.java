package librarycatalogue;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
		try (FileOutputStream fo = new FileOutputStream("database.bin")) {
			ObjectOutputStream os = new ObjectOutputStream(fo);
			os.writeInt(library.size());
			for (Paper paper : library) {
				os.writeObject(paper);
			}
		} catch (IOException e) {
			System.out.println("Could not read file: database.bin");
		}

	}

	static List<Paper> load() {
		ArrayList<Paper> library = new ArrayList<Paper>();
		try (FileInputStream fi = new FileInputStream("database.bin")) {
			ObjectInputStream os = new ObjectInputStream(fi);
			for (int size = os.readInt(); size > 0; size--) {
				try {
					library.add((Paper) os.readObject());
				} catch (EOFException e) {
					break;
				} catch (ClassNotFoundException e) {
					System.out.println("Old version of database file. Contact the administrator.");
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't find file database.bin");
		} catch (IOException e) {
			System.out.println("Can't read file database.bin");
		}
		return library;
	}

	static void print(List<Paper> library, Paper filter) {
		System.out.printf("ID\tTitle\tAuthor\tRelease date\tISBN\n");
		for (Paper paper : library) {
			if ((filter.getTitle().equals("null") | filter.getTitle().equalsIgnoreCase(paper.getTitle()))
					& (filter.getAuthor().equals("null") | filter.getAuthor().equalsIgnoreCase(paper.getAuthor()))
					& (filter.getISBN() == 0 | filter.getISBN() == paper.getISBN())) {
				System.out.printf(paper.getId() + ":\t" + paper.getTitle() + "\t" + paper.getAuthor() + "\t"
						+ paper.getDate() + "\t" + paper.getISBN() + "\n");
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
}
