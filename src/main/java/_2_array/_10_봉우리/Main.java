package _2_array._10_봉우리;

import java.util.*;
class Main {
	
	// Todo n*n 격자 2차원 배열 arr안에서 [봉우리가 몇개 있는지] 확인해라
	// Todo 격자의 가장 자리들은 모두 0으로 초기화 되어있다
	// Todo 각 격자판의 숫자 중 자신의 [상하좌우 숫자보다 커야]만 봉우리다
	
	public int solution(int n, int[][] arr){
		int answer = 0;
		
		int[] dx={-1, 0, 1, 0};
		int[] dy={0, 1, 0, -1};
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				boolean flag = true;
				for(int k = 0; k < 4; k++){
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]){
						flag = false;
						break;
					}
				}
				if(flag) {
					answer++;
				}
			}
		}
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