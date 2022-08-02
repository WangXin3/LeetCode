package com.wxx.random.year2022.august;


/**
 * @author Xinxin.Wang
 * @since 2022/8/2 11:13
 */
public class Day02 {

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_11 = obj.enQueue(1);
        boolean param_22 = obj.enQueue(2);
        boolean param_33 = obj.enQueue(3);
        boolean param_44 = obj.enQueue(4);

        int param_4 = obj.Rear();
        System.out.println("param_4 = " + param_4);
        boolean param_6 = obj.isFull();
        System.out.println(param_6);

        boolean b = obj.deQueue();
        System.out.println("b = " + b);

        boolean b1 = obj.enQueue(4);
        System.out.println("b1 = " + b1);
        int rear = obj.Rear();
        System.out.println("rear = " + rear);
    }

}

class MyCircularQueue {
    // 队首
    private int front;
    // 队尾
    private int rear;
    // 队列
    private final int[] elements;
    // 队列容量 + 1
    private final int capacity;

    public MyCircularQueue(int k) {
        capacity = k + 1;
        elements = new int[capacity];
        rear = front = 0;
    }

    /**
     * 在队列的尾部插入一个元素，并同时将队尾的索引 rear 更新为 (rear + 1) mod capacity。
     *
     * @param value /
     * @return /
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * 从队首取出一个元素
     * @return /
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        return true;
    }

    /**
     * 返回队首的元素,需要检测队列是否为空
     * @return /
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return elements[front];
    }

    /**
     * 返回队尾的元素，需要检测队列是否为空。
     * @return /
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return elements[(rear - 1 + capacity) % capacity];
    }

    /**
     * 检测队列是否为空
     * @return /
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 检测队列是否已满
     *
     * @return /
     */
    public boolean isFull() {
        return front == (rear + 1) % capacity;
    }
}
