package a_String.e_특정_문자_뒤집기;

import java.util.*;
class Main {
	
	// Todo 문자열 str안에서 [알파벳만 뒤집힌 문자열]을 출력한다
	
	public String solution(String str){
		String answer;
		char[] chars = str.toCharArray();
		int left = 0, right = str.length()-1;
		
		while(left < right){
			// Todo [Character.isAlphabetic] 왼쪽 문자 하나가 알파벳이 아니면
			if(!Character.isAlphabetic(chars[left])) {
				left++;
			}
			// Todo [Character.isAlphabetic] 오른쪽 문자 하나가 알파벳이 아니면
			else if(!Character.isAlphabetic(chars[right])) {
				right--;
			}
			// Todo 왼쪽, 오른쪽 둘다 알파벳이 맞으면
			else{
				char tmp = chars[left];
				chars[left] = chars[right];
				chars[right] = tmp;
				left++;
				right--;
			}
		}
		
		answer = String.valueOf(chars);
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}