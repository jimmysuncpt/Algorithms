package com.jimmysun.algorithms.chapter4_1;

import edu.princeton.cs.algs4.In;

public class Ex35 {
	private int bridges;
	private int count;
	private int[] pre;
	private int[] low;

	public Ex35(Graph G) {
		pre = new int[G.V()];
		low = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			pre[v] = -1;
			low[v] = -1;
		}
		for (int v = 0; v < G.V(); v++) {
			if (pre[v] == -1) {
				dfs(G, v, v);
			}
		}
	}

	private void dfs(Graph G, int u, int v) {
		pre[v] = count++;
		low[v] = pre[v];
		for (int w : G.adj(v)) {
			if (pre[w] == -1) {
				dfs(G, v, w);
				low[v] = Math.min(low[v], low[w]);
				if (low[w] == pre[w]) {
					bridges++;
				}
			} else if (w != u) {
				low[v] = Math.min(low[v], pre[w]);
			}
		}
	}

	public boolean isEdgeConnectedGraph() {
		return bridges == 0;
	}

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		Ex35 ex = new Ex35(G);
		System.out.println("Is Edge Connected Graph? " + ex.isEdgeConnectedGraph());
	}
}
