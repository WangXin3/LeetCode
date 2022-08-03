package com.wxx.util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class U {
    /**
     * 字符串生成链表
     *
     * @param str /
     * @return /
     */
    public static ListNode createList(String str) {
        if (str == null) return null;
        // 去掉前后[ ]
        String substring = str.substring(1, str.length() - 1);
        if (substring.length() == 0) return null;
        // 用逗号分隔每个链表元素
        String[] split = substring.split(",");
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        for (String s : split) {
            ListNode next = new ListNode(Integer.parseInt(s.trim()));
            temp.next = next;
            temp = next;
        }
        return root.next;
    }

    /**
     * 字符串生成二叉树
     *
     * @param str /
     * @return /
     */
    public static TreeNode createTree(String str) {
        if (str == null) return null;
        String substring = str.substring(1, str.length() - 1);//掐头去尾
        if (substring.length() == 0) return null;
        String[] split = substring.split(",");//按照逗号分割
        String s = split[0].trim();
        TreeNode root = s.equals("null") ? null : new TreeNode(Integer.parseInt(s));//树的root节点
        Queue<TreeNode> queue = new LinkedBlockingQueue<>(); //广度优先的辅助队列
        queue.add(root);
        int index = 1;//数组的索引下标
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (index < split.length) {//如果下标越界就跳出while循环
                String s1 = split[index].trim();
                cur.left = s1.equals("null") ? null : new TreeNode(Integer.parseInt(s1));
                index++;
                if (cur.left != null) {//如果节点是null 就不放入队列
                    queue.add(cur.left);
                }
            } else {
                break;
            }
            if (index < split.length) {//如果下标越界就跳出while循环
                String s1 = split[index].trim();
                cur.right = s1.equals("null") ? null : new TreeNode(Integer.parseInt(s1));
                index++;
                if (cur.right != null) {//如果节点是null 就不放入队列
                    queue.add(cur.right);
                }
            } else {
                break;
            }
        }
        return root;
    }

}