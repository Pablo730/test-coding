package _5_stack_queue._2_괄호_문자_제거;

import java.util.*;
class Main {
	
	// Todo
	public String solution(String str){
		String answer="";
		Stack<Character> stack=new Stack<>();
		for(char x : str.toCharArray()){
			if(x==')'){
				while(stack.pop()!='(');
			}
			else {
				stack.push(x);
			}
		}
		for(int i=0; i<stack.size(); i++) {
			answer+=stack.get(i);
		}
		return answer;
	}
	
	public String solutionPablo(String str){
		String answer="";
		
		Stack<Character> stack = new Stack<>();
		
		for (char x: str.toCharArray()) {
			if (x == '(') {
				stack.push(x);
			} else if (x == ')') {
				stack.pop();
			} else if (stack.isEmpty()) {
				answer += x;
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