package _10_dynamic_programming._3_가장_높은_탑_쌓기;

import java.util.*;

public class Main {
	static class Brick implements Comparable<Brick>{
		int area;
		int height;
		int weight;
		
		public Brick (int area, int height, int weight) {
			this.area = area;
			this.height = height;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Brick brick) {
			return brick.area - this.area;
		}
	}
	
	static int[] dy;
	static int solution(int[][] arr) {
		List<Brick> bricks = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			bricks.add(new Brick(arr[i][0], arr[i][1], arr[i][2]));
		}
		Collections.sort(bricks);
		dy = new int[arr.length];
		dy[0] = bricks.get(0).height;
		int answer = dy[0];
		System.out.println(dy[0] + "    " + bricks.get(0).area + "   " + bricks.get(0).height + "     " + bricks.get(0).weight);
		for (int i = 1; i < arr.length; i++) {
			dy[i] = bricks.get(i).height;
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if(bricks.get(i).weight < bricks.get(j).weight && dy[j] > max) {
					max = dy[j];
				}
			}
			dy[i] += max;
			System.out.println(dy[i] + "    " + bricks.get(i).area + "   " + bricks.get(i).height + "     " + bricks.get(i).weight);
			answer = Math.max(answer, dy[i]);
		}
		
		return answer;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][3];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
			arr[i][2] = in.nextInt();
		}
		System.out.println(solution(arr));
	}
}