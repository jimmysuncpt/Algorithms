package com.jimmysun.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

public class EvaluatePostfix {
	public static void main(String[] args) {
		Stack<Double> stack = new Stack<>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			double result;
			switch (s) {
			case "+":
				result = stack.pop() + stack.pop();
				stack.push(result);
				break;
			case "-":
				result = -stack.pop() + stack.pop();
				stack.push(result);
				break;
			case "*":
				result = stack.pop() * stack.pop();
				stack.push(result);
				break;
			case "/":
				result = 1 / stack.pop() * stack.pop();
				stack.push(result);
				break;
			default:
				stack.push(Double.parseDouble(s));
			}
		}
		System.out.println(stack.pop());
	}
}
