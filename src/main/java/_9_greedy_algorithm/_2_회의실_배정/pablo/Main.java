package _9_greedy_algorithm._2_회의실_배정.pablo;

import java.util.*;

public class Main {
	static class Meeting implements Comparable<Meeting> {
		int startTime;
		int endTime;
		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		@Override
		public int compareTo(Meeting meeting) {
			if (this.endTime == meeting.endTime) {
				return this.startTime - meeting.startTime;
			}
			return this.endTime - meeting.endTime;
		}
	}
	static int solution(int[][] arr) {
		
		List<Meeting> meetings = new ArrayList<>();
		
		for(int[] a: arr) {
			meetings.add(new Meeting(a[0], a[1]));
		}
		
		Collections.sort(meetings);
		
		int answer = 1;
		int maxEnd = meetings.get(0).endTime;
		for (int i = 1; i < arr.length; i++) {
			if (maxEnd <= meetings.get(i).startTime) {
				answer++;
				maxEnd = meetings.get(i).endTime;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		System.out.println(solution(arr));
	}
}