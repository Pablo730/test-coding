package _6_sorting_searching._9_뮤직_비디오;

import java.util.*;
class Main {
	// Todo 어려웠다!!!!!!!!!!!!!!!!!!!!!!!!!
	// Todo 결정 알고리즘 -> 이분탐색을 활용하는 것
	
	public int solution(int n, int m, int[] arr){
		int answer = 0;
		
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			if(count(arr, mid) <= m){
				answer = mid;
				rt = mid-1;
			}
			else {
				lt = mid+1;
			}
		}
		return answer;
	}
	
	public int count(int[] arr, int capacity){
		int cnt = 1, sum = 0;
		for(int x : arr){
			if(sum + x > capacity){
				cnt++;
				sum = x;
			}
			else {
				sum += x;
			}
		}
		return cnt;
	}
	
	public int solutionP (int n, int m, int[] arr) {
		int left = 0, right = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > left) {
				left = arr[i];
			}
			right += arr[i];
		}
		
		while (left <= right) {
			int middle = (left + right) / 2;
			int cnt = m;
			int dvdTime = 0;
			for (int i = 0; i < n; i++) {
				if (dvdTime + arr[i] > middle) {
					cnt--;
					dvdTime = 0;
					if (cnt == 0) {
						break;
					}
				}
				dvdTime += arr[i];
			}
			if (cnt > 0) {
				answer = middle;
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		System.out.println(T.solutionP(n, m, arr));
	}
}