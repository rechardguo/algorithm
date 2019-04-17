package rechard.learn.algorithm.btree;

public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                TreeNode treeNode = (TreeNode) o;

                if (val != treeNode.val) return false;
                if (!left.equals(treeNode.left)) return false;
                return right.equals(treeNode.right);
        }

        @Override
        public int hashCode() {
                int result = val;
                result = 31 * result + left.hashCode();
                result = 31 * result + right.hashCode();
                return result;
        }
}
