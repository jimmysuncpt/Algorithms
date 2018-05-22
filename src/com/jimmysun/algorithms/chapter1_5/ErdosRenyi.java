package com.jimmysun.algorithms.chapter1_5;

import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {
	public static int count(int N) {
		UF uf = new UF(N);
		int p, q, count = 0;
		while (uf.count() > 1) {
			p = StdRandom.uniform(N);
			q = StdRandom.uniform(N);
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		System.out.println(count(N));
	}
}
