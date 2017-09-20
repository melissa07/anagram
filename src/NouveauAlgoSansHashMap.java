import java.io.*;
import java.util.Arrays;

/**
 * Created by Mon-PC on 2017-09-20.
 */
public class NouveauAlgoSansHashMap {

    public static boolean findAnagramsWithoutHashmap(String word, String dictWord){

        if(word.length() == dictWord.length())
        {
            char[] listOfCharInWord = word.toCharArray();
            char[] listOfCharInDictWord = dictWord.toCharArray();

            Arrays.sort(listOfCharInWord);
            Arrays.sort(listOfCharInDictWord);

            for(int i = 0 ; i < word.length() ; i++){
                if(listOfCharInWord[i] != listOfCharInDictWord[i]){
                    return false;
                }
            }
        }
        else
        {
            return false;
        }

        return true;
    }
}
