package h_DFS_BFS_활용.h_수열_추측하기;
import java.util.*;
class Main{
	static int[] b, p, ch;
	static int n, f;
	boolean flag=false;
	int[][] dy=new int[35][35];
	public int combi(int n, int r){
		if(dy[n][r]>0) return dy[n][r];
		if(n==r || r==0) return 1;
		else return dy[n][r]=combi(n-1, r-1)+combi(n-1, r);
	}
	
	public void DFS(int L, int sum){
		if(flag) return;
		if(L==n){
			if(sum==f){
				for(int x : p) System.out.print(x+" ");
				flag=true;
			}
		}
		else{
			for(int i=1; i<=n; i++){
				if(ch[i]==0){
					ch[i]=1;
					p[L]=i;
					DFS(L+1, sum+(p[L]*b[L]));
					ch[i]=0;
				}
			}
		}
	}
	
	int calculate(int[] arr) {
		if (arr.length == 1) {
			return arr[0];
		}
		if (arr.length == 2) {
			return arr[0] + arr[1];
		}
		
		while (arr.length > 1) {
			int[] nextArr = new int[arr.length - 1];
			for (int i = 0; i < nextArr.length; i++) {
				nextArr[i] = arr[i] + arr[i + 1];
			}
			arr = nextArr;
		}
		
		return arr[0];
	}
	
	boolean isFlag = false;
	static int[] guess;
	void dfs (int level, int[] arr, int f) {
		if(isFlag) {
			return;
		}
		if (level == arr.length) {
			if (calculate(guess) == f) {
				isFlag = true;
//				for (int x: guess) System.out.print(x + " ");
//				System.out.println();
//				isFlag = true;
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0) {
					guess[level] = i + 1;
					arr[i] = 1;
					dfs(level + 1, arr, f);
					arr[i] = 0;
				}
			}
		}
	}
	
	int[] solution (int n, int f) {
		int[] arr = new int[n];
		guess = new int[n];
		dfs(0, arr,  f);
		return guess;
	}
	
	
	
	public static void main(String[] args){
		Main T = new Main();
//		Scanner kb = new Scanner(System.in);
//		n=kb.nextInt();
//		f=kb.nextInt();
//		b=new int[n];
//		p=new int[n];
//		ch=new int[n+1];
//		for(int i=0; i<n; i++){
//			b[i]=T.combi(n-1, i);
//		}
//		T.DFS(0, 0);
		T.solution(4, 16);
		for (int x: guess) System.out.print(x + " ");
	}
}