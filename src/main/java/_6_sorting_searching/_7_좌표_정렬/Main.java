package _6_sorting_searching._7_좌표_정렬;
import java.util.*;

class Main {
	
	// Todo
	static class Point implements Comparable<Point>{
		public int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o){
			// Todo 오름 차순일 경우 앞쪽에 this
			if(this.x == o.x) {
				return this.y - o.y;
			}
			else {
				return this.x - o.x;
			}
		}
	}
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Point> arr = new ArrayList<>();
		for(int i = 0; i < n; i++){
			int x = kb.nextInt();
			int y = kb.nextInt();
			arr.add(new Point(x, y));
		}
		Collections.sort(arr);
		for(Point o : arr) System.out.println(o.x + " " + o.y);
	}
}

