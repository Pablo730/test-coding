package b_Array.l_멘토링;
import java.util.*;
class Main {
	
	// Todo [n: 학생 수] / [m: 수학 시험 횟수] / [arr: n*m 2차원 배열 수학 시험 성적 순위]
	// Todo 모든 시험에서 멘티보다 시험을 잘봤어야 멘토가 될 수 있다
	// Todo 멘토-멘티 짝을 만들 수 있는 총 경우의 수를 구해라
	// Todo ex) n 4 m 3 {{3(1등), 4(2등), 1(3등), 2(4등)}, {4, 3, 2, 1}, {3, 1, 4, 2}}
	// Todo (멘토, 멘티) 짝 (3번째 학생, 1번째 학생), (3번째 학생, 2), (4, 2) 3가지
	
	public int solution(int n, int m, int[][] arr) {
		// Todo 모두 멘토가 될 수 있는 경우의 수
		int answer = 0;
		// Todo 멘토가 가능한 케이스를 저장한다
		int[][] wins = new int[n+1][n+1];
		// Todo m번의 시험을 봤다
		for (int i = 0; i < m; i++) {
			// Todo 학생 수는 n명이다
			for (int j = 0; j < n -1; j++) {
				// Todo 멘토링 가능한 케이스를 정리한다
				for (int k = j + 1; k < n; k++) {
					wins[arr[i][j]][arr[i][k]]++;
					wins[arr[i][k]][arr[i][j]]--;
				}
			}
		}
		for (int i = 0; i < wins.length; i++) {
			int[] win = wins[i];
			for (int j = 0; j < win.length; j++) {
				if(win[j] == m) {
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
		int m=kb.nextInt();
		int[][] arr=new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, m, arr));
	}
}
