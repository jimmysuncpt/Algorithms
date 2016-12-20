package com.jimmysun.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

public class Parentheses {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		String string = StdIn.readString();
		String[] inputs = string.split("");
		for (String input : inputs) {
			if (input.equals("{") || input.equals("[") || input.equals("(")) {
				stack.push(input);
			} else if (!stack.isEmpty()) {
				if (input.equals("}")) {
					if (!stack.pop().equals("{")) {
						System.out.println(false);
						return;
					}
				} else if (input.equals("]")) {
					if (!stack.pop().equals("[")) {
						System.out.println(false);
						return;
					}
				} else if (input.equals(")")) {
					if (!stack.pop().equals("(")) {
						System.out.println(false);
						return;
					}
				}
			}
		}
		System.out.println(stack.isEmpty());
	}
}
