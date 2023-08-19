package g_Recursive_Tree_Graph_DFS_BFS.i_말단노드까지_가장_짧은_경로_DFS;
import java.util.*;


public class Main{
	
	// Todo
	
	Node root;
	public int DFS (int L, Node root) {
		if(root.left == null && root.right == null) {
			return L;
		}  else {
			return Math.min(DFS(L + 1, root.left), DFS(L + 1, root.right));
		}
	}
	
	public int BFS (int i, Node root) {
		int answer = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int k = 0; k < len; k++) {
				Node node = queue.poll();
				if (node.left == null && node.right == null) {
					return answer;
				}
				queue.offer(node.left);
				queue.offer(node.right);
			}
			answer++;
		}
		return answer;
	}
	
	static class Node{
		int data;
		Node left, right;
		public Node(int val) {
			data = val;
			left = right = null;
		}
	}
	
	public static void main(String args[]) {
		Main tree = new Main();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println(tree.BFS(0, tree.root));
	}
}
