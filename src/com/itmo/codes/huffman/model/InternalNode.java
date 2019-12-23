package com.itmo.codes.huffman.model;

public class InternalNode extends Node {
    private final Node left;
    private final Node right;

    public InternalNode(Node left, Node right) {
        super(left.getSum() + right.getSum());
        this.left = left;
        this.right = right;
    }

    @Override
    public void buildCode(String code) {
        left.buildCode(code + "0");
        right.buildCode(code + "1");
    }
}
