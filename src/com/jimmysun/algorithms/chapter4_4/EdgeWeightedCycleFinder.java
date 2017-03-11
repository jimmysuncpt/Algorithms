package com.jimmysun.algorithms.chapter4_4;

import com.jimmysun.algorithms.chapter1_3.Stack;

public class EdgeWeightedCycleFinder {
	private boolean[] marked;
	private DirectedEdge[] edgeTo;
	private Stack<DirectedEdge> cycle;
	private boolean[] onStack;

	public EdgeWeightedCycleFinder(EdgeWeightedDigraph G) {
		onStack = new boolean[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
			}
		}
	}

	private void dfs(EdgeWeightedDigraph G, int v) {
		onStack[v] = true;
		marked[v] = true;
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (this.hasCycle()) {
				return;
			} else if (!marked[w]) {
				edgeTo[w] = e;
				dfs(G, w);
			} else if (onStack[w]) {
				cycle = new Stack<DirectedEdge>();
				DirectedEdge x = e;
				for (; x.from() != w; x = edgeTo[x.from()]) {
					cycle.push(x);
				}
				cycle.push(x);
				return;
			}
		}
		onStack[v] = false;
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<DirectedEdge> cycle() {
		return cycle;
	}
}
