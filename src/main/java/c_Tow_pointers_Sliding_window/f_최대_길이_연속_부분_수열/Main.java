package c_Tow_pointers_Sliding_window.f_최대_길이_연속_부분_수열;

import java.util.*;
class Main {
	
	// Todo 0과 1로 구성된 길이가 N인 수열
	// Todo 최대 k번을 0을 1로 변경할 수 있다
	// Todo 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾아라
	// Todo ex) n: 14 / k=2 / arr {1 1 0 0 1 1 0 1 1 0 1 1 0 1} -> 8
	// Todo 투포인터가 핵심!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	public int solution(int n, int k, int[] arr){
		int answer = 0, cnt = 0, lt = 0;
		for(int rt = 0; rt < n; rt++){
			if(arr[rt] == 0) {
				cnt++;
			}
			while(cnt > k){
				if(arr[lt] == 0) {
					cnt--;
				}
				lt++;
			}
			answer = Math.max(answer, rt - lt + 1);
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int k=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(n, k, arr));
	}
}