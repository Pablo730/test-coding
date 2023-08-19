package g_Recursive_Tree_Graph_DFS_BFS.h_송아지_찾기_BFS;

import java.util.*;
class Main {
	
	// Todo
	int[] distant = {1, -1, 5};
	int[] check;
	Queue<Integer> Q = new LinkedList<>();
	public int BFS(int s, int e){
		check = new int[10001];
		check[s] = 1;
		Q.offer(s);
		int L = 0;
		while(!Q.isEmpty()){
			int len = Q.size();
			for(int i = 0; i < len; i++){
				int x = Q.poll();
				for(int j = 0; j < 3; j++){
					int nx = x + distant[j];
					if(nx == e){
						return L + 1;
					}
					if(nx >= 1 && nx <= 10000 && check[nx] == 0) { // 한번도 가본적이 없잖아!!
						check[nx]=1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}
	
	public int BFS_P(int s, int e) {
		int cnt = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		
		while (!queue.isEmpty()) {
			int len = queue.size();
			
			for (int i = 0; i < len; i++) {
				int current = queue.poll();
				if (current == e) {
					return cnt;
				} else {
					if (current > e) {
						queue.offer(current - 1);
					} else {
						if (current > e - 3) {
							queue.offer(current + 1);
						} else {
							queue.offer(current + 5);
						}
					}
				}
			}
			cnt++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int s=kb.nextInt();
		int e=kb.nextInt();
		System.out.println(T.BFS(s, e));
	}
}