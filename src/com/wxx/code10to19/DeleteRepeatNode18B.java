package com.wxx.code10to19;

import com.wxx.utils.ListNode;

/**
 * @author 她爱微笑
 * @date 2020/2/16
 * 删除链表中重复的节点
 */
public class DeleteRepeatNode18B {
	/*
	 * 1个排序好的链表，需要删除重复的节点
	 * 如 1 - 2 - 3 - 3 - 4 - 4 - 5
	 * 删除完为1 - 2 - 5
	 */

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next.next = new ListNode(6);

		ListNode resultNode = deleteNode(node);
		System.out.println("resultNode = " + resultNode.toString());
	}

	/**
	 * 删除重复的节点
	 * 这个递归方法的子作用：传入一个节点，判断当前节点是否和下一个节点的值一样，
	 * 一样则：将当前节点的下下个节点覆盖到下个节点
	 * 不一样则：调用递归方法，传入下一个节点
	 * 直到当前节点的下一个节点为空
	 * @param pHead 链表的头节点
	 * @return
	 */
	public static ListNode deleteNode(ListNode pHead) {

		// 如果节点是null 或者该链表只有一个节点，则返回该节点
		if (pHead == null || pHead.next == null) {
			return pHead;
		}

		// 取出当前节点的下一个节点
		ListNode next = pHead.next;
		// 如果当前节点的值和下一个节点的值一样
		if (pHead.val == next.val) {
			// 进行while循环，如果下一个节点不为空且当前节点的值等于下一个节点的值
			while (next != null && pHead.val == next.val) {
				// 把下下个节点赋值给下个节点
				next = next.next;
				// 然后将下个节点传入递归
				return deleteNode(next);
			}
		} else {
			// 如果值不一样，则继续递归下一个节点
			pHead.next = deleteNode(pHead.next);
			return pHead;
		}

		return null;
	}
}
