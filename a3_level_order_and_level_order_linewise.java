import java.util.*;
public class a3_level_order_and_level_order_linewise {
	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	Scanner sc = new Scanner(System.in);
	private Node root;
	public a3_level_order_and_level_order_linewise() {
		this.root = Create_Tree(null);
	}

	private Node Create_Tree(Node parent) {
		int item = sc.nextInt();
		Node nn = new Node(item);
		boolean hlc = sc.nextBoolean();
		if (hlc == true) {
			nn.left = Create_Tree(nn);
		}
		boolean hrc = sc.nextBoolean();

		if (hrc == true) {
			nn.right = Create_Tree(nn);
		}
		return nn;

	}

	public void levelorder() {
		Queue<Node> qq = new LinkedList<>();
		qq.add(this.root);
		while (!qq.isEmpty()) {
			Node rv = qq.remove();
			System.out.print(rv.data + " ");
			if (rv.left != null) {
				qq.add(rv.left);
			}
			if (rv.right != null) {
				qq.add(rv.right);

			}

		}
		System.out.println();

	}

	public void levelorder_Linewise() {
		Queue<Node> qq = new LinkedList<>();
		qq.add(this.root);
		
		while (!qq.isEmpty()) {
			int size = qq.size(); // Get the number of nodes at the current level
			
			// Process all nodes at the current level
			for (int i = 0; i < size; i++) {
				Node rv = qq.remove();
				System.out.print(rv.data + " ");
				
				// Add the left child if it exists
				if (rv.left != null) {
					qq.add(rv.left);
				}
				
				// Add the right child if it exists
				if (rv.right != null) {
					qq.add(rv.right);
				}
			}
			
			// Print a new line after each level
			System.out.println();
		}
	}

	public static void main(String[] args) {
		a3_level_order_and_level_order_linewise lo = new a3_level_order_and_level_order_linewise();
		lo.levelorder_Linewise();
	}
	// 10 true 20 true 30 false true 50 false false true 60 false false true 70 true 90 false false true 110 false false	
}