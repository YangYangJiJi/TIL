package song;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	String userid;
	String name;
	int age;
	String mf;
	ArrayList<Song> channel = new ArrayList<Song>();

	void read(Scanner scan, Main main) {
		userid = scan.next();
		name = scan.next();
		age = scan.nextInt();
		mf = scan.next();
		int n = scan.nextInt();
		while (n != 0) {
			channel.add(main.findSong(n));
			n = scan.nextInt();
		}
	}

	void print() {
		System.out.printf("%s %s %d세 (%s) \n\t", userid, name, age, mf);
		for (Song s : channel) {
			System.out.printf("%s ", s.songTitle);
		}
		System.out.println();
	}

	boolean matches(String kwd) {
		if (kwd.length() == 0)
			return true;
		if (kwd.matches("-?\\d+")) {
			int temp = Integer.parseInt(kwd);
			return temp / 10 == age / 10;
		}
		if (userid.equals(kwd) || kwd.equals(name) || mf.equals(kwd))
			return true;
		return false;
	}
}
