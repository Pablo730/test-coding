package b_Array.f_뒤집은_소수;

import java.util.*;
class Main {
	
	// Todo 배열 arr의 각 자연수를 거꾸로 뒤집고 뒤집은 수가 소수이면 리턴해라
	// Todo ex) {32, 55, 62, 20, 250, 370, 200, 30, 100} -> {23, 2, 73, 2, 3}
	public boolean isPrime(int num){
		// Todo 1이면 당연히 소수 아니고
		if(num == 1) {
			return false;
		}
		
		// Todo 2부터 num / 2 까지 나눠을 때 나머지가 0인 케이스 하나라도 존재하면 소수가 아니고
		for(int i = 2; i < num / 2; i++){
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public List<Integer> solution(int n, int[] arr){
		List<Integer> answer = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
			int temp = arr[i];
			int res = 0;
			
			while(temp > 0){
				// Todo 끝에서 한 자리 숫자 씩 거꾸로
				int t = temp % 10;
				res = res * 10 + t;
				temp = temp / 10;
			}
			
			// Todo StringBuilder.reverse() 이용하기
			int res2 = Integer.parseInt(new StringBuilder(String.valueOf(arr[i])).reverse().toString());
			if(isPrime(res2)) {
				answer.add(res);
			}
			
			if(isPrime(res)) {
				answer.add(res);
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