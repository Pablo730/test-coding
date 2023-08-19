package f_Sorting_Searching.h_이분_검색;

import java.util.*;
class Main {
	
	// Todo 정렬 시킨 후 이분 검색을 하면 순차 검색보다 더 빠르게 찾을 수 있다
	public int solution(int n, int m, int[] arr){
		int answer = 0;
		Arrays.sort(arr);
		int lt = 0, rt = n-1;
		while(lt <= rt){
			int mid = (lt + rt) / 2;
			if(arr[mid] == m){
				answer = mid + 1;
				break;
			}
			if(arr[mid] > m)  {
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
		}
		return answer;
	}
	
	// Todo 바이너리 서치를 아는게 중요한거라고!!
	public int solutionP (int n, int m, int[] arr) {
		Arrays.sort(arr);
		// Todo 이놈은 순차 검색 O (n)
		for (int i = 0; i < n; i++) {
			if (arr[i] == m) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		System.out.println(T.solution(n, m, arr));
	}
}
