package _8_dfs_bfs._12_토마토.pablo;

import java.util.*;

public class Main {
	public static int solution (int[][] box) {
		int[][] b = new int[box.length + 2][box[0].length + 2];
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				b[i][j] = -1;
			}
		}
		
		boolean checkTomato = true;
		for (int i = 1; i <= box.length; i++) {
			for (int j = 1; j <= box[0].length; j++) {
				b[i][j] = box[i - 1][j - 1];
				if (box[i - 1][j - 1] == 0) {
					checkTomato = false;
				}
			}
		}
		if (checkTomato) {
			return 0;
		}
		
		Queue<Integer[]> queue = new LinkedList<>();
		int level = 0;
		
		for (int i = 1; i < b.length - 1; i++) {
			for (int j = 1; j < b[0].length - 1; j++) {
				if (b[i][j] == 0) {
					if (b[i - 1][j] == -1 && b[i + 1][j] == -1 && b[i ][j - 1] == -1 && b[i ][j + 1] == -1) {
						return -1;
					}
					if (b[i - 1][j] == 1 || b[i + 1][j] == 1 || b[i ][j - 1] == 1 || b[i ][j + 1] == 1) {
						queue.offer(new Integer[]{i, j});
					}
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Integer[] trans = queue.poll();
				b[trans[0]][trans[1]] = 1;
			}
			level++;
			boolean check = true;
			for (int i = 1; i < b.length - 1; i++) {
				for (int j = 1; j < b[0].length - 1; j++) {
					if (b[i][j] == 0) {
						check = false;
						if (b[i - 1][j] == -1 && b[i + 1][j] == -1 && b[i ][j - 1] == -1 && b[i ][j + 1] == -1) {
							return -1;
						}
						if (b[i - 1][j] == 1 || b[i + 1][j] == 1 || b[i ][j - 1] == 1 || b[i ][j + 1] == 1) {
							queue.offer(new Integer[]{i, j});
						}
					}
				}
			}
			if (check) {
				return level;
			}
		}
		return level;
	}
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		int[][] box = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = in.nextInt();
			}
		}
		System.out.print(Main.solution(box));
	}
}