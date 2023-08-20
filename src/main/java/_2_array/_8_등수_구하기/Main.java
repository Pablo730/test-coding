package _2_array._8_등수_구하기;

import java.util.*;
class Main {
	
	// Todo 배열 arr안에 학생별 점수가 입력되어있다
	// Todo 학생별로 등수가 어떻게 되는지 리턴해라
	
	public int[] solution(int n, int[] arr){
		int[] answer = new int[n];
		
		for(int i = 0; i < n; i++){
			int cnt = 1;
			// Todo arr[i] 보다 높은 점수가 몇개있는지 체크한다
			for(int j = 0; j < arr.length; j++){
				if(arr[j] > arr[i]) {
					cnt++;
				}
			}
			answer[i]=cnt;
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
		for(int x :T.solution(n, arr)) System.out.print(x+" ");
	}
}
