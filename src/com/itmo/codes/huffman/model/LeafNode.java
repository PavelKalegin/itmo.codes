package com.itmo.codes.huffman.model;

public class LeafNode extends Node {

    private final Character character;

    private String code;

    public LeafNode(int sum, Character character) {
        super(sum);
        this.character = character;
    }

    @Override
    public void buildCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    public Character getCharacter() {
        return character;
    }
}
