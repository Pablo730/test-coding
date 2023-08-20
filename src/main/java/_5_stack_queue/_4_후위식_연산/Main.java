package _5_stack_queue._4_후위식_연산;
import java.util.*;
class Main {
	
	// Todo 후위식??? 무조건 스택!
	
	public int solution(String str){
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for(char x : str.toCharArray()){
			if(Character.isDigit(x)){
				stack.push(x - 48);
			}
			else {
				int rt = stack.pop();
				int lt = stack.pop();
				if(x == '+') {
					stack.push(lt + rt);
				} else if(x == '-') {
					stack.push(lt - rt);
				}
				else if(x == '*') {
					stack.push(lt * rt);
				} else if(x=='/') {
					stack.push(lt / rt);
				}
			}
		}
		answer = stack.get(0);
		return answer;
	}
	
	public int solutionP(String str){
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (char x: str.toCharArray()) {
			if (x != '+' && x != '-' && x != '*' && x != '/') {
				stack.push(Integer.parseInt(x + ""));
			} else {
				int v1 = stack.pop();
				int v2 = stack.pop();
				int v3 = 0;
				if (x == '+') {
					v3 += (v2 + v1);
				}
				if (x == '-') {
					v3 += (v2 - v1);
				}
				if (x == '*') {
					v3 += (v2 * v1);
				}
				if (x == '/') {
					v3 += (v2 / v1);
				}
				stack.push(v3);
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solutionP(str));
	}
}
