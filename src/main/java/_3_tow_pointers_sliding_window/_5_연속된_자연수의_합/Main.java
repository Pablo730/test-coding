package _3_tow_pointers_sliding_window._5_연속된_자연수의_합;

class Main {
	
	// Todo 연속 된 자연수의 합이 n과 같은 총 경우의 수
	
	public int solution2(int n) {
		int answer = 0;
		if (n % 2 == 1) {
			answer++;
		}
		for (int i = 1; i < n / 2; i++) {
			int sum = i;
			for (int j = i+1; j < n / 2; j++) {
				sum += j;
				if (sum == n) {
					answer++;
				} else if (sum > n) {
					break;
				}
			}
		}
		return answer;
	}
	
	public int solution(int n){
		int answer=0, sum=0;
		int m=n/2+1;
		int[] arr=new int[m];
		for(int i=0; i<m; i++) arr[i]=i+1;
		int lt=0;
		for(int rt=0; rt<m; rt++){
			sum+=arr[rt];
			if(sum==n) answer++;
			while(sum>=n){
				sum-=arr[lt++];
				if(sum==n) answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args){
//		Main T = new Main();
//		Scanner kb = new Scanner(System.in);
//		int n=kb.nextInt();
//		System.out.print(T.solution(n));
		
		int n = 14;
		String answer = "";
		String nBinary = Integer.toBinaryString(n);
		System.out.println(nBinary);
		if (nBinary.contains("0")) {
			System.out.println(nBinary.indexOf("0"));
			System.out.println(nBinary.lastIndexOf("1"));
			
			
		
		} else {
			answer = "10" + nBinary.substring(0, nBinary.length() - 1);
		}
//		System.out.print(Integer.parseInt(answer, 2));
	}
}