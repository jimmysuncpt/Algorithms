package com.tsq.phase1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);

        Queue<String> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }

        if (k > queue.size() || k <= 0) {
            StdOut.println("k is wrong");
            return;
        }

        int queueLength = queue.size();
        for (int i = 0; i < queueLength - k; i++) {
            queue.dequeue();
        }

        StdOut.println(queue.dequeue());
    }
}
