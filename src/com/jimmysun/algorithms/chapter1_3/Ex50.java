package com.jimmysun.algorithms.chapter1_3;

import java.util.Iterator;

public class Ex50 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		Iterator<Integer> iterator = stack.iterator();
		if (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		stack.push(5);
		stack.pop();
		if (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
