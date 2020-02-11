package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileGetter {
    public static Map<Character,Integer> creatTable(Scanner input){
        Map<Character,Integer> table = new HashMap<Character, Integer>();
        while (input.hasNext()){
            String line = input.nextLine();

            //~ is '\n'
            if(table.containsKey('~')){
                int fr = table.get('~');
                table.remove('~');
                table.put('~' , fr+1);
            }else {
                table.put('~',1);
            }



            for (int i = 0; i < line.length(); i++) {
                if(table.containsKey(line.charAt(i))){
                    int fr = table.get(line.charAt(i));
                    table.remove(line.charAt(i));
                    table.put(line.charAt(i) , fr+1);
                }else {
                    table.put(line.charAt(i),1);
                }
            }
        }
        return table;
    }


}
