package d_HashMap_HashSet_TreeSet.e_K번째_큰_수;

import java.util.*;
class Main {
	
	// Todo 정렬을 TreeSet으로 처리하는 방법을 기억하자
	
	public int solutionPablo(int[] arr, int n, int k){
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int l = j + 1; l < n; l++) {
					set.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		
		int size = set.size();
		if (size < k) {
			return -1;
		}
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		return list.get(k - 1);
	}
	
	public int solution(int[] arr, int n, int k){
		int answer=-1;
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				for(int l=j+1; l<n; l++){
					Tset.add(arr[i]+arr[j]+arr[l]);
				}
			}
		}
		int cnt=0;
		//Tset.remove(143);
		//System.out.println(Tset.size());
		//System.out.println("first : "+ Tset.first());
		//System.out.println("last : "+ Tset.last());
		
		for(int x : Tset){
			//System.out.println(x);
			cnt++;
			if(cnt==k) return x;
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
		System.out.println(T.solution(arr, n, k));
	}
}