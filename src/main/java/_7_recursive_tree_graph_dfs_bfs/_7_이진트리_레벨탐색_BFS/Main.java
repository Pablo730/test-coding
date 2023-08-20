package _7_recursive_tree_graph_dfs_bfs._7_이진트리_레벨탐색_BFS;

import java.util.*;

public class Main{
	
	// Todo Breadth-First Search 넓이 우선 탐색!
	// Todo 같은 레벨끼리 조회하는 것!
	// Todo 최단거리 문제!!
	
	Node root;
	public void BFS(Node root){
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			
			System.out.print(L + " : ");
			
			for(int i = 0; i < len; i++){
				Node cur = Q.poll();
				
				System.out.print(cur.data + " ");
				
				if(cur.left != null) {
					Q.offer(cur.left);
				}
				if(cur.right != null) {
					Q.offer(cur.right);
				}
			}
			
			L++;
			
			System.out.println();
		}
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
		Main tree=new Main();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.left=new Node(6);
		tree.root.right.right=new Node(7);
		tree.BFS(tree.root);
	}
}