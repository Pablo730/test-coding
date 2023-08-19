package _programmers.est1;

import java.util.Arrays;

public class Solution {
	
	public static int solution (int[] A) {
		Arrays.sort(A);
		int maxInt = A[A.length - 1];
		int countDown = A[A.length - 1];
		
		for (int i = A.length - 1; i >= 0; i--) {
			if (countDown == 1 && A[i] != maxInt) {
				return A[i + 1];
			}
			if (A[i] == maxInt) {
				countDown--;
				continue;
			}
			maxInt = A[i];
			countDown = A[i];
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(Solution.solution(new int[]{1,2,3,3,3,2,5,5,5,5,4,4,2,8,13,4,4}));
	}
}
