package com.jimmysun.algorithms.chapter2_1;

import edu.princeton.cs.algs4.In;

public class Ex18 {

	public static void main(String[] args) {
		String[] a = new In().readAllStrings();
		String sort = args[0];
		if (sort.equals("selection")) {
			Selection.drawSort(a);
		} else if (sort.equals("insertion")) {
			Insertion.drawSort(a);
		}
	}
}
