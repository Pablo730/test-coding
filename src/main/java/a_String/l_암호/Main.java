package a_String.l_암호;

import java.util.*;
class Main {
	
	// Todo 문자 개수 n과 암호화된 문자열 s가 주어졌을 때, 이를 해독한 문자열을 구해라
	// Todo 암호는 알파벳 한 문자마다 [# 또는 *로 일곱개로 구성]되어져있다
	// Todo #은 이진수의 1, *은 이진수의 0으로 된 값이다
	
	public String solution(int n, String s){
		String answer="";
		
		for(int i = 0; i < n; i++){
			// Todo [substring] [replace]
			String temp = s.substring(0, 7).replace('#', '1').replace('*', '0');
			
			// Todo [Integer.parseInt] 문자열과 2진수 -> 10진수로
			int num = Integer.parseInt(temp, 2);
			answer += (char)num;
			
			s = s.substring(7);
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