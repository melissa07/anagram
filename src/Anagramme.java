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
            findAnagramsNouveauAlgo(arrayWords, wordsInDict);
            findAnagramsNouveauAlgoSansHashMap(arrayWords, wordsInDict);

        }
        catch(FileNotFoundException fnfe){
            System.out.println("The file : "+WORDS_NAME+".txt was not found");
        }
    }
    
    private static void findAnagramsNouveauAlgo(ArrayList<String> arrayWords, ArrayList<String> wordsInDict) {
    	System.out.println("New Algo : ");
    	int nbOfAnagramForWord;
    	boolean trouve;
    	
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
    	System.out.println("*******************************************");
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

    private static void findAnagramsNouveauAlgoSansHashMap(ArrayList<String> arrayWords, ArrayList<String> wordsInDict) {
        System.out.println("New Algo : ");
        int nbOfAnagramForWord;
        boolean trouve;

        for (String word: arrayWords) {
            nbOfAnagramForWord = 0;
            for(String dictWord: wordsInDict) {

                trouve = NouveauAlgoSansHashMap.findAnagramsWithoutHashmap(word, dictWord);

                if(trouve) {
                    nbOfAnagramForWord++;
                }
            }
            System.out.println("Found "+nbOfAnagramForWord+" anagram(s) for the word: " +word);
        }
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
