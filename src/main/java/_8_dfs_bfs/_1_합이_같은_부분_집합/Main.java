package _8_dfs_bfs._1_합이_같은_부분_집합;
import java.util.*;
class Main{
	
	// Todo 부분집합? 일단 DFS 생각하자 원소로 사용한다? 사용하지 않는다. 사용한다? 사용하지 않는다!
	
	static String answer = "NO";
	static int n, total = 0;
	boolean flag = false;
	public void DFS(int level, int sum, int[] arr){
		if(flag) {
			return;
		}
		if(sum > total / 2) {
			return;
		}
		if(level == n) {
			if((total - sum) == sum) {
				answer = "YES";
				flag = true;
			}
		} else {
			DFS(level + 1, sum + arr[level], arr);
			DFS(level + 1, sum, arr);
		}
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = kb.nextInt();
			total += arr[i];
		}
		T.DFS(0, 0, arr);
		System.out.println(answer);
	}
}
