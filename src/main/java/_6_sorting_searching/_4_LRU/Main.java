package _6_sorting_searching._4_LRU;
import java.util.*;
class Main {
	
	// Todo 단순 배열로 문제 푸는 방법도 숙지할 것
	
	public int[] solution(int size, int n, int[] arr){
		int[] cache = new int[size];
		for(int x : arr){ // 모든 작업 확인
			int pos = -1;
			for(int i = 0; i < size; i++) { // 캐쉬 Hit 인지 확인
				if(x == cache[i]) { // 캐쉬 Hi 이면
					pos = i; // 확인 위치 세팅
				}
			}
			if(pos == -1){ // 캐시 Miss인 경우
				for(int i = size - 1; i >= 1; i--){
					cache[i] = cache[i-1];
				}
			} else{ // 캐시 Hit 인 경우
				for(int i = pos; i >= 1; i--){
					cache[i] = cache[i-1];
				}
			}
			cache[0] = x;
		}
		return cache;
	}
	
	public List<Integer> solutionP(int s, int n, int[] arr) {
		List<Integer> list = new LinkedList<>();
		list.add(arr[0]);
		for (int i = 1; i < n; i++) {
			if (list.contains(arr[i])) {
				int temp = list.get(0);
				if (temp != arr[i]) {
					list.remove(list.indexOf(arr[i]));
					list.add(0, arr[i]);
				}
			} else {
				if (list.size() < s) {
					list.add(0, arr[i]);
				} else {
					list.remove(s - 1);
					list.add(0, arr[i]);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int s=kb.nextInt();
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		for(int x : T.solutionP(s, n, arr)) System.out.print(x+" ");
	}
}