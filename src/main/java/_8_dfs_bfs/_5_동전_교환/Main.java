package _8_dfs_bfs._5_동전_교환;
import java.util.*;
class Main{
	static int n, m, answer=Integer.MAX_VALUE;
	public void DFS(int L, int sum, Integer[] arr){
		if(sum>m) return;
		if(L>=answer) return;
		if(sum==m){
			answer=Math.min(answer, L);
		}
		else{
			for(int i=0; i<n; i++){
				DFS(L+1, sum+arr[i], arr);
			}
		}
	}
	
	int solution (Integer[] arr, int m) {
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == m) {
				return 1;
			}
			queue.offer(arr[i]);
		}
		int level = 1;
		while (!queue.isEmpty()) {
			int len = queue.size();
			level++;
			for (int i = 0; i < len; i++) {
				int money = queue.poll();
				for (int j = 0; j < arr.length; j++) {
					if (money + arr[j] == m) {
						return level;
					} else if (money + arr[j] < m) {
						queue.offer(money + arr[j]);
					}
				}
			}
		}
		return level;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		Integer[] arr=new Integer[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		Arrays.sort(arr, Collections.reverseOrder());
		m=kb.nextInt();
//		T.DFS(0, 0, arr);
//		System.out.println(answer);
		System.out.println(T.solution(arr, m));
		
	}
}
