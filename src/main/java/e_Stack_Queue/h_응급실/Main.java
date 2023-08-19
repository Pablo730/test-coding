package e_Stack_Queue.h_응급실;

import java.util.*;
import java.io.*;

class Main {
	class Person{
		int id;
		int priority;
		public Person(int id, int priority){
			this.id=id;
			this.priority=priority;
		}
	}
	// Todo
	
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		Queue<Person> queue = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			queue.offer(new Person(i, arr[i]));
		}
		while(!queue.isEmpty()) {
			Person tmp = queue.poll();
			for(Person x : queue){
				if(x.priority > tmp.priority){
					queue.offer(tmp);
					tmp = null;
					break;
				}
			}
			if(tmp != null){
				answer++;
				if(tmp.id == m) {
					return answer;
				}
			}
		}
		return answer;
	}
	
	public int solutionP(int n, int m, int[] arr) {
		int answer = 0;
		
		Queue<Person> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(arr[i]);
			queue.offer(new Person(i, arr[i]));
		}
		Collections.sort(list, Collections.reverseOrder());
		
		int index = 0;
		while (!queue.isEmpty()) {
			Person person = queue.poll();
			if (person.priority == list.get(index)) {
				answer++;
				index++;
				if (person.id == m) {
					return answer;
				}
			} else {
				queue.offer(person);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.println(T.solution(n, m, arr));
	}
}