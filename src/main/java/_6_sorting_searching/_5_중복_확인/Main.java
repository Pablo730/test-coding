package _6_sorting_searching._5_중복_확인;
import java.util.*;
class Main {
	
	// Todo 정렬로 확인하는 방법도 좋네
	
	public String solution(int n, int[] arr){
		String answer = "U";
		Arrays.sort(arr);
		for(int i = 0; i < n - 1; i++){
			if(arr[i] == arr[i + 1]){
				answer = "D";
				break;
			}
		}
		return answer;
	}
	
	public char solutionP(int n, int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (set.contains(arr[i])) {
				return 'D';
			}
			set.add(arr[i]);
		}
		return 'U';
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		System.out.println(T.solution(n, arr));
	}
}