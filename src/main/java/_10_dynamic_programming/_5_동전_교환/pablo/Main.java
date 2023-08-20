package _10_dynamic_programming._5_동전_교환.pablo;

import java.util.*;

public class Main {
	static int solution (int[] arr, int m) {
		Arrays.sort(arr);
		int answer = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] <= m) {
				queue.offer(arr[i]);
			}
		}
		answer++;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int money = queue.poll();
				if (m == money) {
					return answer;
				}
				for (int j = arr.length - 1; j >= 0; j--) {
					if (arr[j] <= m - money) {
						queue.offer(arr[j] + money);
					}
				}
			}
			answer++;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		int m = in.nextInt();
		System.out.println(solution(arr, m));
	}
}
