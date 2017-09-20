import java.util.ArrayList;

public class AlgorithmeBase {

    public static boolean findAnagramsBaseAlgo(String word, String dictWord) {

    	boolean trouve;
		//debut de l'algo selon le pseudocode
		
		for (int i = 0; i < word.length(); i++){
		    char c1 = word.charAt(i);
		    trouve = false;
		    
		    for (int j = 0; j < dictWord.length() && trouve == false; j++){
		        char c2 = dictWord.charAt(j);        
		        
		        if(c1 == c2) {
		        	dictWord = dictWord.substring(0, j) + dictWord.substring(j+1);
		        	trouve = true;
		        }
		    }
		    if(trouve == false) {
		    	return false;
		    }
		}
		
		if(dictWord.length() != 0) {
			return false;
		}
		
		return true;
	}
	
}

