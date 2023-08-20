package _2_array._11_임시_반장_정하기;

import java.util.*;
class Main {
	
	// Todo 2차원 배열 arr에서 첫번째 인덱스는 학생, 두번째 인덱스는 그 학생이 학년마다 몇반이었는지 나타낸다
	// Todo 같은 반을 많이 했던 학생을 구해라
	// Todo ex) {{2, 3, 1, 7, 3}, {4 1 9 6 8}, {5 5 2 4 4}, {6 5 2 6 7}, {8 4 2 2 2}} -> 4
	
	public int solution(int n, int[][] arr){
		int answer = 0, max = 0;
		
		// Todo arr의 1번째 부터 입력해서 이럼
		for(int i = 1; i <= n; i++){
			int cnt = 0;
			
			for(int j = 1; j <= n; j++){
				for(int k = 1; k <= 5; k++){
					// Todo 같은 반이었던 적이 한번이라도 있냐?
					if(arr[i][k] == arr[j][k]){
						cnt++;
						break;
					}
				}
				
			}
			// Todo cnt는 최소 1번은 무조건 나오지
			if(cnt > max){
				max = cnt;
				answer = i;
			}
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[][] arr=new int[n+1][6];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=5; j++){
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
	}
}