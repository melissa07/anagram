import javax.swing.*;
import java.io.*;

/**
 * Created by Melissa07 on 2017-09-16.
 */
public class Anagramme {
    public static void main(String[] args) {
        String fileName = getFileName();

        try{
            FileInputStream fstream = new FileInputStream(fileName+".txt");
            fileReader(fstream);
        }
        catch(FileNotFoundException fnfe){
            System.out.println("The file : "+fileName+".txt was not found");
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

    private static String getFileName(){
        JFrame frame = new JFrame();
        String nameOfFile = (String)JOptionPane.showInputDialog(frame, null, "Enter the file name", JOptionPane.PLAIN_MESSAGE, null, null, null);
        return nameOfFile;
    }
}
