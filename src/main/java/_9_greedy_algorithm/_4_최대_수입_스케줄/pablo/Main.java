package _9_greedy_algorithm._4_최대_수입_스케줄.pablo;

import java.util.*;

public class Main {
	static class Schedule implements Comparable<Schedule> {
		int money;
		int day;
		
		public Schedule(int money, int day){
			this.money = money;
			this.day = day;
		}
		
		@Override
		public int compareTo(Schedule schedule) {
			return schedule.day - this.day;
		}
	}
	static int solution (int[][] arr){
		List<Schedule> schedules = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			schedules.add(new Schedule(arr[i][0], arr[i][1]));
		}
		Collections.sort(schedules);
		int maxDay = schedules.get(0).day;
		int answer = 0;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		int j = 0;
		for (int i = maxDay; i > 0; i--) {
			while (j < arr.length) {
				if(schedules.get(j).day < i) {
					break;
				}
				priorityQueue.offer(schedules.get(j).money);
				j++;
			}
			if (!priorityQueue.isEmpty()) {
				answer += priorityQueue.poll();
			}
		}
		
		return answer;
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		System.out.println(solution(arr));
	}
}

