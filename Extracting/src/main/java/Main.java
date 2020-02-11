import controller.FileGetter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String sourceFileName = args[0];
        String destinationFileName = args[1];
        File sourceFile = new File(sourceFileName);
        File destinationFile = new File(destinationFileName);
        try {
            Scanner input = new Scanner(sourceFile);
            FileGetter fileGetter = new FileGetter(input);
            Map<String,Character> map = fileGetter.getMap();
            /*for (Map.Entry<String,Character> e :map.entrySet()){
                System.out.println(e.getKey() + " : " + e.getValue());
            }*/
            String s= fileGetter.createText();
            FileWriter fileWriter = new FileWriter(destinationFile);
            fileWriter.write(s);
            fileWriter.close();
            //System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
