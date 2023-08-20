package _4_hashMap_hashSet_treeSet._2_아나그램;

import java.util.*;
class Main {
	
	// Todo
	
	public String solution(String s1, String s2){
		String answer="YES";
		HashMap<Character, Integer> map=new HashMap<>();
		for(char x : s1.toCharArray()){
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		for(char x : s2.toCharArray()){
			if(!map.containsKey(x) || map.get(x)==0) return "NO";
			map.put(x, map.get(x)-1);
		}
		return answer;
	}
	
	public String solutionPablo(String a, String b) {
		Map<Character,Integer> aMap = new HashMap<>();
		Map<Character,Integer> bMap = new HashMap<>();
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		
		for (int i = 0; i < aChars.length; i++) {
			aMap.merge(aChars[i], 1, Integer::sum);
			bMap.merge(bChars[i], 1, Integer::sum);
		}
		
		for (char key: aMap.keySet()) {
			if (aMap.get(key) != bMap.get(key)) {
				return "NO";
			}
		}
		
		return "YES";
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String a=kb.next();
		String b=kb.next();
		System.out.print(T.solution(a, b));
	}
}