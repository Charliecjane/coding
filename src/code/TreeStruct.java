/**
 * 树形结构-刷题
 */
public class TreeStruct {
    class Tree {
        TreeNode treeNode;
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * 1.获取树的最大深度
     */
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    /**
     * 8.是否是子树
     */
    public boolean subTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null) {
            return false;
        }
        return subTree2(tree1, tree2) || subTree2(tree1.left, tree2) || subTree2(tree1.right, tree2);
    }

    public boolean subTree2(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        // 子树需要到叶子节点
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.value != tree2.value) {
            return false;
        }
        return subTree2(tree1.left, tree2.left) && subTree2(tree1.right, tree2.right);
    }



}