package _7_recursive_tree_graph_dfs_bfs._5_이진트리_순회_DFS;

public class Main{
	
	// Todo DFS => Depth First Search -> 깊이 우선 탐색
	// Todo 후위 순회는 병합정렬에 많이 쓰인다
	
	Node root;
	public void DFS(Node root){
		if(root == null)
			return;
		else{
			DFS(root.left);
			System.out.print(root.data + " ");
			DFS(root.rightt);
		}
	}
	
	static class Node{
		int data;
		Node left, rightt;
		public Node(int val) {
			data = val;
			left = rightt = null;
		}
	}
	
	
	
	public static void main(String args[]) {
		Main tree = new Main();
		tree.root=new Node(1);
		tree.root.left = new Node(2);
		tree.root.rightt = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.rightt = new Node(5);
		tree.root.rightt.left = new Node(6);
		tree.root.rightt.rightt = new Node(7);
		tree.DFS(tree.root);
	}
}
