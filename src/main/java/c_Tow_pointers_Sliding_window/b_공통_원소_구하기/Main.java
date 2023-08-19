package c_Tow_pointers_Sliding_window.b_공통_원소_구하기;

import java.util.*;
class Main {
	
	// Todo 배열 두개의 공통 원소를 작은 숫자부터 순서대로 나열해라
	
	public List<Integer> solution(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		
		List<Integer> answer = new ArrayList<>();
		
		for (int i = 0; i < arr2.length; i++) {
			if (set.contains(arr2[i])) {
				answer.add(arr2[i]);
			}
		}
		return answer;
	}
	
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		ArrayList<Integer> answer = new ArrayList<>();
		Arrays.sort(a);
		Arrays.sort(b);
		int p1 = 0, p2 = 0;
		while(p1 < n && p2 < m){
			if(a[p1] == b[p2]){
				answer.add(a[p1++]);
				p2++;
			}
			else if(a[p1]<b[p2]) {
				p1++;
			}
			else {
				p2++;
			}
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
		for(int x : T.solution(a, b)) System.out.print(x+" ");
	}
}