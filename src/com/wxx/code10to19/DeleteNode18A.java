package com.wxx.code10to19;

import com.wxx.util.ListNode;

/**
 * @author 她爱微笑
 * @date 2020/2/16
 * O(1)时间内删除链表节点
 */
public class DeleteNode18A {
	/*
	 * 共三种情况：
	 * 	1. 需要删除的节点不是尾节点，将该节点的下一个节点复制覆盖当前节点，
	 * 	并将该节点的下一个指向指到当前节点的下下个节点，并删除下一个节点
	 * 	2. 需要删除的节点是尾节点，则需要通过头节点，遍历，找到尾节点的前一个节点，将节点的下一个节点指向置为null
	 * 	3. 如果只有一个节点，需要删除的就是这个节点，也是头节点，判断头节点是否等于需要删除的节点，等于，则将该节点置为null
	 */

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		ListNode node1 = deleteNode(node, node.next.next);
		System.out.println("node1 = " + node1.toString());
	}

	/**
	 * @param head       该链表头节点
	 * @param toBeDelete 需要删除的节点
	 */
	public static ListNode deleteNode(ListNode head, ListNode toBeDelete) {
		// 入参校验
		if (head == null || toBeDelete == null) {
			return null;
		}

		// 如果需要删除的节点不是尾节点
		if (toBeDelete.next != null) {
			ListNode next = toBeDelete.next;
			toBeDelete.val = next.val;
			toBeDelete.next = next.next;
		} else {
			// 两种情况
			if (head == toBeDelete) {
				// 1. 只有一个节点，需要删除的节点等于头节点，则直接将该节点置为null
				head = null;
			} else {
				// 2. 需要删除的节点是尾节点
				// 当前节点
				ListNode current = head;
				// 当前节点的下一个是否 是需要删除的节点，如果是，不走循环，将当前节点的下一个指向置为null
				while (current.next != toBeDelete) {
					current = current.next;
				}
				current.next = null;
			}

		}
		return head;
	}
}
