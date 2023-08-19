package h_DFS_BFS_활용.o_피자_배달_거리.pablo;
import java.util.*;

class Main {
	static class Point{
		public int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int dfs(int level, int pizzaCnt, int m , int pizzaAllCnt, List<Point> homes, List<Point> pizzas, int[] combi ) {
		if(level == m){
			int sum = 0;
			for(Point h : homes) {
				int dis = Integer.MAX_VALUE;
				for(int i : combi){
					dis = Math.min(dis, Math.abs(h.x-pizzas.get(i).x) + Math.abs(h.y-pizzas.get(i).y));
				}
				sum += dis;
			}
			return sum;
		}
		
		int dis = Integer.MAX_VALUE;
		for(int i = pizzaCnt; i<pizzaAllCnt; i++){
			combi[level]=i;
			dis = Math.min(dis, dfs(level + 1, i + 1, m, pizzaAllCnt, homes, pizzas, combi));
		}
		return dis;
	}
	
	static int solution(int[][] arr, int m) {
		int n = arr.length;
		List<Point> homes = new ArrayList<>();
		List<Point> pizzas = new ArrayList<>();
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (arr[x][y] == 1) {
					homes.add(new Point(x, y));
					continue;
				}
				if (arr[x][y] == 2) {
					pizzas.add(new Point(x, y));
				}
			}
		}
		int pizzaAllCnt = pizzas.size();
		int[] combi = new int[m];
		return dfs(0, 0, m, pizzaAllCnt, homes, pizzas, combi);
	}
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(solution(arr, m));
	}
}