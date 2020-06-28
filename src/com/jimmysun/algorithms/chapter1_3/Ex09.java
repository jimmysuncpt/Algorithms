package com.tsq.phase1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex09 {
    public static void main(String[] args) {
        Stack<String> numberStack = new Stack<>();
        Stack<String> symbolStack = new Stack<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
                symbolStack.push(item);
            } else if (item.equals(")")) {
                String number2 = numberStack.pop();
                String number1 = numberStack.pop();
                numberStack.push("(" + number1 + symbolStack.pop() + number2 + ")");
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

        StdOut.println(numberStack.pop());
    }
}
