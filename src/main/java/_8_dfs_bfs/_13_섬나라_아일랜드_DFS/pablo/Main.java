package _8_dfs_bfs._13_섬나라_아일랜드_DFS.pablo;

import java.util.*;

public class Main {
	static int solution(int[][] lands){
		int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
		boolean[][] visits = new boolean[lands.length][lands.length];
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < lands.length; i++) {
			for (int j = 0; j < lands.length; j++) {
				if (lands[i][j] == 1 && visits[i][j] == false) {
					visits[i][j] = true;
					queue.offer(new int[]{i, j});
					while (!queue.isEmpty()) {
						int len = queue.size();
						for (int k = 0; k < len; k++) {
							int[] curr = queue.poll();
							for (int l = 0; l < moves.length; l++) {
								int x = curr[0] + moves[l][0];
								int y = curr[1] + moves[l][1];
								if (x >= 0 && x < lands.length && y >= 0 && y < lands.length && lands[x][y] == 1 && visits[x][y] == false) {
									visits[x][y] = true;
									queue.offer(new int[]{x, y});
								}
							}
						}
					}
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[][] lands = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j =0; j < n; j++) {
				lands[i][j] = in.nextInt();
			}
		}
		System.out.println(Main.solution(lands));
	}
}