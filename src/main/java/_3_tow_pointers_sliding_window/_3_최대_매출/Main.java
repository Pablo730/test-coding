package _3_tow_pointers_sliding_window._3_최대_매출;

import java.util.*;
class Main {
	
	// Todo 특정 배열 arr안에서 k번 연속 된 수의 합이 가장 큰 값을 찾아라
	
	public int solution(int n, int k, int[] arr){
		int answer, sum = 0;
		// Todo 첫 번째 k번 연속 된 합을 구하고
		for(int i = 0; i < k; i++) {
			sum += arr[i];
		}
		answer = sum;
		
		// Todo 뒤에꺼 하나 더하고 앞에꺼 하나 뺀 후 비교한다
		for(int i = k; i < n; i++){
			sum += (arr[i] - arr[i - k]);
			answer = Math.max(answer, sum);
		}
		return answer;
	}
	
	public int solution1(int n, int k, int[] arr) {
		int answer = 0;
		for (int i = 0; i < n - k; i++) {
			int sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += arr[j];
			}
			answer = Math.max(answer, sum);
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
		System.out.print(T.solution1(n, k, arr));
	}
}