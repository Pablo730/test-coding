package g_Recursive_Tree_Graph_DFS_BFS.f_부분집합_구하기_DFS;

import java.util.*;
class Main {
	
	// Todo 부분집합?????? DFS는 무조건 정복해야한다!!!!!!!!!!
	
	static int n;
	static int[] check;
	public void DFS(int L){
		if(L == n + 1){
			String temp = "";
			for(int i = 1; i <= n; i++){
				if(check[i] == 1) {
					temp += (i + " ");
				}
			}
			if(temp.length() > 0) {
				System.out.println(temp);
			}
		} else{
			check[L] = 1;
			DFS(L + 1);
			check[L] = 0;
			DFS(L + 1);
		}
	}
	
	public static void main(String[] args){
		Main T = new Main();
		n = 5;
		check = new int[n + 1];
		T.DFS(1);
	}
}
