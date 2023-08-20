package _1_string._9_숫자만_추출;

import java.util.*;
class Main {
	
	// Todo 문자열 s안에서 숫자만 추출해서 자연수를 리턴해라
	
	public int solution(String s){
		//int answer=0;
		String answer = "";
		for(char x : s.toCharArray()){
			//if(x>=48 && x<=57) answer = answer*10 + (x-48);
			/*if(Character.isDigit(x)){
				answer=answer*10+ Character.getNumericValue(x);
			}*/
			// Todo [Character.isDigit] 으로 특정 문자가 숫자가 맞는지 검사한다
			if(Character.isDigit(x)) {
				answer += x;
			}
		}
		return Integer.parseInt(answer);
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}
