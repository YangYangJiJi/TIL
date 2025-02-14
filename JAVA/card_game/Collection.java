package week10_collection;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Collection {
	public static void main(String[] args) {
		int n = 0;
		Random rand = new Random();
		Set<Integer> randSet = new HashSet<>();
		Collection<Integer> col = new ArrayList<>();
		
		for(int i = 0;i<30;i++){
			n = rand.nextInt(30);
			randSet.add(n);
			col.add(i);
		}
	
		System.out.println("난수집합: " + randSet);
		col.removeAll(randSet); // 벌크 연산
		System.out.println("제외집합: " + col);
		
		ArrayList<Integer> setList = new ArrayList<>(randSet);
		System.out.println("리스트변환:"+setList);
		// 집합은 원래 순서가 없는데, 순서가 있는 것처럼 찍히는 이유는 toString 때문
	}
}

