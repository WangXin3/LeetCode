package com.wxx.utils;

import java.util.Objects;

/**
 * @author 她爱微笑
 * @date 2019/10/15
 * 链表
 */
public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode() {
        this.val = null;
        this.next = null;
    }

    public ListNode(T val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        for (ListNode cur = this; ; cur = cur.next) {
            if (cur == null) {
                ret.deleteCharAt(ret.lastIndexOf(" "));
                ret.deleteCharAt(ret.lastIndexOf(","));
                break;
            }
            ret.append(cur.val);
            ret.append(", ");
        }
        ret.append("]");
        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(val, listNode.val) && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
