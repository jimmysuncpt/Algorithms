package com.jimmysun.algorithms.chapter4_4;

import java.util.Comparator;

import com.jimmysun.algorithms.chapter1_3.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Ex39 {
	private boolean[] marked;
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private MinPQ<DirectedEdge> pq;

	private class ByDistanceFromSource implements Comparator<DirectedEdge> {
		public int compare(DirectedEdge e, DirectedEdge f) {
			double dist1 = distTo[e.from()] + e.weight();
			double dist2 = distTo[f.from()] + f.weight();
			return Double.compare(dist1, dist2);
		}
	}

	public Ex39(EdgeWeightedDigraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new MinPQ<>(new ByDistanceFromSource());

		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;

		relax(G, s);
		while (!pq.isEmpty()) {
			int w = pq.delMin().to();
			if (!marked[w]) {
				relax(G, w);
			}
		}
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		marked[v] = true;
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				pq.insert(e);
			}
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
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
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		Ex39 sp = new Ex39(G, s);

		for (int t = 0; t < G.V(); t++) {
			StdOut.print(s + " to " + t);
			StdOut.printf(" (%4.2f): ", sp.distTo(t));
			if (sp.hasPathTo(t)) {
				for (DirectedEdge e : sp.pathTo(t)) {
					StdOut.print(e + "   ");
				}
			}
			StdOut.println();
		}
	}
}
