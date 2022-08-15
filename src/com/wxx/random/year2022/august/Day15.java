package com.wxx.random.year2022.august;

/**
 * @author Xinxin.Wang
 * @since 2022/8/15 9:15
 */
public class Day15 {
    public static void main(String[] args) {
//        Your MyCircularDeque object will be instantiated and called as such:
        MyCircularDeque obj = new MyCircularDeque(3);
        boolean param_2 = obj.insertLast(1);
        boolean param_22 = obj.insertLast(2);
        boolean param_222 = obj.insertFront(3);
        boolean param_2222 = obj.insertFront(4);

//        boolean param_3 = obj.deleteFront();
        int param_6 = obj.getRear();
        boolean param_8 = obj.isFull();
        boolean param_4 = obj.deleteLast();
        boolean param_22222 = obj.insertFront(4);
        int param_5 = obj.getFront();
    }
}

class MyCircularDeque {

    // 队首
    private int front;
    // 队尾
    private int rear;
    // 队列
    private final int[] elements;
    // 队列容量 + 1
    private final int capacity;

    public MyCircularDeque(int k) {
        capacity = k + 1;
        elements = new int[capacity];
        rear = front = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            // 移动元素
            int temp = rear;
            while (temp > front) {
                elements[temp] = elements[temp - 1];
                temp--;
            }
        }
        elements[front] = value;
        rear++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        elements[rear] = value;
        rear++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        int temp = front;
        while (temp < rear) {
            elements[temp] = elements[temp + 1];
            temp++;
        }
        rear--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        elements[rear - 1] = 0;
        rear--;

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[rear - 1];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }
}

class MyCircularDeque1 {
    private int[] elements;
    private int rear, front;
    private int capacity;

    public MyCircularDeque1(int k) {
        capacity = k + 1;
        rear = front = 0;
        elements = new int[k + 1];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        elements[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

