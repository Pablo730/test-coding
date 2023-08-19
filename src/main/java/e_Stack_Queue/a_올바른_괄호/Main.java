package e_Stack_Queue.a_올바른_괄호;

import java.util.*;
class Main {
	
	// Todo 괄호 문제 나오면 무조건 스택이다
	
	public String solution(String str){
		String answer="YES";
		Stack<Character> stack=new Stack<>();
		for(char x : str.toCharArray()){
			if(x=='(') stack.push(x);
			else{
				if(stack.isEmpty()) return "NO";
				stack.pop();
			}
		}
		if(!stack.isEmpty()) return "NO";
		return answer;
	}
	
	public String solutionPablo(String str){
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();
		if (chars[0] != '(') {
			return "NO";
		}
		
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				stack.push(chars[i]);
			} else {
				if (stack.isEmpty() || stack.pop() != '(') {
					return "NO";
				}
			}
		}
		if(!stack.isEmpty()) {
			return "NO";
		}
		return "YES";
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solutionPablo(str));
	}
}