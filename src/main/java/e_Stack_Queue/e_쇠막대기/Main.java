package e_Stack_Queue.e_쇠막대기;
import java.util.*;
class Main {
	
	// Todo 문제를 단순하게만 보면 풀기 어려운 문제다, 경험이 필요한 문제다, 기억을 오래 갖자
	
	public int solution(String str) {
		int cnt = 0;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '(') {
				stack.push('(');
			} else{
				stack.pop();
				if(str.charAt(i-1) == '(') {
					cnt += stack.size();
				} else {
					cnt++;
				}
			}
		}
		return cnt;
	}
	public int solutionP(String str){
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(chars[i] == '(') {
				stack.push(chars[i]);
			} else {
				stack.pop();
				if(chars[i -1] == '(') {
					answer += stack.size();
				} else {
					answer++;
				}
			}
		}
		
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}
