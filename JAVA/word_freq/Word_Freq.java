package word_freq;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Word_Freq {
	public static void main(String[] args) {
		
		// 입력된 단어들의 등장 횟수를 저장하는 맵 (LinkedHashMap 사용 → 입력 순서 유지)
		Map<String, Integer> m = new LinkedHashMap<String, Integer>();
		
		// args 배열에 저장된 문자열(단어)들을 순회하며 등장 횟수를 세는 반복문
		// 명령문 줄의 입력에 의해 등장회수 표를 초기화한다. 
		for (String a : args) {
			Integer freq = m.get(a);
		m.put(a, (freq == null) ? 1 : freq + 1);
		}
		
		// 서로 다른 단어 개수 출력
		System.out.println(m.size() + " distinct words:");
		
		// 단어별 등장 횟수 출력 (입력 순서 유지)
		System.out.println(m);
	}
}
