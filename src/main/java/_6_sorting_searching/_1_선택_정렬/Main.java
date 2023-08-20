package _6_sorting_searching._1_선택_정렬;

import java.util.*;
class Main {
	
	// Todo [앞에서부터 인덱스 하나씩 선택]해서 정렬 해놓고 다음 인덱스 정렬
	// Todo O n * n 시간 복잡도, 버블 정렬보다 낫다
	
	public int[] solution(int n, int[] arr){
		for(int i = 0; i < n - 1; i++){
			int idx = i;
			for(int j = i + 1; j < n; j++){
				if(arr[j] < arr[idx]) {
					idx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}
	
	// Todo 그냥 오름차순 정렬
	public List<Integer> solutionP(int n, int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int a: arr) {
			list.add(a);
		}
		Collections.sort(list);
		return list;
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
