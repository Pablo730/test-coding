package a_String.j_가장_짧은_문자_거리;

import java.util.*;
class Main {
	
	// Todo 문자열 s안에서 특정 문자 t와 [떨어진 최소 거리]를 순서대로 구해라
	
	public int[] solution(String s, char t){
		int[] answer= new int[s.length()];
		
		int p = 1000;
		
		// Todo 문자열 안을 왼쪽부터 순회하면서 특정 문자 t와 일치하는지 체크
		for(int left=0; left < s.length(); left++){
			if(s.charAt(left) == t){
				p = 0;
				answer[left] = p;
			}  else{
				p++;
				answer[left] = p;
			}
		}
		
		p=1000;
		
		// Todo 문자열 안을 오른쪽부터 순회하면서 특정 문자 t와 일치하는지 체크
		for(int right = s.length() - 1; right >= 0; right--){
			if(s.charAt(right) == t) {
				p=0;
			}
			else{
				p++;
				answer[right] = Math.min(answer[right], p);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		char c=kb.next().charAt(0);
		for(int x : T.solution(str, c)){
			System.out.print(x+" ");
		}
	}
}
