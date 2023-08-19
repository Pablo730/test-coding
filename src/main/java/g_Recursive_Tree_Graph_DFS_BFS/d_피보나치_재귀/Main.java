package g_Recursive_Tree_Graph_DFS_BFS.d_피보나치_재귀;
import java.util.*;
class Main {
	
	// Todo
	
	public int DFS(int n) {
		if(n == 1) {
			return 1;
		}
		else if(n == 2) {
			return 1;
		}
		else {
			return DFS(n - 2) + DFS(n - 1);
		}
	}
	
	static int[] fibo;
	public int DFS2(int n) {
		if(fibo[n] > 0) {
			return fibo[n];
		}
		if(n == 1) {
			return fibo[n] = 1;
		} else if(n == 2) {
			return fibo[n] = 1;
		} else {
			return fibo[n] = DFS2(n - 2) + DFS2(n - 1);
		}
	}
	
	public static void main(String[] args){
		Main T = new Main();
		int n=10;
		for(int i=1; i<=n; i++) System.out.print(T.DFS(i)+" ");
		
		Main T2 = new Main();
		int n2=45;
		fibo=new int[n2+1];
		T2.DFS(n2);
		for(int i=1; i<=n2; i++) System.out.print(fibo[i]+" ");
	}
}