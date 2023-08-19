package i_Greedy_Algorithm.a_씨름_선수.pablo;
import java.util.Scanner;

public class Main {
	static int solution(int[][] arr) {
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean check = true;
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					continue;
				}
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					check = false;
					break;
				}
			}
			if (check) {
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int[][] arr = new int [N][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		System.out.println(solution(arr));
		return ;
	}
}
