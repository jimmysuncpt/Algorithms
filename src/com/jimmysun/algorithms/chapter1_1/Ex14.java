package com.jimmysun.algorithms.chapter1_1;

public class Ex14 {
	public static int lg(int N) {
        int i, n;
        for (i = 0, n = 1; n <= N; i++) {
            n *= 2;
        }
        return i - 1;
    }
    
    private static int biggestIntLessLog2N(int n) {
        //idea 实际上可以看成是求 2 进制表示法时的副产品
        int shiftRightCount = 0;
        do {
            n >>= 1;
            shiftRightCount++;
        } while (n != 0);
        return shiftRightCount - 1;
    }
    
    public static void main(String[] args) {
        int value = 1025;
        System.out.printf("the result of method biggestIntLessLog2N is :%s\r\n", biggestIntLessLog2N(value));
        System.out.printf("the result of method log is :%s\r\n", lg(value));
    }
}
