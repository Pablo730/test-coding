package h_DFS_BFS_활용.k_미로의_최단_거리_통로.pablo;
import java.util.*;

public class Main {
	static class Position {
		int x;
		int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int solution(int[][] board) {
		int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		board[0][0] = 1;
		Queue<Position> queue = new LinkedList<>();
		
		queue.offer(new Position(0, 0));
		int level = 0;
		boolean check = false;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Position curr = queue.poll();
				if (curr.x == 6 && curr.y == 6) {
					check = true;
					return level;
				}
				for (int j = 0; j < 4; j++) {
					int nextX = curr.x + moves[j][0];
					int nextY = curr.y + moves[j][1];
					if (nextX >= 0 && nextX <= 6 && nextY >= 0 && nextY <= 6 && board[nextX][nextY] == 0) {
						board[nextX][nextY] = 1;
						queue.offer(new Position(nextX, nextY));
					}
				}
			}
			level++;
		}
		if (check == false) {
			return -1;
		}
		return level;
	}
	
	public static void main(String[] args){
//		Scanner in=new Scanner(System.in);
//		int[][] board = new int[7][7];
//		for (int i = 0; i < 7; i++) {
//			for (int j = 0; j < 7; j++) {
//				board[i][j] = in.nextInt();
//			}
//		}
//		System.out.println(solution(board));
		String answer = "";
		String[] words = "  1aaa   1a            ".replace(' ', '@').toLowerCase().split("@");
		System.out.println(words.length);
		for (int i = 0; i < words.length; i++) {
			if(words[i].length() == 0) {
				answer += " ";
			}
			else if (Character.isDigit(words[i].charAt(0))) {
				answer += words[i];
			}
			else {
				answer += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
			}
			if (words[i].length() != 0 && i < words.length - 1) {
				answer += " ";
			}
		}
		System.out.println("1");
		System.out.println(answer);
		System.out.println("1");
		
	}
}