package com.jimmysun.algorithms.chapter1_1;

public class Ex24 {
	public static int euclid(int p, int q) {
		System.out.println("p = " + p + ", q = " + q);
		if (p < q) {
			int t = p;
			p = q;
			q = t;
		}
		if (p % q == 0) {
			return q;
		} else {
			return euclid(q, p % q);
		}
	}

	public static void main(String[] args) {
		System.out.println("result: " + euclid(105, 24));
		System.out.println("result: " + euclid(1111111, 1234567));
	}
}
