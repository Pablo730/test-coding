package _1_string._4_단어_뒤집기;

import java.util.*;
class Main {
	
	// Todo 문자열 배열 strs 안에 모든 문자열을 [반대로 뒤집어라]
	
	public List<String> solution(int n, String[] strs){
		ArrayList<String> answer = new ArrayList<>();
		
		// Todo [StringBuilder.reverse] 를 활용한 뒤집기
		for(String x : strs){
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
		}
		
		// Todo temp로 직접 뒤집기
		ArrayList<String> answer2 = new ArrayList<>();
		for(String x : strs){
			char[] chars = x.toCharArray();
			int left = 0, right = chars.length - 1;
			while (left < right) {
				char temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
				left++;
				right++;
			}
			answer2.add(String.valueOf(chars));
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String[] str=new String[n];
		for(int i=0; i<n; i++){
			str[i]=kb.next();
		}
		for(String x : T.solution(n, str)){
			System.out.println(x);
		}
	}
}
