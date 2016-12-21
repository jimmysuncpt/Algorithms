package com.jimmysun.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

public class InfixToPostfix {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			switch (s) {
			case "+":
			case "-":
			case "*":
			case "/":
				stack.push(s);
				break;
			case "(":
				break;
			case ")":
				System.out.print(stack.pop() + " ");
				break;
			default:
				System.out.print(s + " ");
			}
		}
		System.out.println();
	}
}
