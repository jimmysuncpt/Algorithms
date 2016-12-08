package com.jimmysun.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

public class Ex05 {
	public static void main(String[] args) {
		String s = "Hello World";
		s.toUpperCase();
		s.substring(6, 11);
		StdOut.println(s);
		
		s = s.toUpperCase();
		s = s.substring(6, 11);
		StdOut.println(s);
	}
}
