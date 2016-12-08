package com.jimmysun.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdIn;

public class Ex06 {
	public static void main(String[] args) {
		System.out.print("s: ");
		String s = StdIn.readLine();
		System.out.print("t: ");
		String t = StdIn.readLine();
		if (s.length() == t.length() && s.concat(s).indexOf(t) >= 0) {
			System.out.println(s + " is the circular rotation of " + t);
		} else {
			System.out.println(s + " is not the circular rotation of " + t);
		}
	}
}
