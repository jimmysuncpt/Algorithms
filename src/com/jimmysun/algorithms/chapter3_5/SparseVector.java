package com.jimmysun.algorithms.chapter3_5;

import edu.princeton.cs.algs4.ST;

public class SparseVector {
	private ST<Integer, Double> st;

	public SparseVector() {
		st = new ST<Integer, Double>();
	}

	public int size() {
		return st.size();
	}

	public void put(int i, double x) {
		st.put(i, x);
	}

	public double get(int i) {
		if (!st.contains(i)) {
			return 0.0;
		} else {
			return st.get(i);
		}
	}

	public double dot(double[] that) {
		double sum = 0.0;
		for (int i : st.keys()) {
			sum += that[i] * this.get(i);
		}
		return sum;
	}

	// Exercise 3.5.23
	public double dot(SparseVector that) {
		double sum = 0.0;
		if (this.st.size() <= that.st.size()) {
			for (int i : this.st.keys()) {
				if (that.st.contains(i)) {
					sum += this.get(i) * that.get(i);
				}
			}
		} else {
			for (int i : that.st.keys()) {
				if (this.st.contains(i)) {
					sum += this.get(i) * that.get(i);
				}
			}
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i : st.keys()) {
			s.append("(" + i + ", " + st.get(i) + ") ");
		}
		return s.toString();
	}
}
