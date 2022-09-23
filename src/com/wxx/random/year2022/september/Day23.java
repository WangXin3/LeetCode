package com.wxx.random.year2022.september;

/**
 * @author Xinxin.Wang
 * @since 2022/9/23 9:11
 */
public class Day23 {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.deleteAtIndex(1);
        obj.addAtHead(2);
        obj.addAtHead(7);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(5);
        obj.addAtTail(5);
        obj.get(5);
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);


    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

class MyLinkedList {
    int size;
    int[] arr;

    public MyLinkedList() {
        size = 0;
        arr = new int[1];
    }

    public int get(int index) {
        if (index >= size || size < 0) {
            return -1;
        }

        return arr[index];
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 如果插入索引大于链表长度，则不插入
        if (index > size || index < 0) {
            return;
        }

        int[] newArr = new int[arr.length + 1];
        if (index <= 0) {
            // 头部
            System.arraycopy(arr, 0, newArr, 1, size);
            newArr[0] = val;
            arr = newArr;
        } else if (index == size) {
            // 尾部
            System.arraycopy(arr, 0, newArr, 0, size);
            newArr[size] = val;
            arr = newArr;
        } else {
            // 按索引
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(arr, index, newArr, index + 1, size - index);
            newArr[index] = val;
            arr = newArr;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, size - index - 1);

        arr = newArr;
        size--;
    }
}

