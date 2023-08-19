package b_Array.b_보이는_학생;

import java.util.*;
class Main {
	
	// Todo 배열 arr안에서 차례대로 큰 수를 찾는다
	// Todo arr = { 1, 5, 4, 6, 8, 3, 7} -> { 1, 5, 6, 8}
	
	public int solution(int n, int[] arr){
		int answer = 1, max = arr[0];
		
		for(int i = 1; i < n; i++){
			if(arr[i] > max){
				max = arr[i];
				answer++;
			}
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(n, arr));
	}
}