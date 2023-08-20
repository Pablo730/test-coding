package _8_dfs_bfs._10_미로_탐색_DFS.pablo;

import java.util.Scanner;

public class Main {
	
	static int dfs(int x, int y, int[][] moves, int[][] board) {
		int sum = 0;
		if (x == 6 && y == 6) {
			return 1;
		}
		for (int i = 0; i < 4; i++) {
			int nextX = x + moves[i][0];
			int nextY = y + moves[i][1];
			if (nextX >= 0 && nextX <= 6 && nextY >= 0 && nextY <= 6 && board[nextX][nextY] == 0) {
				board[nextX][nextY] = 1;
				sum += dfs(nextX, nextY, moves, board);
				board[nextX][nextY] = 0;
			}
		}
		return sum;
	}
	
	static int solution (int[][] board) {
		int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		board[0][0] = 1;
		return dfs(0, 0, moves, board);
	}
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int[][] board = new int[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				board[i][j] = in.nextInt();
			}
		}
		System.out.println(solution(board));
	}
}