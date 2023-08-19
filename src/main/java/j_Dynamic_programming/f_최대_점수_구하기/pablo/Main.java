package j_Dynamic_programming.f_최대_점수_구하기.pablo;

import java.util.*;

public class Main {

	static int solution (int[][] arr, int M) {
		int[] dy = new int[M + 1];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = M; j >= arr[i][1]; j--) {
				dy[j] = Math.max(dy[j], dy[j - arr[i][1]] + arr[i][0]);
			}
		}
		
		return dy[M];
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		System.out.println(solution(arr, M));
	}
}
