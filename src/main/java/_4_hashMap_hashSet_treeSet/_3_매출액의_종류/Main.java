package _4_hashMap_hashSet_treeSet._3_매출액의_종류;

import java.util.*;
class Main {
	
	// Todo 맵을 잘 활용하자
	
	public int[] solutionPablo(int n, int k, int[] arr) {
		int[] answer = new int[n - k + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.merge(arr[i], 1, Integer::sum);
		}
		int cnt = 0;
		answer[cnt] = map.size();
		for (int i = k; i < n; i++) {
			int size = answer[cnt];
			cnt++;
			
			if (map.get(arr[i - k]) == 1) {
				map.remove(arr[i - k]);
				size--;
			} else {
				map.merge(arr[i - k], -1, Integer::sum);
			}
			
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
				size++;
			} else {
				map.merge(arr[i], 1, Integer::sum);
			}
			
			answer[cnt] = size;
		}
		return answer;
	}
	
	public List<Integer> solution(int n, int k, int[] arr){
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<k-1; i++){
			map.merge(arr[i], 1, Integer::sum);
		}
		
		int left=0;
		
		for(int right = k - 1; right < n; right++){
			map.merge(arr[right], 1, Integer::sum);
			
			answer.add(map.size());
			
			map.merge(arr[left], -1, Integer::sum);
			
			if(map.get(arr[left]) == 0) {
				map.remove(arr[left]);
			}
			left++;
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int k=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		for(int x : T.solution(n, k, arr)) System.out.print(x+" ");
	}
}