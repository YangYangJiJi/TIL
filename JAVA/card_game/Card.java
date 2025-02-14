package week10_collection;
//4���� ��ȣ�� 16���� ���ڸ� ��ũ�� ���, ���÷� �����ϰ� ���´�.
//������� ī�������� �� ������ �����ϰ�, �ƴϸ� dealHand�� �Ѵ�. 
//dealHand�� sublist�� �̿��ؼ� ����Ʈ�並 �����. 
//�ش��ϴ� ��ŭ��ŭ hand�� �߰���. 

import java.util.*;

public class Card {
	public static void main(String[] args) {
		
		// ���� �ȳ�: ������ �� �÷��̾� ���� ī�� ���� �Է��ؾ� ��
        if (args.length < 2) {
            System.out.println("Usage: java Card <numHands> <cardsPerHand>");
            return;
        }
		
        // ����� ���ڷ� ���� �÷��̾� ��(numHands)�� �� �÷��̾�� ������ ī���� ��(cardsPerHand)
		int numHands = Integer.parseInt(args[0]); // �÷��̾� ��
		int cardsPerHand = Integer.parseInt(args[1]); // �� ��� ���� ī�� �� 
		
		// 4���� ī�� ����� 13���� ���ڸ� �����Ͽ� 
		// �������� 52�� ī�� ������ �����
		String[] suit = new String[] { "��", "��", "��", "��" }; // ī�� ����
		String[] rank = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" }; // ī�� ����
		List<String> deck = new ArrayList<String>(); // ī�� �� ����Ʈ ����
		
		//52���� ī��(����x����) ����
		for (int i = 0; i < suit.length; i++)
			for (int j = 0; j < rank.length; j++)
				deck.add(suit[i] + rank[j]);
		
		Collections.shuffle(deck); //ī�� ���� �������� ����
		
		if (numHands * cardsPerHand > deck.size()) {
			System.out.println("Not enough cards.");
			return;
		}
		
		// �� �÷��̾�� ī�带 ������
		for (int i = 0; i < numHands; i++)
			System.out.println(dealHand(deck, cardsPerHand)); // dealHand()�� ����Ͽ� ī�� ���
	}

	
	
	public static <E> List<E> dealHand(List<E> deck, int n) {
		int deckSize = deck.size(); // ���� ���� �ִ� ī�� ����
		List<E> handView = deck.subList(deckSize - n, deckSize); // ������ n���� ī�带 ������ (subList ���)
		List<E> hand = new ArrayList<E>(handView); // ���ο� ����Ʈ�� ����
		handView.clear(); // ������ ī�带 ������ ���� (ī�� ��� �Ϸ�)
		
		//��ũ���� �ڵ�� �κ��� �����, �ڵ忡 �ִ� �ָ� �����ָ鼭 ����Ʈ
		//n�� ��ŭ ��� �ְ�, ����� �ݺ��ϴ°� dealHand��. ī�带 ��� ����� �����ִ� ������.
		// ��, n�� ��ŭ ������ �����ְ�, ������ ī��� ������ �����ϴ� ����
		return hand;
	}
}