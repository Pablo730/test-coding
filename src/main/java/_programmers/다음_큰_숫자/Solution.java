package _programmers.다음_큰_숫자;

class Solution {
	public static int solution(int n) {
		String nBinary = Integer.toBinaryString(n);
		char[] nBinaryChars = nBinary.toCharArray();
		int oneCount = 0;
		for (char x: nBinaryChars) {
			if (x == '1') {
				oneCount++;
			}
		}
		int next = n;
		int nextOneCount = 0;
		while (nextOneCount != oneCount) {
			next++;
			nextOneCount = 0;
			String nextBinary = Integer.toBinaryString(next);
			char[] nextBinaryChars = nextBinary.toCharArray();
			for (char x: nextBinaryChars) {
				if (x == '1') {
					nextOneCount++;
				}
			}
		}
		return next;
	}
	
	public static void main(String[] args) {
//		Integer.parseInt("3", 2);
//		System.out.println(solution(78));
		System.out.println(Integer.parseInt("5", 2));
	}
}
