package f_Sorting_Searching.c_삽입_정렬;

import java.util.*;
class Main {
	
	// Todo 삽입 정렬 문제가 제일 기억이 안남는다! 마지막까지 한번 더 봐야할 놈!
	// Todo O n * n 시간 복잡도, 선택 정렬, 버블 정렬보다 낫다
	
	public int[] solution(int n, int[] arr){
		for(int i=1; i<n; i++){
			int tmp=arr[i], j;
			for(j=i-1; j>=0; j--){
				if(arr[j]>tmp) arr[j+1]=arr[j];
				else break;
			}
			arr[j+1]=tmp;
		}
		return arr;
	}
	public int[] solutionP(int n, int[] arr) {
		for (int i = 1; i < n; i++) {
			int temp = arr[i], j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > temp) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = temp;
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
