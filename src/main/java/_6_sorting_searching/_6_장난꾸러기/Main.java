package _6_sorting_searching._6_장난꾸러기;

import java.util.*;
class Main {
	
	// Todo 정렬만하면 쉽게 풀리는 문제도 있다!
	
	public List<Integer> solution(int n, int[] arr){
		List<Integer> answer = new ArrayList<>();
		int[] tmp = arr.clone();
		Arrays.sort(tmp);
		for(int i = 0; i < n; i++){
			if(arr[i] != tmp[i]) {
				answer.add(i+1);
			}
		}
		return answer;
	}
	
	public int[] solutionP(int n, int[] arr) {
		int[] answer = new int[2];
		for (int i = 0; i < n - 1; i++) { // 철수 찾자
			if (arr[i] > arr[i + 1]) {
				int index = i + 1;
				if (i != 0) {
					for (int j = i - 1; j > 0; j--) {
						if(arr[i] != arr[j]) {
							break;
						}
						index--;
					}
				}
				answer[0] = index;
				break;
			}
		}
		for (int i = n -1 ; i > 0; i--) { // 짝꿍 찾자
			if (arr[i] < arr[i - 1]) {
				answer[1] = i + 1;
				break;
			}
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		for(int x : T.solution(n, arr)) System.out.print(x+" ");
	}
}