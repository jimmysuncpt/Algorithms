package com.jimmysun.algorithms.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex08 {
	private int[] id;
	private int count;

	public Ex08(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		return id[p];
	}

	public void union(int p, int q) {
		if (connected(p, q)) {
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i] == id[p]) {
				id[i] = id[q];
			}
		}
		count--;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		Ex08 uf = new Ex08(N);
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
