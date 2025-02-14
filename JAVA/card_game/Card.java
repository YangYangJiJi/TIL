package week10_collection;
//4개의 기호와 16개의 문자를 데크에 얹고, 셔플로 랜덤하게 섞는다.
//사람수와 카드수장수가 넘 많으면 리턴하고, 아니면 dealHand를 한다. 
//dealHand는 sublist를 이용해서 리스트뷰를 만든다. 
//해당하는 만큼만큼 hand에 추가함. 

import java.util.*;

public class Card {
	public static void main(String[] args) {
		
		// 사용법 안내: 실행할 때 플레이어 수와 카드 수를 입력해야 함
        if (args.length < 2) {
            System.out.println("Usage: java Card <numHands> <cardsPerHand>");
            return;
        }
		
        // 명령줄 인자로 받은 플레이어 수(numHands)와 각 플레이어에게 나눠줄 카드의 수(cardsPerHand)
		int numHands = Integer.parseInt(args[0]); // 플레이어 수
		int cardsPerHand = Integer.parseInt(args[1]); // 한 명당 받을 카드 수 
		
		// 4가지 카드 문양과 13가지 숫자를 조합하여 
		// 정상적인 52장 카드 묶음을 만든다
		String[] suit = new String[] { "♤", "♡", "◇", "♧" }; // 카드 문양
		String[] rank = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" }; // 카드 숫자
		List<String> deck = new ArrayList<String>(); // 카드 덱 리스트 생성
		
		//52장의 카드(문양x숫자) 생성
		for (int i = 0; i < suit.length; i++)
			for (int j = 0; j < rank.length; j++)
				deck.add(suit[i] + rank[j]);
		
		Collections.shuffle(deck); //카드 덱을 랜덤으로 섞기
		
		if (numHands * cardsPerHand > deck.size()) {
			System.out.println("Not enough cards.");
			return;
		}
		
		// 각 플레이어에게 카드를 나눠줌
		for (int i = 0; i < numHands; i++)
			System.out.println(dealHand(deck, cardsPerHand)); // dealHand()를 사용하여 카드 배분
	}

	
	
	public static <E> List<E> dealHand(List<E> deck, int n) {
		int deckSize = deck.size(); // 현재 남아 있는 카드 개수
		List<E> handView = deck.subList(deckSize - n, deckSize); // 덱에서 n장의 카드를 가져옴 (subList 사용)
		List<E> hand = new ArrayList<E>(handView); // 새로운 리스트에 저장
		handView.clear(); // 가져간 카드를 덱에서 제거 (카드 배분 완료)
		
		//데크에서 핸드뷰 부분은 지우고, 핸드에 있는 애를 돌려주면서 프린트
		//n장 만큼 떼어서 주고, 지우고를 반복하는게 dealHand임. 카드를 사람 수대로 나눠주는 과정임.
		// 즉, n장 만큼 덱에서 떼어주고, 가져간 카드는 덱에서 제거하는 과정
		return hand;
	}
}