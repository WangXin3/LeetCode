package com.wxx.code3to9;

import java.util.Stack;

/**
 * @author 她爱微笑
 * @date 2019/10/24
 * 用两个栈模拟队列
 */
public class SimulationQueue {

	Stack<Integer> inStack = new Stack<>();
	Stack<Integer> outStack = new Stack<>();

	public void push(int data) {
		inStack.push(data);
	}

	public int pop() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}

		if (outStack.isEmpty()) {
			System.out.println("队列为空");
		}
		return outStack.pop();
	}

	public static void main(String[] args) {
		SimulationQueue simulationQueue = new SimulationQueue();

		simulationQueue.push(1);
		simulationQueue.push(2);
		simulationQueue.push(3);

		System.out.println(simulationQueue.pop());

		simulationQueue.push(4);
		System.out.println(simulationQueue.pop());
	}
}
