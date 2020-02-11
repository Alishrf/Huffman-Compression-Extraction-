package controller;

import model.Node;


import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private static PriorityQueue<Node> nodes = new PriorityQueue<Node>();

    public static PriorityQueue<Node> createPriorityQueue(Map<Character,Integer> table){
        for (char c:table.keySet()){
            Node node = new Node();
            node.setLeaf(true);
            node.setCharacter(c);
            node.setFreq(table.get(c));
            nodes.add(node);
        }
        return nodes;

    }
    public static Node  createTree(){
        while (nodes.size() > 1){
            Node a = nodes.poll();
            Node b = nodes.poll();
            Node ab = new Node();
            ab.setFreq(a.getFreq() + b.getFreq());
            ab.setLeft(a);
            ab.setRight(b);
            nodes.add(ab);
        }
        Node root = nodes.poll();
        return root;
    }

}
