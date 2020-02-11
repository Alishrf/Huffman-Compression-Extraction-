package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileGetter {
    private Scanner input;
    private String text;
    private Map<String,Character> keys;

    public FileGetter(Scanner input) {
        this.input = input;
        this.text = new String();
        keys = new HashMap<String, Character>();
    }
    public Map<String,Character> getMap(){
        String k=input.nextLine();
        char a = k.charAt(0);
        String v ="";
        for (int i = 1; i < k.length(); i++) {
            if(k.charAt(i) != '|' ){
                v+=k.charAt(i);
            }else {
                keys.put(v,a);
                v="";
                if(i < k.length()-1){
                    a = k.charAt(i+1);
                }
                i++;
            }
        }
        keys.put(v,a);
        return keys;
    }
    public String createText(){
        String var="";
        while (input.hasNext()){
            String line = input.nextLine();
            for (int i = 0; i < line.length(); i++) {
                String bytes = Integer.toBinaryString(line.charAt(i));
                String firstZero="";
                for (int j = 0; j < 8 - bytes.length(); j++) {
                    firstZero+="0";
                }
                bytes = firstZero+bytes;
                for (int j = 0; j < bytes.length(); j++) {
                    var+=bytes.charAt(j);
                    if(keys.containsKey(var)){
                        if(keys.get(var) == '~'){
                            text+="\n";
                        }else {
                            text += keys.get(var);
                        }
                        var="";
                    }
                }
            }
        }
        return text;
    }


}
