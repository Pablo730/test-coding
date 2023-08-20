package _1_string._6_중복_문자_제거;

import java.util.*;
class Main {
	
	// Todo 문자열 str안에 [중복된 문자를 제거]한 문자열을 출력한다
	
	public String solution(String str){
		String answer="";
		
		for(int i=0; i<str.length(); i++){
			// Todo 문자열 특정 위치에서 찾은 문자가 [indexOf]의 위치를 같은지 확인
			if(str.indexOf(str.charAt(i)) == i) {
				answer += str.charAt(i);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}