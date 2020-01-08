package com.itmo.codes.golomb;

public class GolombCoder {
    public static String encode(int n, int m) {
        int t = ((int) Math.pow(2., m));
        int q = n / t + 1;
        int r = n % t;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < q; i++) {
            result.append("1");
        }
        result.append("0|");
        String rest = Integer.toBinaryString(r);
        for (int i = 0; i < m - rest.length(); i++) {
            result.append("0");
        }
        result.append(rest);
        return result.toString();
    }

    public static int decode(String input, int m) {
        StringBuilder restString = new StringBuilder();
        StringBuilder mainString = new StringBuilder();
        int head = 1;
        for (int idx = input.length() - 1; idx >= 0; idx--) {
            if(head <= m) {
                restString.append(input.charAt(idx));
            } else {
                mainString.append(input.charAt(idx));
            }
            head++;
        }
        return (mainString.length() - 1) * (int) (Math.pow(2, m)) + Integer.parseInt(restString.reverse().toString(), 2);
    }
}
