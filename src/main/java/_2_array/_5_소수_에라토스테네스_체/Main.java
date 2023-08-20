package _2_array._5_소수_에라토스테네스_체;

import java.util.*;
class Main {
	
	// Todo [1 ~ n 까지] 소수의 개수를 출력해라
	
	public int solution(int n){
		int cnt = 0;
		
		// Todo 자연수 n까지 체크하기 위해 인덱스 n + 1로 배열 생성
		int[] ch = new int[n + 1];
		
		for(int i = 2; i <= n; i++){
			// Todo 소수가 맞아?
			if(ch[i] == 0) {
				cnt++;
				// Todo 소수가 맞으면 그 배수들은 이제 모두 소수가 아니야
				for(int j = i; j <= n; j = j + i) {
					ch[j] = 1;
				}
			}
		}
		
		return cnt;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		System.out.println(T.solution(n));
	}
}