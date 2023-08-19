package h_DFS_BFS_활용.g_조합수_메모이제이션;
import java.util.*;
class Main{
	int[][] dy = new int[35][35];
	public int DFS(int n, int r) {
		if(dy[n][r] > 0) {
			return dy[n][r];
		}
		if(n == r || r == 0) {
			return 1;
		}
		else {
			return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
		}
	}
	
	int solution (int n, int r) {
		if (r == 0 && n == r) {
			return 1;
		}
		if (r == 1) {
			return n;
		}
		return solution(n - 1, r - 1) + solution (n - 1, r);
	}
	
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int r=kb.nextInt();
//		System.out.println(T.DFS(n, r));
		System.out.println(T.solution(n, r));
	}
}