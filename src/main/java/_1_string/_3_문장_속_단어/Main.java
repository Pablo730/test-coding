package _1_string._3_문장_속_단어;

import java.util.*;
class Main {
	
	// Todo 문자열 str안에 [가장 긴 단어]를 찾아라
	
	public String solution(String str){
		String answer = "";
		
		int minValue = Integer.MIN_VALUE;
		
		String[] strs = str.split(" ");
		
		for(String x : strs){
			int len = x.length();
			
			// Todo 가장 긴 단어인지 체크
			if(len > minValue){
				minValue = len;
				answer = x;
			}
			
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		System.out.print(T.solution(str));
	}
}

