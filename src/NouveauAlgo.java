import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Melissa07 on 2017-09-19.
 */
public class NouveauAlgo {
    public static boolean findAnagrams(String word, String dictWord) {

    	HashMap<Character, Integer> wordsHash = createHashMap(word);
        HashMap<Character, Integer> dictWordHash = createHashMap(dictWord);
           
        if(wordsHash.keySet().equals(dictWordHash.keySet())) {
          	for(char character: wordsHash.keySet()) {
    			//System.out.println("retour du get : " + wordsHash.get(character));
        		if(wordsHash.get(character) != dictWordHash.get(character)) {  //HashMap.get() est O(1)
        			return false;
        		}
        	}
        }else {
        	return false;
        }

        return true;
    }

	private static HashMap createHashMap(String word) {
	    HashMap<Character, Integer> hashWord1 = new HashMap();
	    char[] stringArray = word.toCharArray();
	    for (char character: stringArray) {
	        int nbCharsInMap = hashWord1.containsKey(character) ? hashWord1.get(character)+1 : 1;
	        hashWord1.put(character,nbCharsInMap);
	    }
	    return hashWord1;
	}
}