package model;

import java.util.Comparator;

public class Node implements Comparable<Node> {
    private char character;
    private int freq;
    private boolean isLeaf;
    Node left;
    Node right;


    public Node() {
        isLeaf = false;
        character = '-';
        freq = 0;
        left = null;
        right = null;
    }

    public int compareTo(Node node) {
        return this.getFreq() - node.getFreq();
    }

    public char getCharacter() {
        return character;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
