import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Melissa07 on 2017-09-19.
 */
public class NouveauAlgo {
    public static void findAnagrams(ArrayList<String> arrayWords, ArrayList<String> wordsInDict) {
        System.out.println("New Algo : ");
        for (String word: arrayWords) { // O(n^2)
            int nbOfAnagramForWord = 0;
            HashMap<Character, Integer> wordsHash = Anagramme.createHashMap(word);
            for(String dictWord: wordsInDict) {
                HashMap<Character, Integer> dictWordHash = Anagramme.createHashMap(dictWord);
                if(dictWordHash.keySet().equals(wordsHash.keySet())) { // doesnt work. ex: crane and craane are anagrams
                    nbOfAnagramForWord++;
                }
            }
            System.out.println("Found "+nbOfAnagramForWord+" anagram(s) for the word: " +word);
        }
        System.out.println("*******************************************");

    }
}
