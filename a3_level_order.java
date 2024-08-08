
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class a3_level_order {
	public class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}

		public Node() {
		}
	}

	Scanner sc = new Scanner(System.in);
	private Node root;

	public a3_level_order() {
		// TODO Auto-generated constructor stub
		this.root = Create_Tree(null);
	}

	private Node Create_Tree(Node parent) {
		// TODO Auto-generated method stub
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
		while (qq.isEmpty() == false) {
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
		Queue<Node> helper = new LinkedList<>();
		qq.add(this.root);
		while (qq.isEmpty() == false) {
			Node rv = qq.remove();
			System.out.print(rv.data + " ");
			if (rv.left != null) {
				helper.add(rv.left);
			}
			if (rv.right != null) {
				helper.add(rv.right);

			}

			if (qq.isEmpty()) {
				qq = helper;
				helper = new LinkedList<>();
				System.out.println();
			}

		}

	}

	public static void main(String[] args) {
		a3_level_order lo = new a3_level_order();
		lo.levelorder_Linewise();
	}
// 10 true 20 true 30 false true 50 false false true 60 false false true 70 true 90 false false true 110 false false	
}