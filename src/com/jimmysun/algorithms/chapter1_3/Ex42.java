package com.jimmysun.algorithms.chapter1_3;

public class Ex42 {
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<>();
		for (int i = 0; i < 10; i++) {
			stack1.push(i);
		}
		Stack<Integer> stack2 = new Stack<>(stack1);
		stack1.pop();
		stack1.push(10);
		while (!stack1.isEmpty()) {
			System.out.print(stack1.pop() + " ");
		}
		System.out.println();
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop() + " ");
		}
		System.out.println();
	}
}
