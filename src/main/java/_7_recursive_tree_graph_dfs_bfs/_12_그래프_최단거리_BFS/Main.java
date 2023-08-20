package _7_recursive_tree_graph_dfs_bfs._12_그래프_최단거리_BFS;
import java.util.*;
class Main {
	
	// Todo
	
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] check, distant;
	public void BFS(int v){
		check[v] = 1;
		distant[v] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		while(!queue.isEmpty()){
			int currentVertex = queue.poll();
			for(int nextVertex : graph.get(currentVertex)){
				if(check[nextVertex] == 0){
					check[nextVertex] = 1;
					queue.offer(nextVertex);
					distant[nextVertex] = distant[currentVertex] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Main T  =  new Main();
		Scanner kb  =  new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<= n; i++){
			graph.add(new ArrayList<Integer>());
		}
		check = new int[n + 1];
		distant = new int[n + 1];
		for(int i = 0; i<m; i ++){
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
		}
		T.BFS(1);
		for(int i = 2; i<= n; i++){
			System.out.println(i + " : " + distant[i]);
		}
	}
}