package controller;

import model.Node;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileSetter {
    private static Map<Character,String> code = new HashMap<Character, String>();
    public static Map<Character,String> createMap(Node n,String s) {
        if (n.isLeaf()) {
            code.put(n.getCharacter(), s);
        } else {
            createMap(n.getLeft(),   s + "0");
            createMap(n.getRight(), s + "1" );
        }
        return code;
    }



    public static void write(FileWriter fileWriter, Scanner input) throws IOException {
        if(code.size() == 0){
            return;
        }
        String keys= new String();
        for (Map.Entry<Character,String> c :code.entrySet()){
            keys += c.getKey().toString() + c.getValue()+"|";
        }
        keys+="\n";
        fileWriter.write(keys);
        //write text in new file
        String text = "";
        while (input.hasNext()) {
            String line = input.nextLine();
            line+="~";
            for (int i = 0; i < line.length(); i++) {
                String var = code.get(line.charAt(i));
                for (int j = 0; j <var.length() ; j++) {
                    text +="" + var.charAt(j);
                    if(text.length() == 8){
                        fileWriter.write(Integer.parseInt(text,2));
                        text = "";
                    }
                }

            }

        }


    }
}
