package com.jimmysun.algorithms.chapter2_5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class Frequency {
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Arrays.sort(a);
		Record[] records = new Record[a.length];
		records[0] = new Record(a[0]);
		int n = 0;
		for (int i = 1; i < a.length; i++) {
			if (records[n].getWord().equals(a[i])) {
				records[n].addFreq();
			} else {
				records[++n] = new Record(a[i]);
			}
		}
		Arrays.sort(records, 0, n);
		for (int i = 0; i <= n; i++) {
			Record record = records[i];
			System.out.println(record.getWord() + ": " + record.getFreq());
		}
	}
}
