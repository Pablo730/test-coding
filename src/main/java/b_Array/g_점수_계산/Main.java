package b_Array.g_점수_계산;

import java.util.*;
class Main {
	
	// Todo 배열 arr에 O,X 문제를 맞췄는지 정보가 들어가 있다
	// Todo 기본적으로 맞추면 점수가 1점이지만, 연속으로 문제를 맞췄을 경우 연속된 점수를 얻는다
	
	public int solution(int n, int[] arr){
		int answer = 0, cnt = 0;
		
		for(int i = 0; i < n; i++){
			if(arr[i] == 1){
				cnt++;
				answer += cnt;
			} else {
				cnt=0;
			}
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(n, arr));
	}
}