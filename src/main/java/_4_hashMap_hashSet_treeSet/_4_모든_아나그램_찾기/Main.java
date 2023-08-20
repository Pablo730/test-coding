package _4_hashMap_hashSet_treeSet._4_모든_아나그램_찾기;

import java.util.*;
class Main {
	
	// Todo 맵을 잘 이용하자
	
	public int solutionPablo(String S, String T) {
		int answer = 0;
		Map<Character, Integer> tMap = new HashMap<>();
		char[] tChars = T.toCharArray();
		for (int i = 0; i < tChars.length; i++) {
			tMap.merge(tChars[i], 1, Integer::sum);
		}
		
		char[] sChars = S.toCharArray();
		Map<Character, Integer> sMap = new HashMap<>();
		for (int i = 0; i < tChars.length - 1; i++) {
			sMap.merge(sChars[i], 1, Integer::sum);
		}
		
		int left = 0;
		for (int right = tChars.length - 1; right < sChars.length; right++) {
			sMap.merge(sChars[right], 1, Integer::sum);
			boolean checkAna = true;
			
			/*
			for (char key: tMap.keySet()) {
				if (tMap.get(key) != sMap.get(key)) {
					checkAna = false;
					break;
				}
			}
			if (checkAna) {
				answer++;
			}
			*/
			
			if(sMap.equals(tMap)) {
				answer++;
			}
			
			if (sMap.get(sChars[left]) == 1) {
				sMap.remove(sChars[left]);
			} else {
				sMap.merge(sChars[left], -1, Integer::sum);
			}
			left++;
		}
		
		return answer;
	}
	
	
	public int solution(String S, String T){
		int answer=0;
		
		HashMap<Character, Integer> sMap=new HashMap<>();
		HashMap<Character, Integer> tMap=new HashMap<>();
		
		for(char x : T.toCharArray()) {
			tMap.merge(x, 1, Integer::sum);
		}
		
		int L = T.length()-1;
		for(int i = 0; i < L; i++) {
			sMap.merge(S.charAt(i), 1, Integer::sum);
		}
		
		int left = 0;
		
		for(int right = L; right < S.length(); right++){
			sMap.merge(S.charAt(right), 1, Integer::sum);

			if(sMap.equals(tMap)) {
				answer++;
			}
			
			sMap.merge(S.charAt(left), -1, Integer::sum);
			
			if(sMap.get(S.charAt(left)) == 0) {
				sMap.remove(S.charAt(left));
			}
			left++;
		}
		return answer;
	}
	
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String a=kb.next();
		String b=kb.next();
		System.out.print(T.solution(a, b));
		
		Set<Integer> set = new HashSet<>();
		
		Object k = set.stream().sorted().toArray()[0];
		int k1 = (Integer)k;
	}
}
