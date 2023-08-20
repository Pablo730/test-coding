package _8_dfs_bfs._3_최대_점수_구하기;
import java.util.*;
class Main{
	static int answer=Integer.MIN_VALUE, n, m;
	boolean flag=false;
	public void DFS(int L, int sum, int time, int[] ps, int[] pt){
		if(time>m) return;
		if(L==n){
			answer=Math.max(answer, sum);
		}
		else{
			DFS(L+1, sum+ps[L], time+pt[L], ps, pt);
			DFS(L+1, sum, time, ps, pt);
		}
	}
	
	int dfs (int index, int sumScore, int sumTime, int limitMinute, int[] scores, int[] times) {
		if (index >= scores.length) {
			return sumScore;
		} else if (sumTime + times[index] > limitMinute) {
			return dfs(index + 1, sumScore, sumTime, limitMinute, scores, times);
		}
		int checkSum = dfs (index + 1, sumScore + scores[index], sumTime + times[index], limitMinute, scores, times);
		int noCheckSum = dfs (index + 1, sumScore, sumTime, limitMinute, scores, times);
		
		return Math.max(checkSum, noCheckSum);
	}
	
	int solution (int limitMinute, int[] scores, int[] times) {
		if (Arrays.stream(times).sum() <= limitMinute) {
			return Arrays.stream(scores).sum();
		}
		return dfs(0, 0, 0, limitMinute, scores, times);
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		for(int i=0; i<n; i++){
			a[i]=kb.nextInt();
			b[i]=kb.nextInt();
		}
		T.DFS(0, 0, 0, a, b);
		System.out.println(answer);
	}
}