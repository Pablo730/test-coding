package _2_array._1_큰_수_출력하기;

import java.util.*;
class Main {
	
	// Todo int 배열 arr안에 [왼쪽부터 바로 앞의 숫자보다 큰 수]들을 구한다
	// Todo 배열 arr안에 맨 앞(왼쪽) 숫자는 무조건 출력한다
	
	public List<Integer> solution(int n, int[] arr){
		List<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);
		
		for(int i = 1; i < n; i++){
			if(arr[i] > arr[i - 1]) {
				answer.add(arr[i]);
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
		for(int x : T.solution(n, arr)){
			System.out.print(x+" ");
		}
	}
}


