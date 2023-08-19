package e_Stack_Queue.f_공주_구하기;

import java.util.*;
class Main {
	
	// Todo 큐를 활용할 생각부터 해보자!!!!
	
	public int solution(int n, int k){
		int answer = 0;
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		while(!queue.isEmpty()) {
			for(int i = 1; i < k; i++) {
				queue.offer(queue.poll());
			}
			queue.poll();
			if(queue.size() == 1) {
				answer = queue.poll();
			}
		}
		return answer;
	}
	
	public int solutionP(int n, int k){
		int answer = 0;
		int[] ns = new int[n];
		for (int i = 0; i < n; i++) {
			ns[i] = i + 1;
		}
		int cnt = 0;
		int curr = 0;
		int onlyOne = n;
		while (onlyOne != 1) {
			if (ns[curr] != 0) {
				cnt++;
				if (cnt == k) {
					onlyOne--;
					ns[curr] = 0;
					cnt = 0;
				}
			}
			curr++;
			if (curr == n) {
				curr = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			if (ns[i] != 0){
				answer = ns[i];
				break;
			}
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int k=kb.nextInt();
		System.out.println(T.solutionP(n, k));
	}
}
