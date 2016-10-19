package com.jimmysun.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex03 {
	public static void main(String[] args) {
		int a = StdIn.readInt();
		int b = StdIn.readInt();
		int c = StdIn.readInt();
		if (a == b && a == c) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}
}
