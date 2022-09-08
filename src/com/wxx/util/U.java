package com.wxx.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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


    public static void printTree(TreeNode root) {
        int maxLevel = getTreeDepth(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes == null || nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = buildNewNodes(nodes, betweenSpaces);
        System.out.println("");

        printSomething(nodes, endLines, firstSpaces);

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printSomething(List<TreeNode> nodes, int endLines, int firstSpaces) {
        for (int i = 1; i <= endLines; i++) {
            for (TreeNode node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(endLines + endLines + i + 1);
                    continue;
                }

                if (node.left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);
                if (node.right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(endLines + endLines - i);
            }

            System.out.println("");
        }
    }

    private static List<TreeNode> buildNewNodes(List<TreeNode> nodes, int betweenSpaces) {
        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        return newNodes;
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

    public static void printIntArray(int[] o) {
        for (Object o1 : o) {
            System.out.print(o1.toString());
            System.out.print(" ");
        }
    }
}