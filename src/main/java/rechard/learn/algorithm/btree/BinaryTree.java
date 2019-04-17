package rechard.learn.algorithm.btree;


public class BinaryTree {
		private BinaryTree left = null;
		private BinaryTree right = null;
		private int value;
		public BinaryTree(int value){
			this.value=value;
		}
		public BinaryTree getLeft() {
			return left;
		}
		public void setLeft(BinaryTree left) {
			this.left = left;
		}
		public BinaryTree getRight() {
			return right;
		}
		public void setRight(BinaryTree right) {
			this.right = right;
		}
		public int getValue() {
			return value;
		}
}
