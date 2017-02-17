package com.jimmysun.algorithms.chapter4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SymbolDigraph {
	private ST<String, Integer> st;
	private String[] keys;
	private Digraph G;

	public SymbolDigraph(String stream, String sp) {
		st = new ST<String, Integer>();
		In in = new In(stream);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			for (int i = 0; i < a.length; i++) {
				if (!st.contains(a[i])) {
					st.put(a[i], st.size());
				}
			}
		}
		keys = new String[st.size()];
		for (String name : st.keys()) {
			keys[st.get(name)] = name;
		}

		G = new Digraph(st.size());
		in = new In(stream);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				G.addEdge(v, st.get(a[i]));
			}
		}
	}

	public boolean contains(String s) {
		return st.contains(s);
	}

	public int index(String s) {
		return st.get(s);
	}

	public String name(int v) {
		return keys[v];
	}

	public Digraph G() {
		return G;
	}

	public static void main(String[] args) {
		String filename = args[0];
		String delim = args[1];
		SymbolDigraph sg = new SymbolDigraph(filename, delim);
		Digraph G = sg.G();
		while (StdIn.hasNextLine()) {
			String source = StdIn.readLine();
			for (int w : G.adj(sg.index(source))) {
				StdOut.println("   " + sg.name(w));
			}
		}
	}
}
