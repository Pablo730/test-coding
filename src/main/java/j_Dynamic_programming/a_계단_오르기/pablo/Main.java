package j_Dynamic_programming.a_계단_오르기.pablo;
import java.util.*;

public class Main {
	static int stair (int n, int[] stairs) {
		if (stairs[n] != 0) {
			return stairs[n];
		}
		if (n == 1 || n == 2) {
			return n;
		}
		return stairs[n] = stair(n - 2, stairs) + stair(n -1, stairs);
	}
	
	static int solution (int N) {
		int[] stairs = new int[N + 1];
		return stair(N, stairs);
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		System.out.println(solution(N));
		
//		List<Integer> list = new ArrayList<>(10);
//		System.out.println(list.size());
	}
}