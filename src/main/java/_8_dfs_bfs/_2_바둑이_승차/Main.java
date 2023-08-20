package _8_dfs_bfs._2_바둑이_승차;
import java.util.*;
class Main{
	static int answer = Integer.MIN_VALUE;
	static int	c;
	static int n;
	public void DFS (int L, int sum, int[] arr) {
		if(sum > c) return;
		if(L==n){
			answer = Math.max(answer, sum);
		}
		else{
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}
	}
	
	
	int dfs (int index, int c, int sum, int[] arr) {
		if (sum > c) {
			return 0;
		} else if (index >= arr.length) {
			return sum;
		}
		else if (sum + arr[index] == c) {
			return sum + arr[index];
		}
		else if (sum + arr[index] > c) {
			return dfs(index + 1, c, sum, arr);
		}
		
		int checkSum = dfs(index + 1, c, sum + arr[index], arr);
		
		int noCheckSum = dfs(index + 1, c, sum, arr);
		
		return Math.max(checkSum, noCheckSum);
	}
	
	int solution (int c, int[] arr) {
		if (Arrays.stream(arr).sum() <= c) {
			return Arrays.stream(arr).sum();
		}
		
		return dfs(0, c, 0, arr);
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		c=kb.nextInt();
		n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		T.DFS(0, 0, arr);
//		System.out.println(answer);
		System.out.println(T.solution(c, arr));
	}
}
