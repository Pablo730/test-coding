package _3_tow_pointers_sliding_window._6_연속된_자연수의_합_수학;

import java.util.*;
class Main {
	
	// Todo 연속 된 자연수의 합이 n과 같은 총 경우의 수 / 수학
	// Todo 연속 된 자연수 2개라면 1, 2로 n - 3을 뺀다음에 2로 나눠서 나머지가 0인지 체크한다
	List<Integer> list = new ArrayList<>();
	public int solution(int n){
		int answer = 0, cnt = 1;
		n--;
		while(n > 0){
			cnt++;
			n = n - cnt;
			if(n % cnt == 0) {
				answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		System.out.print(T.solution(n));
	}
}