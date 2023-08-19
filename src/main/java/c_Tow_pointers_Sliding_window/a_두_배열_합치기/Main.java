package c_Tow_pointers_Sliding_window.a_두_배열_합치기;

import java.util.*;
class Main {
	
	// Todo 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐라
	// Todo ex) {1 3 5}, {2 3 6 7 9} -> {1 2 3 3 5 6 7 9}
	
	public List<Integer> solution(int n, int m, int[] a, int[] b){
		List<Integer> answer = new ArrayList<>();
		
		int p1 = 0, p2 = 0;
		
		while(p1 < n && p2 < m){
			if(a[p1] < b[p2]) {
				answer.add(a[p1++]);
			}
			else {
				answer.add(b[p2++]);
			}
		}
		
		while(p1 < n) {
			answer.add(a[p1++]);
		}
		
		while(p2 < m) {
			answer.add(b[p2++]);
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] a=new int[n];
		for(int i=0; i<n; i++){
			a[i]=kb.nextInt();
		}
		int m=kb.nextInt();
		int[] b=new int[m];
		for(int i=0; i<m; i++){
			b[i]=kb.nextInt();
		}
		for(int x : T.solution(n, m, a, b)) System.out.print(x+" ");
	}
}