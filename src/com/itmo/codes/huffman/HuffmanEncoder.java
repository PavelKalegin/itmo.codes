package com.itmo.codes.huffman;

import com.itmo.codes.huffman.model.InternalNode;
import com.itmo.codes.huffman.model.LeafNode;
import com.itmo.codes.huffman.model.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HuffmanEncoder {

    /**
     * Encode string using Huffman prefix algorithm
     * @param inputString string to be encoded with length at least 2.
     * @return Map contains each unique character of input string and its code.
     */
    public static Map<Character, String> getCodeMap(String inputString) {
        Map<Character, Integer> symbolCounts = new HashMap<>(inputString.length());
        for (char c : inputString.toCharArray()) {
            symbolCounts.putIfAbsent(c, 0);
            symbolCounts.computeIfPresent(c, (character, count) -> ++count);
        }
        Map<Character, Node> characterNodeMap = symbolCounts.entrySet().stream()
                .map(symbolCount -> new  LeafNode(symbolCount.getValue(), symbolCount.getKey()))
                .collect(Collectors.toMap(LeafNode::getCharacter, Function.identity()));
        PriorityQueue<Node> leafNodesQueue = new PriorityQueue<>(characterNodeMap.size());
        leafNodesQueue.addAll(characterNodeMap.values());
        while (leafNodesQueue.size() > 1) {
            leafNodesQueue.add(new InternalNode(leafNodesQueue.poll(), leafNodesQueue.poll()));
        }
        leafNodesQueue.poll().buildCode("");
        return characterNodeMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getCode()));
    }
}
