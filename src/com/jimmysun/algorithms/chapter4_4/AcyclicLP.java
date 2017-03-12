package com.jimmysun.algorithms.chapter4_4;

import com.jimmysun.algorithms.chapter1_3.Stack;

import edu.princeton.cs.algs4.In;

public class AcyclicLP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;

	public AcyclicLP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];

		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.NEGATIVE_INFINITY;
		}
		distTo[s] = 0.0;

		EdgeWeightedTopological top = new EdgeWeightedTopological(G);
		for (int v : top.order()) {
			relax(G, v);
		}
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] < distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] > Double.NEGATIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		int s = Integer.parseInt(args[1]);
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

		AcyclicLP lp = new AcyclicLP(G, s);

		for (int v = 0; v < G.V(); v++) {
			if (lp.hasPathTo(v)) {
				System.out.printf("%d to %d (%.2f)  ", s, v, lp.distTo(v));
				for (DirectedEdge e : lp.pathTo(v)) {
					System.out.print(e + "   ");
				}
				System.out.println();
			} else {
				System.out.printf("%d to %d         no path\n", s, v);
			}
		}
	}
}
