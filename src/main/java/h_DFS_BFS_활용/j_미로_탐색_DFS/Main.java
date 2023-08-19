package h_DFS_BFS_활용.j_미로_탐색_DFS;
import java.util.*;
class Main {
	static int[] dx={-1, 0, 1, 0};
	static int[] dy={0, 1, 0, -1};
	static int[][] board;
	static int answer=0;
	
	public int DFS(int x, int y) {
		int sum = 0;
		if(x==7 && y==7) return 1;
		else{
			for(int i=0; i<4; i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
					board[nx][ny] = 1;
					sum += DFS(nx, ny);
					board[nx][ny] = 0;
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		board=new int[8][8];
		for(int i=1; i<=7; i++){
			for(int j=1; j<=7; j++){
				board[i][j]=kb.nextInt();
			}
		}
		board[1][1]=1;
		
		System.out.print(T.DFS(1, 1));
	}
}