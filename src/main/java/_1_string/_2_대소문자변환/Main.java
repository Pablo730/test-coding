package _1_string._2_대소문자변환;

import java.util.*;
class Main {
	
	// Todo 문자열 str안에 [소문자->대문자] [대문자->소문자] 변경하라
	
	public String solution(String str){
		String answer = "";
		
		// Todo 문자 배열로 변경해서 문자 하나씩 체크
		for(char x : str.toCharArray()){
			if(Character.isLowerCase(x)) {
				answer += Character.toUpperCase(x);
			}
			else {
				answer += Character.toLowerCase(x);
			}
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.print(T.solution(str));
	}
}