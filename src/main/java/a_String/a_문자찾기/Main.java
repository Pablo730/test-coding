package a_String.a_문자찾기;

import java.util.Scanner;
class Main{
	
	// Todo 문자열 str안에 [문자 t가 몇개가 있는지] 리턴하라 (대소문자 구분 없이!)
	
	public int solution(String str, char t){
		int answer = 0;
		
		// Todo 대소문자 구분을 없애기 위해 모두 대문자로
		String strUpperCase = str.toUpperCase();
		char charUpperCase = Character.toUpperCase(t);
		
		for(char x : strUpperCase.toCharArray()){
			if(x == charUpperCase) answer++;
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		System.out.print(T.solution(str, c));
	}
}