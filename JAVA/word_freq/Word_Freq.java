package word_freq;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Word_Freq {
	public static void main(String[] args) {
		
		// �Էµ� �ܾ���� ���� Ƚ���� �����ϴ� �� (LinkedHashMap ��� �� �Է� ���� ����)
		Map<String, Integer> m = new LinkedHashMap<String, Integer>();
		
		// args �迭�� ����� ���ڿ�(�ܾ�)���� ��ȸ�ϸ� ���� Ƚ���� ���� �ݺ���
		// ��ɹ� ���� �Է¿� ���� ����ȸ�� ǥ�� �ʱ�ȭ�Ѵ�. 
		for (String a : args) {
			Integer freq = m.get(a);
		m.put(a, (freq == null) ? 1 : freq + 1);
		}
		
		// ���� �ٸ� �ܾ� ���� ���
		System.out.println(m.size() + " distinct words:");
		
		// �ܾ ���� Ƚ�� ��� (�Է� ���� ����)
		System.out.println(m);
	}
}
