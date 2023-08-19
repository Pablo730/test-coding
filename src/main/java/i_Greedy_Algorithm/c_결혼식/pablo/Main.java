package i_Greedy_Algorithm.c_결혼식.pablo;
import java.util.*;

public class Main {
	static class Time implements Comparable<Time> {
		int time;
		int startOrEnd;
		
		public Time(int time, int startOrEnd){
			this.time = time;
			this.startOrEnd = startOrEnd;
		}
		
		@Override
		public int compareTo(Time time) {
			if (this.time == time.time) {
				return this.startOrEnd - time.startOrEnd;
			}
			return this.time - time.time;
		}
	}
	static int solution (int[][] arr){
		List<Time> times = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			times.add(new Time(arr[i][0], 1));
			times.add(new Time(arr[i][1], 0));
		}
		Collections.sort(times);
		
		int answer = 0;
		int cnt = 0;
		for(Time time: times) {
			if (time.startOrEnd == 0) {
				cnt--;
			} else if (time.startOrEnd == 1) {
				cnt++;
			}
			answer = Math.max(answer, cnt);
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
