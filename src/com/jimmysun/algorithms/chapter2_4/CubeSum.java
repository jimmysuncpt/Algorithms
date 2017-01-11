package com.jimmysun.algorithms.chapter2_4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;

public class CubeSum implements Comparable<CubeSum> {
	private int i, j, sum;

	public CubeSum(int i, int j) {
		this.i = i;
		this.j = j;
		sum = i * i * i + j * j * j;
	}

	@Override
	public int compareTo(CubeSum that) {
		if (this.sum > that.sum) {
			return 1;
		} else if (this.sum < that.sum) {
			return -1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		MinPQ<CubeSum> pq = new MinPQ<>();
		for (int i = 0; i <= N; i++) {
			pq.insert(new CubeSum(i, 0));
		}
		while (!pq.isEmpty()) {
			CubeSum min = pq.delMin();
			System.out.println(min.sum + " = " + min.i + "^3 + " + min.j + "^3");
			if (min.j < N) {
				pq.insert(new CubeSum(min.i, min.j + 1));
			}
		}
	}
}
