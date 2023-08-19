package d_HashMap_HashSet_TreeSet.a_학급_회장_해쉬;

import java.util.*;
class Main {
	
	// Todo
	public char solution2(int n, String str) {
		char[] chars = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.merge(chars[i], 1, Integer::sum);
		}
		char[] nChars = {'A', 'B', 'C', 'D', 'E'};
		char answer = 'A';
		int max = 0;
		for (char nChar: nChars) {
			if(map.get(nChar) > max) {
				max = map.get(nChar);
				answer = nChar;
			}
		}
		return answer;
	}
	
	public char solution(int n, String s){
		char answer=' ';
		HashMap<Character, Integer> map=new HashMap<>();
		for(char x : s.toCharArray()){
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//System.out.println(map.containsKey('F'));
		//System.out.println(map.size());
		//System.out.println(map.remove('C'));
		
		int max=Integer.MIN_VALUE;
		for(char key : map.keySet()){
			//System.out.println(key+" "+map.get(key));
			if(map.get(key)>max){
				max=map.get(key);
				answer=key;
			}
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String str=kb.next();
		System.out.println(T.solution(n, str));
	}
}