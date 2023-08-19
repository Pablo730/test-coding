package _programmers.여행경로;

import java.util.*;

class Solution {
	static class Visit {
		String history;
		Set<String> ticketIndexSet;
		public Visit(String history, Set<String> ticketIndexSet) {
			this.history = history;
			this.ticketIndexSet = ticketIndexSet;
		}
	}
	public String[] solution(String[][] tickets) {
		Map<String, List<String>> ticketMap = new HashMap<>();
		
		for (int i = 0; i < tickets.length; i++) {
			if (!ticketMap.containsKey(tickets[i][0])) {
				ticketMap.put(tickets[i][0], new ArrayList<>());
				ticketMap.get(tickets[i][0]).add(tickets[i][1] + " " + i);
				continue;
			}
			ticketMap.get(tickets[i][0]).add(tickets[i][1] + " " + i);
		}
		
		String first = "ICN";
		Queue<Visit> queue = new LinkedList<>();
		for (String next: ticketMap.get(first)) {
			String[] nextSplit = next.split(" ");
			Set<String> ticketIndexSet = new HashSet<>();
			ticketIndexSet.add(nextSplit[1]);
			queue.offer(new Visit(first + " " + nextSplit[0], ticketIndexSet));
		}
		
		int level = 1;
		
		List<String> histories = new ArrayList<>();
		while (!queue.isEmpty()) {
			int len = queue.size();
			
			for (int i = 0; i < len; i++) {
				Visit visit = queue.poll();
				String history = visit.history;
				Set<String> ticketIndexSet = visit.ticketIndexSet;
				if (level == tickets.length) {
					histories.add(history);
				}
				
				String before = history.substring(history.length() - 3);
				if (ticketMap.containsKey(before)) {
					for (String next: ticketMap.get(before)) {
						String[] nextSplit = next.split(" ");
						if (!ticketIndexSet.contains(nextSplit[1])) {
							Set<String> ticketIndexSet2 = new HashSet<>(ticketIndexSet);
							ticketIndexSet2.add(nextSplit[1]);
							queue.offer(new Visit(history + " " + nextSplit[0], ticketIndexSet2));
						}
					}
				}
			}
			
			level++;
		}
		String[] visitArray = histories.toArray(new String[0]);
		Arrays.sort(visitArray);
		
		return visitArray[0].split(" ");
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		int[] arr = {4,1,3,8,0};
		for (int a:arr) System.out.println(a);
//		for (String x: solution.solution(tickets)) System.out.println(x);
	}
}