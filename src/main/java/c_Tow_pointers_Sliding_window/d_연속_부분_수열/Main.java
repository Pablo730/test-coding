package c_Tow_pointers_Sliding_window.d_연속_부분_수열;
import java.util.*;
class Main {
	
	// Todo 배열에서 연속해서 값을 더했을 때 특정 값 m이 되는 총 경우의 수를 구해라
	
	public int solution(int n, int m, int[] arr){
		int answer=0, sum=0, lt=0;
		for(int rt=0; rt<n; rt++){
			sum+=arr[rt];
			if(sum==m) answer++;
			while(sum>=m){
				sum-=arr[lt++];
				if(sum==m) answer++;
			}
		}
		return answer;
	}
	
	public int solution2(int n, int m, int[] arr) {
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum == m) {
					answer++;
				} else if (sum > m) {
					break;
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
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(n, m, arr));
	}
}