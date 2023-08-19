package j_Dynamic_programming.c_가장_높은_탑_쌓기.pablo;
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
	
	static int dfs(int index, int currWeight, int size, List<Brick> bricks, int sum) {
		if (index == size - 1) {
			return sum;
		}
		
		int max = 0;
		for (int i = index + 1; i < size; i++) {
			if (currWeight > bricks.get(i).weight) {
				max = Math.max(max, dfs(i, bricks.get(i).weight, size,  bricks, sum + bricks.get(i).height));
			} else if (i == size - 1 && currWeight < bricks.get(i).weight) {
				max = Math.max(max, dfs(i, bricks.get(i).weight, size,  bricks, sum));
			}
		}
		return max;
	}
	
	static int solution(int[][] arr) {
		List<Brick> bricks = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			bricks.add(new Brick(arr[i][0], arr[i][1], arr[i][2]));
		}
		Collections.sort(bricks);
		
		return dfs(-1, 100000, arr.length, bricks, 0);
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