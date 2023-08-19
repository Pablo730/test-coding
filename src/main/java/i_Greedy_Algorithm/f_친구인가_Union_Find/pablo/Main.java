package i_Greedy_Algorithm.f_친구인가_Union_Find.pablo;
import java.util.*;

public class Main {
	static String solution(int N, int[][] arr, int[] check) {
		Map<Integer, Set<Integer>> setMap = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			setMap.put(i, new HashSet<>());
		}
		for (int i = 0; i < arr.length; i++) {
			setMap.get(arr[i][0]).add(arr[i][1]);
			setMap.get(arr[i][1]).add(arr[i][0]);
		}
		int fr = check[0];
		int find = check[1];
		Set<Integer> set = setMap.get(fr);
		
		while (!set.isEmpty()) {
			if (set.contains(find)) {
				return "YES";
			}
			Set<Integer> newSet = new HashSet<>();
			for (int f: set) {
				newSet.addAll(setMap.get(f));
			}
			set = newSet;
		}
		
		return "NO";
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] arr = new int[M][2];
		for (int i = 0; i < M; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		int[] check = new int[2];
		check[0] = in.nextInt();
		check[1] = in.nextInt();
		System.out.println(solution(N, arr, check));
	}
}