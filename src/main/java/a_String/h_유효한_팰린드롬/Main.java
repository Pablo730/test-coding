package a_String.h_유효한_팰린드롬;


import java.util.*;
class Main {
	
	// Todo 회문 문자열 = 팰린드롬 // 문자열 s가 팰린드롬이 맞는지 검사한다
	// Todo [알파벳 이외의 문자들은 무시한다] [대소문자도 구분하지 않는다]
	// Todo aW:cr09RC0wA  ->  팰린드롬이 맞다
	
	public String solution(String s){
		// Todo 문자열 s안에 알파벳 이외의 문자들은 모두 제거한다 [replaceAll]
		String strOnlyAlphabetUpperCase = s.toUpperCase().replaceAll("[^A-Z]", "");
		
		// Todo 변경한 문자열을 반대로 뒤집어서 같은 문자열이 맞는지 검사한다 [StringBuilder.reverse]
		String reverse = new StringBuilder(strOnlyAlphabetUpperCase).reverse().toString();
		
		if(strOnlyAlphabetUpperCase.equals(reverse)) {
			return "YES";
		}
		
		return "NO";
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		System.out.print(T.solution(str));
	}
}