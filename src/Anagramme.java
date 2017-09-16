import javax.swing.*;
import java.io.*;

/**
 * Created by Melissa07 on 2017-09-16.
 */
public class Anagramme {
    private static final String DICTIONNARY_NAME = "dict";
    private static final String WORDS_NAME = "words";

    public static void main(String[] args) {
        try{
            FileInputStream fstream = new FileInputStream(WORDS_NAME+".txt");
            fileReader(fstream);
        }
        catch(FileNotFoundException fnfe){
            System.out.println("The file : "+WORDS_NAME+".txt was not found");
        }
    }

    private static void fileReader(FileInputStream fstream) throws FileNotFoundException {
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line = "";
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
