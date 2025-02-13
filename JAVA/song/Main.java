package song;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	Scanner keyin = new Scanner(System.in);
	List<Song> songs = new ArrayList<>();

	void mymain() {
		readSongs("songs.txt");
		// songs.stream().forEach(Song::print); // this를 스트림의 요소
		readUsers("users.txt");
		// users.stream().forEach(User::print); // this를 스트림의 요소

		System.out.println("제목 순으로 정렬 (20개만):");
		Collections.sort(songs, (x, y) -> x.songTitle.compareTo(y.songTitle));
		// FunctionalInterface에 의해서 람다가 인터페이스 객체로 전달된다
		songs.stream()
			.map(x->x.songTitle)
			.limit(20)
			.forEach(System.out::println);
		System.out.println("\n\n3회 이상 등장한 가수:"); //가수의 이름이 등장한 횟수를 세야함. 
		Map<String, Long> singerCnt
	 		= songs.stream()
	 			.collect(
	 				Collectors.groupingBy(o->o.name, //이름을 묶음
	 							Collectors.counting()));
		String result = singerCnt.entrySet().stream() //엔트리셋=키 밸류 셋
			.filter(x -> x.getValue() > 2)
			//.forEach(x -> System.out.printf("%s(%d회)\n", x.getKey(), x.getValue()));
			.map(x -> x.getKey())//키(=가수이름)를 꺼내서 붙여서 스트링을 만들어줘
			.collect(Collectors.joining(", ")); //밸류(=횟수), 키(=가수이름)
		System.out.println(result);
//		
		String kwd;
		List<Song> result2 = null;
		while (true) {
			System.out.print("=> ");
			kwd = keyin.next();
			result2 = findAll(kwd); // 키워드로 이름 뽑은걸 리스트로 만들어줌
			result2.stream().map(x -> x.songTitle)
					.distinct() // 중복제거
					.limit(10).forEach(System.out::println);
		}
	}

	List<Song> findAll(String kwd) {
		return songs.stream().filter(x -> x.matches(kwd)).collect(Collectors.toList());
	}

	public void readSongs(String filename) {
		Song m = null;
		Scanner filein = openFile(filename);
		while (filein.hasNext()) {
			m = new Song();
			m.read(filein);
			songs.add(m);
		}
		filein.close();
	}

	ArrayList<User> users = new ArrayList<>();

	void readUsers(String filename) {
		Scanner filein = openFile(filename);
		User m = null;
		while (filein.hasNext()) {
			m = new User();
			m.read(filein, this);
			users.add(m);
		}
		filein.close();
	}

	Song findSong(int n) {
		return songs.get(n - 1);
	}

	public Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println(filename + ": 파일 없음");
			System.exit(0);
		}
		return filein;
	}

	public static void main(String[] args) {
		Main a = new Main();
		a.mymain();
	}
}
