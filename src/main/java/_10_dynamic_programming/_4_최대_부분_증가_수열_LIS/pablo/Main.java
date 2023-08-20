package _10_dynamic_programming._4_최대_부분_증가_수열_LIS.pablo;
import java.util.*;

public class Main {
	static int[][] memo;
	static int dfs (int level, int currIndex, int[] arr) {
		if (currIndex == arr.length - 1) {
			return level;
		}
		
		int max = level;
		
		int currValue = 0;
		if (currIndex != -1) {
			currValue = arr[currIndex];
		}
		
		for (int i = currIndex + 1; i < arr.length; i++) {
			if(currValue < arr[i]) {
				if (memo[level + 1][i] == 0) {
					max = memo[level + 1][i] = Math.max(max, dfs(level + 1, i, arr));
					continue;
				}
				max = Math.max(max, memo[level + 1][i]);
			}
		}
		
		return max;
	}
	static int solution(int[] arr) {
		memo = new int[arr.length + 1][arr.length + 1];
		return dfs(0, -1, arr);
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(solution(arr));
	}
}