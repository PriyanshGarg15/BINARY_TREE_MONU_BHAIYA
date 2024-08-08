
public class a2_BinaryTree_Client {
	public static void main(String[] args) {
		a1_implementation bt = new a1_implementation();
		bt.display();
		System.out.println(bt.find(70));
		System.out.println(bt.min());
		System.out.println(bt.CountNode());
		System.out.println(bt.ht());
		bt.PreOrder();
		bt.PostOrder();
		bt.InOrder();

	}
// 10 true 20 true 30 false true 50 false false true 60 false false true 70 true 90 false false true 110 false false
}