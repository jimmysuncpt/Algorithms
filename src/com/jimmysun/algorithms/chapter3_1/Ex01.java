package com.jimmysun.algorithms.chapter3_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex01 {

	public static void main(String[] args) {
		SequentialSearchST<String, Double> st = new SequentialSearchST<>();
		st.put("A+", 4.33);
		st.put("A", 4.00);
		st.put("A-", 3.67);
		st.put("B+", 3.33);
		st.put("B", 3.00);
		st.put("B-", 2.67);
		st.put("C+", 2.33);
		st.put("C", 2.00);
		st.put("C-", 1.67);
		st.put("D", 1.00);
		st.put("F", 0.00);
		String[] a = StdIn.readAllStrings();
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += st.get(a[i]);
		}
		System.out.println("GPA: " + sum / a.length);
	}
}
