package com.jimmysun.algorithms.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex14 {
	private int[] id;
	private int[] height;
	private int count;

	public Ex14(int N) {
		count = N;
		id = new int[N];
		height = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			height[i] = 1;
		}
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}
		if (height[i] < height[j]) {
			id[i] = j;
		} else {
			id[j] = i;
			if (height[i] == height[j]) {
				height[i]++;
			}
		}
		count--;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		Ex14 uf = new Ex14(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " components");
	}
}
