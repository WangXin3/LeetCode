package com.wxx.utils;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Xinxin.Wang
 * @since 2021/7/21 9:38
 */
public class Util {

    private Util() {
    }

    /**
     * 生成链表
     * @param nums /
     * @return /
     */
    public static ListNode<Integer> createList(int[] nums) {
        ListNode<Integer> root = new ListNode<>(-1);
        ListNode<Integer> temp = root;

        for (int num : nums) {
            temp.next = new ListNode<>(num);
            temp = temp.next;
        }
        return root.next;
    }

    /**
     * 生成二叉树
     * @param nums /
     * @return /
     */
    public static TreeNode<Integer> createTree(int[] nums) {

        TreeNode<Integer> root = new TreeNode<>(nums[0]);//树的root节点
        Queue<TreeNode<Integer>> queue = new LinkedBlockingQueue<>(); //广度优先的辅助队列
        queue.add(root);
        int index = 1;//数组的索引下标
        while (!queue.isEmpty()) {
            TreeNode<Integer> cur = queue.poll();
            if (index < nums.length) {//如果下标越界就跳出while循环
                cur.left = new TreeNode<>(nums[index]);
                cur.right = new TreeNode<>(nums[index]);
                index++;
                queue.add(cur.left);
                queue.add(cur.right);
            } else {
                break;
            }
        }
        return root;
    }
}
