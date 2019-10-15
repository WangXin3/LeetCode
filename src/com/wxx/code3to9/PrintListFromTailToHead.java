package com.wxx.code3to9;

import com.wxx.utils.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 她爱微笑
 * @date 2019/10/14
 * 从尾到头打印链表
 */
public class PrintListFromTailToHead {

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<>(1);
		head.next = new ListNode<>(2);
		head.next.next = new ListNode<>(3);
		head.next.next.next = new ListNode<>(4);
		System.out.println("head = " + head);
//		printReversinglyRecursively(head);
//		printListFromTailToHeadByStack(head);
		ArrayList<Integer> integers = printListFromTailToHead2(head);
		for (Integer integer : integers) {
			System.out.println(integer);
		}

	}

	/**
	 * 递归版
	 * @param node
	 */
	public static void printReversinglyRecursively(ListNode<Integer> node) {
		if (node == null) {
			return;
		} else {
			printReversinglyRecursively(node.next);
			System.out.println(node.val);
		}
	}

	/**
	 * 使用栈
	 * 栈具有先进后出的热点
	 * @param node
	 */
	public static void printListFromTailToHeadByStack(ListNode<Integer> node) {
		Stack<Integer> stack = new Stack();

		while (node != null) {
			stack.add(node.val);
			node = node.next;
		}

		ArrayList<Integer> array = new ArrayList<>();
		while (!stack.isEmpty()) {
			array.add(stack.pop());
		}

		for (Integer i : array) {
			System.out.println(i);
		}
	}

	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		// 头插法构建逆序链表
		ListNode<Integer> prev = null;
		ListNode curr = listNode;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}

		// 构建 ArrayList
		ArrayList<Integer> ret = new ArrayList<>();
		while (prev != null) {
			ret.add(prev.val);
			prev = prev.next;
		}
		return ret;
	}

}
