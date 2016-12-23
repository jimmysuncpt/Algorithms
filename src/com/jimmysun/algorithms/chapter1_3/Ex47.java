package com.jimmysun.algorithms.chapter1_3;

public class Ex47 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		Stack<Integer> stack2 = new Stack<>();
		for (int i = 5; i < 10; i++) {
			stack2.push(i);
		}
		stack.catenation(stack2);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		Queue<Integer> queue = new Queue<>();
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
		Queue<Integer> queue2 = new Queue<>();
		for (int i = 5; i < 10; i++) {
			queue2.enqueue(i);
		}
		queue.catenation(queue2);
		while (!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
		System.out.println();
	}
}
