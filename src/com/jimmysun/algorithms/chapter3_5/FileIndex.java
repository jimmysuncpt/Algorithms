package com.jimmysun.algorithms.chapter3_5;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FileIndex {
	public static void main(String[] args) {
		ST<String, SET<File>> st = new ST<String, SET<File>>();
		for (String filename : args) {
			File file = new File(filename);
			In in = new In(file);
			while (!in.isEmpty()) {
				String word = in.readString();
				if (!st.contains(word)) {
					st.put(word, new SET<File>());
				}
				SET<File> set = st.get(word);
				set.add(file);
			}
		}
		while (!StdIn.isEmpty()) {
			String query = StdIn.readString();
			if (st.contains(query)) {
				for (File file : st.get(query)) {
					StdOut.println(" " + file.getName());
				}
			}
		}
	}
}
