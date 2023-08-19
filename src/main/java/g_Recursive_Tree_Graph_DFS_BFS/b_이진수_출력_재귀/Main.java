package g_Recursive_Tree_Graph_DFS_BFS.b_이진수_출력_재귀;
import java.util.*;
class Main {
	
	// Todo
	
	public void DFS(int n){
		if(n==0) return;
		else{
			DFS(n/2);
			System.out.print(n%2);
		}
	}
	
public void solution(int n){
		DFS(n);
	}
	public static void main(String[] args){
		Main T = new Main();
		T.solution(11);
		//System.out.println(T.solution(3));
	}
}
