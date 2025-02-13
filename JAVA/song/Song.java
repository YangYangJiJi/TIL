package song;

import java.util.Scanner;

public class Song {
	// 1 빅뱅 뱅뱅뱅 2015
	int id;
	String name;
	String songTitle;
	int year;

	Song(String x) {
		String[] tokens = x.split(" ");
		id = Integer.parseInt(tokens[0]);
		name = tokens[1];
		songTitle = tokens[2];
		year = Integer.parseInt(tokens[3]);
	}

	Song() {
	}

	void read(Scanner scan) {
		id = scan.nextInt();
		name = scan.next();
		songTitle = scan.next();
		year = scan.nextInt();
	}

	void print() {
		System.out.printf("[%2d] %s %s (%d년)\n", id, name, songTitle, year);
	}

	boolean matches(String n) {
		if (songTitle.contains(n))
			return true;
		if (n.contentEquals(year + ""))
			return true;
		return name.equals(n);
	}
}