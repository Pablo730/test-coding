package _programmers.est2;

import java.util.*;

public class Solution {
	public static int solution(int[] A) {
		Map<Integer, List<Integer>> listMap = new HashMap<>();
		for (int j : A) {
			int a = j;
			int digitSum = 0;
			
			while (a > 0) {
				digitSum += (a % 10);
				a /= 10;
			}
			
			if (!listMap.containsKey(digitSum)) {
				listMap.put(digitSum, new ArrayList<>());
			}
			
			listMap.get(digitSum).add(j);
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int key: listMap.keySet()) {
			if (listMap.get(key).size() < 2) {
				continue;
			}
			listMap.get(key).sort(Collections.reverseOrder());
			max = Math.max(listMap.get(key).get(0) + listMap.get(key).get(1), max);
		}
		
		return max;
	}
	public static void main(String[] args) {
		System.out.println(Solution.solution(new int[]{42, 33, 60}));
	}
}
