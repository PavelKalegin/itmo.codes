package com.itmo.codes.huffman.model;

public abstract class Node implements Comparable<Node> {
    private final int sum;
    private String code;

    protected Node(int sum) {
        this.sum = sum;
    }

    public abstract void buildCode(String code);

    @Override
    public int compareTo(Node node) {
        return Integer.compare(sum, node.getSum());
    }

    public int getSum() {
        return sum;
    }

    public String getCode() {
        return code;
    }
}
