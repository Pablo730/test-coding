package f_Sorting_Searching.b_버블_정령;

import java.util.*;
class Main {
	
	// Todo 버블 정렬 시, for문이 돌 때 마다 맨 마지막 놈 하나씩 고정 완료이다
	// Todo O n * n 시간 복잡도, 버블 정렬 최악
	
	public int[] solution(int n, int[] arr){
		for(int i = 0; i <n - 1; i++){
			for(int j = 0; j < n - i - 1; j++){ // 핵심
				if(arr[j] > arr[j + 1]){
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		return arr;
	}
	
	// Todo 잘못됨
	public int[] solutionP(int n, int[] arr) {
		int bubbleCnt = 1;
		while (bubbleCnt != 0) {
			bubbleCnt = 0;
			for (int i = 0; i < n - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					bubbleCnt++;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		for(int x : T.solution(n, arr)) System.out.print(x+" ");
	}
}
