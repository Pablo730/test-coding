package i_Greedy_Algorithm.g_원더랜드_크루스칼.pablo;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int cost;
		
		public Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge edge) {
			return this.cost - edge.cost;
		}
	}
	static int find (int V, int[] vs) {
		if(vs[V] == V) {
			return V;
		}
		return vs[V] = find(vs[V], vs);
	}
	
	static boolean union (int v1, int v2, int[] vs) {
		int findV1 = find(v1, vs);
		int findV2 = find(v2, vs);
		if (findV1 != findV2) {
			vs[findV1] = findV2;
			return true;
		}
		return false;
	}
	
	static int solution (int V, int[][] arr) {
		List<Edge> edges = new ArrayList<>();
		for (int[] ints : arr) {
			edges.add(new Edge(ints[0], ints[1], ints[2]));
		}
		Collections.sort(edges);
		int[] vs = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			vs[i] = i;
		}
		int answer = 0;
		for(Edge edge: edges) {
			if (union(edge.v1, edge.v2, vs)) {
				answer += edge.cost;
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
