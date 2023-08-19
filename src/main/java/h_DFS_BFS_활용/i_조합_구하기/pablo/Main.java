package h_DFS_BFS_활용.i_조합_구하기.pablo;

import java.util.*;
class Main{
	
	static void dfs(List<String> answer, int level, int L, int s, Set<Integer> set) {
		if (level == s) {
			String string = "";
			for (int a: set) {
				string += a + " ";
			}
			answer.add(string);
		}
		
//		dfs(answer, level + 1, L, s, )
	}
	
	static List<String> solution (int L, int s) {
		List<String> answer = new ArrayList<>();
		dfs(answer, 0, L, s, new HashSet<>());
		return answer;
	}
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int L = kb.nextInt();
		int s=kb.nextInt();
		List<String> strings = solution(L, s);
		for (String re: strings)
			System.out.println(re);
	}
}