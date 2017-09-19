import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Melissa07 on 2017-09-16.
 */
public class Anagramme {
    private static final String DICTIONNARY_NAME = "dict";
    private static final String WORDS_NAME = "words";

    public static void main(String[] args) {
        try{
            FileInputStream fstream = new FileInputStream(WORDS_NAME+".txt");
            ArrayList<String> arrayWords = fileReader(fstream);

            FileInputStream dictStream = new FileInputStream((DICTIONNARY_NAME+".txt"));
            ArrayList<String> wordsInDict = fileReader(dictStream);
            findAnagramsBaseAlgo(arrayWords, wordsInDict);
            NouveauAlgo.findAnagrams(arrayWords, wordsInDict);

        }
        catch(FileNotFoundException fnfe){
            System.out.println("The file : "+WORDS_NAME+".txt was not found");
        }
    }
    
    private static void findAnagramsBaseAlgo(ArrayList<String> arrayWords, ArrayList<String> wordsInDict) {
    	System.out.println("Base Algo : ");
    	int nbOfAnagramForWord;
    	boolean trouve;
    	
    	for (String word: arrayWords) {
    		nbOfAnagramForWord = 0;
    		for(String dictWord: wordsInDict) {
    			
    			trouve = AlgorithmeBase.findAnagramsBaseAlgo(word, dictWord);
    			
    			if(trouve) {
    				nbOfAnagramForWord++;
    			}
    		}
    		System.out.println("Found "+nbOfAnagramForWord+" anagram(s) for the word: " +word);
    	}
    	System.out.println("*******************************************");
    }

    public static HashMap createHashMap(String word) {
        HashMap<Character, Integer> hashWord1 = new HashMap();
        char[] stringArray = word.toCharArray();
        for (char character: stringArray) {
            int nbCharsInMap = hashWord1.containsKey(character) ? hashWord1.get(character)+1 : 1;
            hashWord1.put(character,nbCharsInMap);
        }
        return hashWord1;
    }

    private static ArrayList<String> fileReader(FileInputStream fstream) throws FileNotFoundException {
        ArrayList<String> arrWords = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line = "";
            while((line = br.readLine()) != null){
                arrWords.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return arrWords;
    }

}
