package _7_recursive_tree_graph_dfs_bfs._10_경로_탐색_DFS;
import java.util.*;
class Main {
	
	// Todo
	static int n, m, answer=0;
	static int[][] graph;
	static int[] check;
	public void DFS(int v){
		if(v == n) {
			answer++;
		}
		else{
			for(int i = 1; i <= n; i++) {
				if(graph[v][i] == 1 && check[i] == 0) {
					check[i] = 1;
					DFS(i);
					check[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		graph = new int[n+1][n+1];
		check = new int[n+1];
		for(int i=0; i<m; i++){
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph[a][b] = 1;
		}
		check[1] = 1;
		T.DFS(1);
		System.out.println(answer);
	}
}
