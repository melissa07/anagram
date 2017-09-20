import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Melissa07 on 2017-09-16.
 */
public class Anagramme {
    private static final String DICTIONNARY_NAME = "dictbig";
    private static final String WORDS_NAME = "wordsbig";

    public static void main(String[] args) {
        try{
            FileInputStream fstream = new FileInputStream(WORDS_NAME+".txt");
            ArrayList<String> arrayWords = fileReader(fstream);

            FileInputStream dictStream = new FileInputStream((DICTIONNARY_NAME+".txt"));
            ArrayList<String> wordsInDict = fileReader(dictStream);
            findAnagramsBaseAlgo(arrayWords, wordsInDict);
            findAnagramsNouveauAlgo(arrayWords, wordsInDict);

        }
        catch(FileNotFoundException fnfe){
            System.out.println("The file : "+WORDS_NAME+".txt was not found");
        }
    }
    
    private static void findAnagramsNouveauAlgo(ArrayList<String> arrayWords, ArrayList<String> wordsInDict) {
    	System.out.println("New Algo : ");
    	Chronometer chrono = new Chronometer();
    	int nbOfAnagramForWord;
    	boolean trouve;
    	
    	chrono.start();
    	for (String word: arrayWords) {
    		nbOfAnagramForWord = 0;
    		for(String dictWord: wordsInDict) {
    			
    			trouve = NouveauAlgo.findAnagrams(word, dictWord);
    			
    			if(trouve) {
    				nbOfAnagramForWord++;
    			}
    		}
    		System.out.println("Found "+nbOfAnagramForWord+" anagram(s) for the word: " +word);
    	}
    	chrono.stop();
    	System.out.println("All Anagram found in : " + chrono.getMilliseconds() + "ms or :" + chrono.getSeconds() + "s.");    	
    	System.out.println("*******************************************");
    }
    
    private static void findAnagramsBaseAlgo(ArrayList<String> arrayWords, ArrayList<String> wordsInDict) {
    	System.out.println("Base Algo : ");
    	Chronometer chrono = new Chronometer();
    	int nbOfAnagramForWord;
    	boolean trouve;
    	
    	chrono.start();
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
    	chrono.stop();
    	System.out.println("All Anagram found in : " + chrono.getMilliseconds() + "ms or :" + chrono.getSeconds() + "s.");
    	System.out.println("*******************************************");
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
