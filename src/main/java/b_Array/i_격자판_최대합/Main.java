package b_Array.i_격자판_최대합;

import java.util.*;
class Main {
	
	// Todo n*n 2차원 배열 arr에서 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력해라
	
	public int solution(int n, int[][] arr){
		int answer = Integer.MIN_VALUE;
		int sum1 = 0, sum2 = 0;
		
		for(int i = 0; i < n; i++){
			// Todo 각 행의 합
			// Todo 각 열의 합
			sum1 = sum2 = 0;
			for(int j = 0; j < n; j++){
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		sum1 = sum2 = 0;
		// Todo 왼쪽 대각선의 합
		// Todo 오른쪽 대각선의 합
		for(int i=0; i<n; i++){
			sum1+=arr[i][i];
			sum2+=arr[i][n-i-1];
		}
		
		answer=Math.max(answer, sum1);
		answer=Math.max(answer, sum2);
		
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[][] arr=new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
	}
}
