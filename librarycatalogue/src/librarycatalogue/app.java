package librarycatalogue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Paper> library = new ArrayList<Paper>();
		library = load();
		String command;
		Paper filter = new Paper();
		filter=clearFilter(filter);
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
				filter=clearFilter(filter);
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
		File file = new File("database.txt");
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
			for (Paper paper : library) {
				if (paper.getId() != 0) {
					br.write(paper.getClass() + "//" + paper.getTitle() + "//" + paper.getAuthor() + "//"
							+ paper.getDate() + "//" + paper.getISBN());
					br.newLine();
				}
			}
		} catch (IOException e) {
			System.out.println("Could not read file: database.txt");
		}

	}

	static ArrayList<Paper> load() {
		ArrayList<Paper> library = new ArrayList<Paper>();
		File file = new File("database.txt");
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] words = line.split("//");
				if (line.substring(24, 24).equals("B")) {
					library.add(new Book(words[1], words[2], Integer.parseInt(words[4]), Integer.parseInt(words[3])));
				} else if (line.substring(24, 24).equals("N")) {
					library.add(new Newspaper(words[1], Integer.parseInt(words[3])));
				} else {
					library.add(new Letter(words[1], words[2], Integer.parseInt(words[3])));
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't find file database.txt");
		} catch (IOException e) {
			System.out.println("Can't read file database.txt");
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
	static Paper clearFilter(Paper filter){
		filter.setAuthor("null");
		filter.setDate(0);
		filter.setISBN(0);
		filter.setTitle("null");
		return filter;
	}
}
