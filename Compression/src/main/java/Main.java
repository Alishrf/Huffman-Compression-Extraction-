import controller.FileGetter;
import controller.FileSetter;
import controller.HuffmanTree;
import model.Node;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input = null;
        String sourceFileName = args[0];
        String destinationFileName = args[1];
        File sourceFile = new File(sourceFileName);
        File destinationFile = new File(destinationFileName);

        try {
            input = new Scanner(sourceFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<Character , Integer> charFr = new HashMap<Character, Integer>();
        charFr = FileGetter.creatTable(input);


        /*//for Debug
        for (char c: charFr.keySet()){
            System.out.println(c + " : " + charFr.get(c));
        }*/


        HuffmanTree.createPriorityQueue(charFr);
        Node root = HuffmanTree.createTree();

        Map<Character , String> b;
        b=FileSetter.createMap(root,"");
        /*For Debug
        for (char c: b.keySet()){
            System.out.println(c + " : " + b.get(c));
        }*/
        try {
            input = new Scanner(sourceFile);
            FileWriter fileWriter = new FileWriter(destinationFile);
            FileSetter.write(fileWriter,input);
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }
}
