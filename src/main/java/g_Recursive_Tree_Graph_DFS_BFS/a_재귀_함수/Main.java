package g_Recursive_Tree_Graph_DFS_BFS.a_재귀_함수;
import java.util.*;
class Main {
	
	// Todo
	
	public void DFS(int n){
		if(n > 0) {
			DFS(n-1);
			System.out.print(n+" ");
		}
	}
	
	public void solution(int n){
		DFS(n);
	}
	public static void main(String[] args){
		Main T = new Main();
		T.solution(3);
		//System.out.println(T.solution(3));
	}
}