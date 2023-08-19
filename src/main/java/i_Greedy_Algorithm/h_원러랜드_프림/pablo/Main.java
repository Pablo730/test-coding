package i_Greedy_Algorithm.h_원러랜드_프림.pablo;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int v;
		int cost;
		public Edge (int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge edge) {
			return this.cost - edge.cost;
		}
	}
	static int solution (int V, int[][] arr) {
		int answer = 0;
		Map<Integer, List<Edge>> listMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!listMap.containsKey(arr[i][0])) {
				listMap.put(arr[i][0], new ArrayList<>());
			}
			listMap.get(arr[i][0]).add(new Edge(arr[i][1], arr[i][2]));
			if (!listMap.containsKey(arr[i][1])) {
				listMap.put(arr[i][1], new ArrayList<>());
			}
			listMap.get(arr[i][1]).add(new Edge(arr[i][0], arr[i][2]));
		}
		
		boolean[] chkecks = new boolean[V + 1];
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(new Edge(1, 0));
		
		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();
			if (!chkecks[edge.v]) {
				answer += edge.cost;
				chkecks[edge.v] = true;
				for (Edge next: listMap.get(edge.v)) {
					priorityQueue.offer(next);
				}
			}
		}
		
		return answer;
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int V = in.nextInt();
		int E = in.nextInt();
		int[][] arr = new int[E][3];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
			arr[i][2] = in.nextInt();
		}
		System.out.println(solution(V, arr));
	}
}