package f_Sorting_Searching.j_마구간_정하기;
import java.util.*;
class Main {
	
	// Todo
	
	public int solution(int n, int c, int[] arr){
		int answer = 0;
		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[n - 1];
		while(lt <= rt){
			int mid = (lt + rt) / 2;
			if(count(arr, mid) >= c){
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}
		return answer;
	}
	
	public int count(int[] arr, int dist){
		int cnt = 1;
		int ep = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(arr[i] - ep >= dist){
				cnt++;
				ep = arr[i];
			}
		}
		return cnt;
	}
	
	public int countP(int[] xi, int capacity) { // 4 //2 // 3
		int curr = xi[0]; // 1
		int cnt = 1;
		for (int i = 1; i < xi.length; i++) {
			if (xi[i] - curr >= capacity) { // i = 3 // i = 2 //
				cnt++; // 2 // 2
				curr = xi[i]; // 8 // 4
			}
		}
		return cnt; // 2 // 3
	}
	
	public int solutionP(int N, int C, int[] xi) {
		int answer = 0;
		Arrays.sort(xi);
		int left = xi[1] - xi[0]; // 2 - 1 = 1
		int right = xi[N - 1] - xi[0]; // 9 - 1 = 8
		
		while (left <= right) {
			int middle = (left + right) / 2; // 4 // 2 // 3
			
			if (countP(xi, middle) < C) {
				right = middle - 1; // 3
			} else {
				left = middle + 1; // 3
				answer = middle;
			}
		}
		return answer;
	}
	
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int c=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		System.out.println(T.solution(n, c, arr));
	}
}
