package com.jimmysun.algorithms.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

public class InfixToPostfix {
	public static void main(String[] args) {
		Stack<String> numberStack = new Stack<>();
		Stack<String> symbolStack = new Stack<>();

		while (!StdIn.isEmpty()) {
		    String item = StdIn.readString();

		    if (item.equals("*") || item.equals("/") || item.equals("+") || item.equals("-")) {
			if (symbolStack.peek() == null) {
			    symbolStack.push(item);
			} else {
			    String latestSymbol = symbolStack.peek();
			    if (latestSymbol.equals("(") || ((item.equals("*") || item.equals("/")) && (latestSymbol.equals("+") || latestSymbol.equals("-")))) {
				symbolStack.push(item);
			    } else {
				numberStack.push(symbolStack.pop());
				symbolStack.push(item);
			    }
			}
		    } else if (item.equals(")")) {
			while (!symbolStack.peek().equals("(")) {
			    numberStack.push(symbolStack.pop());
			}
			symbolStack.pop();
		    } else if (item.equals("(")) {
			symbolStack.push(item);
		    } else {
			try {
			    int numberResult = Integer.parseInt(item);
			    numberStack.push(String.valueOf(numberResult));
			} catch (NumberFormatException ex) {
			    StdOut.println("Wrong Input");
			    return;
			}
		    }
		}

		while (symbolStack.peek() != null) {
		    numberStack.push(symbolStack.pop());
		}

		String result = "";
		while (numberStack.peek() != null) {
		    result = numberStack.pop() + " " + result;
		}

		StdOut.println(result.substring(0, result.length() - 1));
	}
}
