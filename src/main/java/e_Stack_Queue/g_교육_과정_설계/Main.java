package e_Stack_Queue.g_교육_과정_설계;

import java.util.*;
class Main {
	
	// Todo
	
	public String solution(String need, String plan){
		String answer="YES";
		Queue<Character> Q =new LinkedList<>();
		for(char x : need.toCharArray()) Q.offer(x);
		for(char x : plan.toCharArray()){
			if(Q.contains(x)){
				if(x!=Q.poll()) return "NO";
			}
		}
		if(!Q.isEmpty()) return "NO";
		return answer;
	}
	
	public String solutionP(String need, String plan) {
		Queue<Character> queue = new LinkedList<>();
		for (char x: need.toCharArray()) {
			queue.offer(x);
		}
		for (char x: plan.toCharArray()) {
			if(queue.contains(x) && x != queue.poll()) {
				return "NO";
			}
		}
		if(!queue.isEmpty()) {
			return "NO";
		}
		return "YES";
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String a=kb.next();
		String b=kb.next();
		System.out.println(T.solution(a, b));
	}
}