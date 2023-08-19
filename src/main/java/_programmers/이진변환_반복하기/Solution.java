package _programmers.이진변환_반복하기;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
	public static int[] solution(String s) {
		int[] answer = new int[2];
		if (s == "1") {
			return answer;
		}
		
		int transCount = 0;
		int deleteCount = 0;
		while (!s.equals("1")) {
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '0'){
					deleteCount++;
				}
			}
			transCount++;
			s = s.replace("0", "");
			System.out.println(s);
			if (s.equals("1")) {
				answer[0] = transCount;
				answer[1] = deleteCount;
				return answer;
			}
			s = Integer.toBinaryString(s.length());
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
//		int[] a = solution("110010101001");
//		Map<Integer, Integer> map = new HashMap<>();
//		Object[] v = map.values().toArray();
//		Arrays.sort(v);
//		for (Object x: v) {
//			if ((int) x > 0) {
//
//			}
//		}
		List<String> l = new ArrayList<>();
		l.add("e");
		l.add("111");
		String[] l2 = (String[]) l.toArray();
		
		String b = "aaa bbb";
		System.out.println(b.substring(b.length() - 3));
//		Stack<Integer> stack = new Stack<>();
//		stack.clear();
//		System.out.println(a[0] +" "  + a[1]);
	}
}