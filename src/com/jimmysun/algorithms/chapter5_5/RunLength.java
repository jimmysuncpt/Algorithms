package com.jimmysun.algorithms.chapter5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class RunLength {
	public static void expand() {
		boolean b = false;
		while (!BinaryStdIn.isEmpty()) {
			char cnt = BinaryStdIn.readChar();
			for (int i = 0; i < cnt; i++) {
				BinaryStdOut.write(b);
			}
			b = !b;
		}
		BinaryStdOut.close();
	}

	public static void compress() {
		char cnt = 0;
		boolean b, old = false;
		while (!BinaryStdIn.isEmpty()) {
			b = BinaryStdIn.readBoolean();
			if (b != old) {
				BinaryStdOut.write(cnt);
				cnt = 0;
				old = !old;
			} else {
				if (cnt == 255) {
					BinaryStdOut.write(cnt);
					cnt = 0;
					BinaryStdOut.write(cnt);
				}
			}
			cnt++;
		}
		BinaryStdOut.write(cnt);
		BinaryStdOut.close();
	}

	public static void main(String[] args) {
		if (args[0].equals("-")) {
			compress();
		}
		if (args[0].equals("+")) {
			expand();
		}
	}
}
