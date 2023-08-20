package _7_recursive_tree_graph_dfs_bfs._2_이진수_출력_재귀;

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
