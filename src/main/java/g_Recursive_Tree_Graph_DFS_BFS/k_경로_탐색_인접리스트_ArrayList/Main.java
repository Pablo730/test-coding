package g_Recursive_Tree_Graph_DFS_BFS.k_경로_탐색_인접리스트_ArrayList;
import java.util.*;
class Main {
	
	// Todo
	
	static int n, m, answer=0;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch;
	public void DFS(int v){
		if(v == n) answer++;
		else{
			for(int nv : graph.get(v)){
				if(ch[nv] == 0){
					ch[nv] = 1;
					DFS(nv);
					ch[nv] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args){
//		Main T = new Main();
//		Scanner kb = new Scanner(System.in);
//		n=kb.nextInt();
//		m=kb.nextInt();
//		graph = new ArrayList<ArrayList<Integer>>();
//		for(int i=0; i<=n; i++){
//			graph.add(new ArrayList<Integer>());
//		}
//		ch=new int[n+1];
//		for(int i=0; i<m; i++){
//			int a=kb.nextInt();
//			int b=kb.nextInt();
//			graph.get(a).add(b);
//		}
//		ch[1]=1;
//		T.DFS(1);
//		System.out.println(answer);
//
//		List<Integer> list = new ArrayList<>();
		
		Set<String> set = new HashSet<>();
		set.add("111");
		set.add("2222");
		
		for (String i: set) {
			System.out.println(i);
		}
	}
}
