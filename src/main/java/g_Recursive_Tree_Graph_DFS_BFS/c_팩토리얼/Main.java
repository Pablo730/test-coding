package g_Recursive_Tree_Graph_DFS_BFS.c_팩토리얼;

import java.util.*;
class Main {
	
	// Todo
	
	public int DFS (int n) {
		if(n == 1) {
			return 1;
		} else {
			return n * DFS(n - 1);
		}
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.DFS(5));
	}
}