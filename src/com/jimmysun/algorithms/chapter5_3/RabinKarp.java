package com.jimmysun.algorithms.chapter5_3;

import java.math.BigInteger;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class RabinKarp {
	private long patHash;
	private int M;
	private long Q;
	private int R = 256;
	private long RM;

	public RabinKarp(String pat) {
		this.M = pat.length();
		Q = longRandomPrime();
		RM = 1;
		for (int i = 1; i <= M - 1; i++) {
			RM = (R * RM) % Q;
		}
		patHash = hash(pat, M);
	}

	public boolean check(int i) { // 蒙特卡洛算法
		return true;
	}

	private long hash(String key, int M) {
		// 计算key[0..M-1]的散列值
		long h = 0;
		for (int j = 0; j < M; j++) {
			h = (R * h + key.charAt(j)) % Q;
		}
		return h;
	}

	public int search(String txt) {
		int N = txt.length();
		long txtHash = hash(txt, M);
		if (patHash == txtHash && check(0)) {
			return 0;
		}
		for (int i = M; i < N; i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if (patHash == txtHash) {
				if (check(i - M + 1)) {
					return i - M + 1;
				}
			}
		}
		return N;
	}

	/**
	 * Exercise 5.3.33
	 * 
	 * @return
	 */
	private static long longRandomPrime() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();
	}

	public static void main(String[] args) {
		String pat = args[0];
		String txt = args[1];
		RabinKarp rk = new RabinKarp(pat);
		StdOut.println("text:    " + txt);
		int offset = rk.search(txt);
		StdOut.print("pattern: ");
		for (int i = 0; i < offset; i++) {
			StdOut.print(" ");
		}
		StdOut.println(pat);
	}
}
