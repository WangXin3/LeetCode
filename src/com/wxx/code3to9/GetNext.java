package com.wxx.code3to9;

import com.wxx.utils.TreeNode;

/**
 * @author 她爱微笑
 * @date 2019/10/24
 * 二叉树d的下一个结点
 */
public class GetNext {

	/**
	 * 给定一个节点
	 * 返回中序遍历的下一个节点
	 *
	 * 1. 该节点有右子树 下一个节点就是右子树的最左节点
	 * 2. 该节点是父节点的左子节点，下一个节点就是父节点
	 * 3. 该节点没有右子树，并且是父节点的右子节点，则去判断父节点是否是是不是上级节点的左子节点，
	 * 		如果是则返回上级节点，如果不是，继续往上层找， 知道上层为null ，说明该节点没有下一个节点
	 * @param node
	 * @return
	 */
	public static TreeNode<Integer> getNextNode(TreeNode node) {
		// 1. 如果一个节点的右子树不为空，则该节点的下一个节点为右子树的最左节点
		if (node.right != null) {
			TreeNode treeNode = node.right;
			while (treeNode.left != null) {
				treeNode = node.left;
			}
			return treeNode;
		} else {
			// 如果右子树为空， 则判断该节点是不是父节点的子节点 ，如果是则返回父节点
			// 如果不是继续往上找， 直到找到该节点是父节点的左子节点 则返回父节点
			while (node.parent != null) {
				TreeNode parent = node.parent;
				if (parent.left == node) {
					return parent;
				}

				node = node.parent;
			}
		}

		return null;
	}


	public static void main(String[] args) {
//		中序遍历 = [9, 3, 15, 20, 7]

		TreeNode<Integer> root = new TreeNode<>(3);
		root.left = new TreeNode<>(9);
		root.left.parent = root;
		root.right = new TreeNode<>(20);
		root.right.parent = root;
		root.right.left = new TreeNode<>(15);
		root.right.left.parent = root.right;
		root.right.right = new TreeNode<>(7);
		root.right.right.parent = root.right;

		TreeNode<Integer> nextNode = getNextNode(root.right.right);
		if (nextNode == null) {
			System.out.println("该节点没有下一个节点");
			return;
		}
		System.out.println("nextNode = " + nextNode.val);

	}
}
