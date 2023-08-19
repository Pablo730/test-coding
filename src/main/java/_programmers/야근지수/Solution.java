package _programmers.야근지수;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
	
	public long solution(int n, int[] works) {
		long answer = 0;
		Arrays.sort(works);
		
		int i = works.length - 1;
		boolean diffCheck = false;
		while (n > 0) {
			int diff = works[i] - works[i - 1];
			if (diff > 0) {
				diffCheck = true;
			}
			if (diff >= n) {
				works[i] -= n;
				break;
			}
			if (works[i] - diff >= 0) {
				works[i] -= diff;
				n -= diff;
			} else {
				works[i] = 0;
				n -= works[i];
			}
			if (works[i] >= Arrays.stream(works).max().getAsInt()) {
				works[i]--;
//				max--;
				n--;
				continue;
			}
			i--;
			
			if (i < 1) {
				Arrays.sort(works);
				i = works.length - 1;
				if (works[i] == 0) {
					return 0;
				}
				if (!diffCheck) {
					long all = works.length;
					if (n <= all) {
						for (int j = 0; j < n; j++) {
							answer += ((long)(works[i] - 1L) * (long)(works[i] - 1L));
						}
						for (int j = 0; j < all - n; j++) {
							answer += ((long)(works[i]) * (long)(works[i]));
						}
						return answer;
					}
					long size = n / all;
					if (size >= works[i]) {
						return 0;
					}
					for (int j = 0; j < (all - (n % all)); j++) {
						answer += ((long)(works[i] - size) * (long)(works[i] - size));
					}
					for (int j = 0; j < n % all; j++) {
						answer += answer += ((long)(works[i] - size - 1L) * (long)(works[i] - size - 1L));
					}
					return answer;
				}
				diffCheck = false;
			}
		}
		
		for (int work: works) {
			answer += ((long)work * (long)work);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] works = { 1, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6 };
		System.out.println(Arrays.stream(works).map(value -> value > 0 ? value : 2000000).min().getAsInt());
		
		Map<String, Integer> map = new HashMap<>();
		 List<Integer> list = map.values().stream().collect(Collectors.toList());
		 Object[] test = list.toArray();
		 int a = (int)test[0];
		 
//		System.out.println(solution.solution(8, works));
//		System.out.println(49999L * 49999L * 24L);
	}
}
// 15000000000
// 2114498118