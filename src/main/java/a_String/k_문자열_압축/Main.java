package a_String.k_문자열_압축;

import java.util.*;
class Main {
	
	// Todo 문자열 s안에서 문자가 [연속 반복]되는 경우 반복 문자를 [압축]하고 오른쪽에 [반복 횟수를 표기]한다
	// Todo KKHSSSSE -> K2HS4E
	public String solution(String s){
		String answer = "";
		s= s + " ";
		int cnt = 1;
		
		// Todo 문자열을 앞에서부터 순회하면서 바로 뒤 문자와 일치하는 체크한다
		for(int i = 0; i < s.length() - 1; i++){
			if( s.charAt(i) == s.charAt(i + 1)) {
				cnt++;
			} else{
				answer += s.charAt(i);
				if(cnt > 1) {
					answer += String.valueOf(cnt);
				}
				cnt=1;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}
