package _5_stack_queue._3_크레인_인형뽑기_카카오;
import java.util.*;
class Main {
	
	// Todo 스택은 이럴 때 쓰는 것이다!
	public int solutionP(int[][] board, int[] moves) {
		int cnt = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			int col = moves[i] - 1;
			for (int row = 0; row < board.length; row++) {
				if (board[row][col] != 0) {
					if (!stack.isEmpty() && stack.peek() == board[row][col]) {
						stack.pop();
						cnt += 2;
					} else {
						stack.push(board[row][col]);
					}
					board[row][col] = 0;
					break;
				}
			}
		}
		return cnt;
	}
	
	public int solution(int[][] board, int[] moves){
		int answer=0;
		Stack<Integer> stack = new Stack<>();
		for(int pos : moves){
			for(int i=0; i<board.length; i++){
				if(board[i][pos-1]!=0){
					int tmp=board[i][pos-1];
					board[i][pos-1]=0;
					if(!stack.isEmpty() && tmp==stack.peek()){
						answer+=2;
						stack.pop();
					}
					else stack.push(tmp);
					break;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[][] board=new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				board[i][j]=kb.nextInt();
			}
		}
		int m=kb.nextInt();
		int[] moves=new int[m];
		for(int i=0; i<m; i++) moves[i]=kb.nextInt();
		System.out.println(T.solutionP(board, moves));
	}
}
