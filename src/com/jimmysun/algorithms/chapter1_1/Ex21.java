package com.jimmysun.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex21 {
	public static void main(String[] args) {
		System.out.print("Please input count:");
		int n = StdIn.readInt();
		String[] nameArray = new String[n];
		int[] integerArray1 = new int[n];
		int[] integerArray2 = new int[n];
		for (int i = 0; i < n; i++) {
			nameArray[i] = StdIn.readString();
			integerArray1[i] = StdIn.readInt();
			integerArray2[i] = StdIn.readInt();
		}
		System.out.println("©°----©Ð----©Ð----©Ð------©´");
		for (int i = 0; i < n; i++) {
			System.out.printf("|%4s|%4d|%4d|%6.3f|\n", nameArray[i], integerArray1[i], integerArray2[i],
					(float) integerArray1[i] / integerArray2[i]);
			if (i != n - 1) {
				System.out.println("©À----©à----©à----©à------©È");
			}
		}
		System.out.println("©¸----©Ø----©Ø----©Ø------©¼");
	}
}
