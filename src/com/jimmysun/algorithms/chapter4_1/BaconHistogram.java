package com.jimmysun.algorithms.chapter4_1;

import edu.princeton.cs.algs4.StdOut;

public class BaconHistogram {
	public static void main(String[] args) {
		SymbolGraph sg = new SymbolGraph("movies.txt", "/");

		Graph G = sg.G();

		String source = "Bacon, Kevin";
		if (!sg.contains(source)) {
			StdOut.println(source + "not in database.");
			return;
		}

		int s = sg.index(source);
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

		int[] num = new int[G.V()];
		int infinite = 0;
		for (int v = 0; v < G.V(); v++) {
			int distance = bfs.distTo(v);
			if (distance != Integer.MAX_VALUE) {
				num[distance]++;
			} else {
				infinite++;
			}
		}
		for (int i = 0; i < num.length; i += 2) {
			if (num[i] != 0) {
				System.out.println("Kevin Bacon = " + i / 2 + " : " + num[i]);
			} else {
				break;
			}
		}
		System.out.println("Infinite(actors and movies): " + infinite);
	}
}
