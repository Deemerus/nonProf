package librarycatalogue;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Paper> library = new ArrayList<Paper>();
		library = load();
		String command;
		Paper filter = new Paper();
		filter = clearFilter(filter);
		for (;;) {
			System.out.println("Type in command.");
			command = input.nextLine();
			if (command.equalsIgnoreCase("add")) {
				library.add(add(input));
			} else if (command.equalsIgnoreCase("remove")) {
				library = remove(library, input);
			} else if (command.equalsIgnoreCase("save")) {
				save(library);
			} else if (command.equalsIgnoreCase("print")) {
				print(library, filter);
			} else if (command.equalsIgnoreCase("close")) {
				break;
			} else if (command.equalsIgnoreCase("addFilter")) {
				addFilter(filter, input);
			} else if (command.equalsIgnoreCase("clearfilter")) {
				filter = clearFilter(filter);
			} else
				System.out.println("Wrong command.");
		}
		save(library);

		input.close();
	}

	static Paper add(Scanner input) {
		System.out.println("What kind of paper would you like to add?");
		String type = input.nextLine();
		Paper paper = null;
		if (type.equalsIgnoreCase("book")) {
			paper = new Book(input);
		} else if (type.equalsIgnoreCase("newspaper")) {
			paper = new Newspaper(input);
		} else if (type.equalsIgnoreCase("letter")) {
			paper = new Letter(input);
		} else {
			System.out.println("Wrong type of paper.");
		}
		return paper;
	}

	static ArrayList<Paper> remove(ArrayList<Paper> library, Scanner input) {
		System.out.println("Type in the ID of book you want to remove from database.");
		int id = Integer.parseInt(input.nextLine());
		library.get(id - 1).remove();
		return library;
	}

	static void save(ArrayList<Paper> library) {
		try (FileOutputStream fo = new FileOutputStream("database.bin")) {
			ObjectOutputStream os = new ObjectOutputStream(fo);
			os.writeInt(library.size());
			for (Paper paper : library) {
				if (paper.getId() != 0) {
					os.writeObject(paper);
				}
			}
		} catch (IOException e) {
			System.out.println("Could not read file: database.bin");
		}

	}

	static ArrayList<Paper> load() {
		ArrayList<Paper> library = new ArrayList<Paper>();
		try (FileInputStream fi = new FileInputStream("database.bin")) {
			ObjectInputStream os = new ObjectInputStream(fi);
			for(int size = os.readInt();size>0;size--) {
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

	static void print(ArrayList<Paper> library, Paper filter) {
		System.out.printf("ID\tTitle\tAuthor\tRelease date\tISBN\n");
		for (Paper paper : library) {
			if (paper.getId() != 0
					& (filter.getTitle().equals("null") | filter.getTitle().equalsIgnoreCase(paper.getTitle()))
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

	static Paper clearFilter(Paper filter) {
		filter.setAuthor("null");
		filter.setDate(0);
		filter.setISBN(0);
		filter.setTitle("null");
		return filter;
	}
}
