package com.wxx.code3to9;

import com.wxx.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 遍历二叉树
 * 前序遍历  根节点 -> 左节点 -> 右节点
 * 中序遍历	左节点 -> 根节点 -> 右节点
 * 后序遍历	左节点 -> 右节点 -> 根节点
 * 层次遍历	只需按层次遍历即可
 * @author 她爱微笑
 * @date 2019/10/15
 */
public class TraversalOfBinaryTree {

	/**
	 * 前序遍历 递归版
	 * @param node
	 * @return
	 */
	public static List<Integer> preorderRecursively(TreeNode node) {
		List<Integer> list = new ArrayList<>();

		if (node == null) {
			return list;
		}

		list.add(node.val);
		list.addAll(preorderRecursively(node.left));
		list.addAll(preorderRecursively(node.right));

		return list;
	}

	/**
	 * 中序遍历 递归版
	 * @param node
	 * @return
	 */
	public static List<Integer> inorderRecursively(TreeNode node) {
		List<Integer> list = new ArrayList<>();

		if (node == null) {
			return list;
		}

		list.addAll(inorderRecursively(node.left));
		list.add(node.val);
		list.addAll(inorderRecursively(node.right));

		return list;
	}

	/**
	 * 后序遍历 递归版
	 * @param node
	 * @return
	 */
	public static List<Integer> postorderRecursively(TreeNode node) {
		List<Integer> list = new ArrayList<>();

		if (node == null) {
			return list;
		}

		list.addAll(postorderRecursively(node.left));
		list.addAll(postorderRecursively(node.right));
		list.add(node.val);

		return list;
	}

	/**
	 * 前序遍历 非递归
	 * @param node
	 * @return
	 */
	public static List<Integer> preorderIteratively(TreeNode node) {
		// stack栈顶元素永远为cur的父节点
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = node;
		List<Integer> list = new LinkedList<>();

		if (node == null) {
			return list;
		}

		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				list.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop().right;
			}
		}

		return list;
	}

	/**
	 * 中序遍历 非递归
	 * @param node
	 * @return
	 */
	public static List<Integer> inorderIteratively(TreeNode node) {
		// 栈顶元素是cur的父节点
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = node;

		List<Integer> list = new ArrayList<>();

		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				list.add(stack.peek().val);
				cur = stack.pop().right;
			}
		}

		return list;
	}

	/**
	 * 后续遍历 非递归
	 * @param node
	 * @return
	 */
	public static List<Integer> postorderIteratively(TreeNode node) {

		// stack栈顶元素永远为cur的父节点
		// prevVisted用于区分是从左子树还是右子树返回的
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = node;
		TreeNode prevVisted = null;

		List<Integer> list = new ArrayList<>();


		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {

				cur = stack.peek().right;
				if(cur != null && cur != prevVisted) {
					stack.push(cur);
					cur = cur.left;
				} else {
					prevVisted = stack.pop();
					list.add(prevVisted.val);
					cur = null;
				}

			}
		}

		return list;
	}

	public static void main(String[] args) {
		/**
		 * 					 3
		 * 				   /  \
		 * 				  9	  20
		 * 				  	 /  \
		 * 				  	15   7
		 */

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		// 前序遍历 递归版
		List<Integer> list = preorderRecursively(root);
		System.out.println("前序遍历 = " + list.toString());

		// 中序遍历 递归版
		List<Integer> list1 = inorderRecursively(root);
		System.out.println("中序遍历 = " + list1.toString());

		// 后序遍历 递归版
		List<Integer> list2 = postorderRecursively(root);
		System.out.println("后序遍历 = " + list2.toString());

		// 前序遍历非递归
		List<Integer> list3 = preorderIteratively(root);
		System.out.println("前序非递归 = " + list3.toString());

		// 中序遍历非递归
		List<Integer> list4 = inorderIteratively(root);
		System.out.println("中序非递归 = " + list4);

		// 后序遍历非递归
		List<Integer> list5 = postorderIteratively(root);
		System.out.println("后序非递归 = " + list5);

	}
}
