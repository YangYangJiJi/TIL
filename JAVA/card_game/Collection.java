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
	
		System.out.println("��������: " + randSet);
		col.removeAll(randSet); // ��ũ ����
		System.out.println("��������: " + col);
		
		ArrayList<Integer> setList = new ArrayList<>(randSet);
		System.out.println("����Ʈ��ȯ:"+setList);
		// ������ ���� ������ ���µ�, ������ �ִ� ��ó�� ������ ������ toString ����
	}
}

