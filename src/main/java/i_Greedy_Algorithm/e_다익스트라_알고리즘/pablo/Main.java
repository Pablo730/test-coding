package i_Greedy_Algorithm.e_다익스트라_알고리즘.pablo;

import java.util.*;

class Main {
	static class Edge implements Comparable<Edge>{
		public int vex;
		public int cost;
		Edge(int vex, int cost) {
			this.vex = vex;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge ob){
			return this.cost - ob.cost;
		}
	}
	public static int[] solution(int n, int[][] arr){
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < arr.length; i++) {
			graph.get(arr[i][0]).add(new Edge(arr[i][1], arr[i][2]));
		}
		
		int[] dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(new Edge(1, 0));
		dis[1] = 0;
		
		while(!priorityQueue.isEmpty()) {
			Edge tmp = priorityQueue.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if(nowCost > dis[now]) {
				continue;
			}
			for(Edge ob : graph.get(now)) {
				if(dis[ob.vex] > nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost;
					priorityQueue.offer(new Edge(ob.vex, nowCost + ob.cost));
				}
			}
		}
		
		return dis;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[m][3];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
			arr[i][2] = in.nextInt();
		}
		int[] res = solution(n, arr);
		for (int i = 2; i < res.length; i++) {
			if(res[i] != Integer.MAX_VALUE) {
				System.out.println(i + " : " + res[i]);
			}
			else {
				System.out.println(i + " : impossible");
			}
		}
	}
}
/*

6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

*/