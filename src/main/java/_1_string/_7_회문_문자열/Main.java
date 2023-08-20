package _1_string._7_회문_문자열;

import java.util.*;
class Main {
	
	// Todo [앞에서 읽을 때나 뒤에서 읽을 때나 같은] 문자열이 회문 문자열
	// Todo 문자열 str이 주어졌을 때 회문 문자열인지 확인해라 (대소문자 구분 없이!)
	
	public String solution(String str){
		String strUpperCase = str.toUpperCase();
		char[] chars = strUpperCase.toCharArray();
		int len = chars.length;
		
		for(int i=0; i < len / 2; i++){
			int left = i;
			int right = len - i - 1;
			if(chars[left] != chars[right]) {
				return "NO";
			}
		}
		return "YES";
	}
	
	public String solution2(String str){
		String answer="NO";
		String tmp=new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(tmp)) answer="YES";
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}

