package _programmers.불량_사용자;

import java.util.*;

class Solution {
	public int solution(String[] user_id, String[] banned_id) {
		int answer = 1;
		
		Queue<String> queue = new LinkedList<>();
		
		for (String banId: banned_id) {
			int banLength = banId.length();
			for (String user: user_id) {
				if (banLength != user.length()) {
					continue;
				}
				char[] benChars = banId.toCharArray();
				char[] userChars = user.toCharArray();
				boolean transCheck = true;
				for (int i = 0; i < banLength; i++) {
					if (benChars[i] == '*') {
						continue;
					}
					if (benChars[i] != userChars[i]) {
						transCheck = false;
						break;
					}
				}
				if (transCheck) {
				
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banId = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(solution.solution(userId, banId));
	}
}