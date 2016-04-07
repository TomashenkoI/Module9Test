package ua.goit.java;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 7 on 31.03.2016.
 */
public class TextEditing {
    public static void textEditing(StringBuilder builder, List<Character> alphabetSmallLetters, HashMap<Character, Character> shiftedAlphabetSmallLetters, List<Character> alphabetCapitalLetters, HashMap<Character, Character> shiftedAlphabetCapitalLetters){
        for (int i = 0; i < builder.length(); i++) {
            char charFromTheText = builder.charAt(i);
            for (int y = 0; y < alphabetSmallLetters.size(); y++) {
                if (charFromTheText == alphabetSmallLetters.get(y)) {
                    builder.setCharAt(i, shiftedAlphabetSmallLetters.get(charFromTheText));
                }
                if (charFromTheText == alphabetCapitalLetters.get(y)) {
                    builder.setCharAt(i, shiftedAlphabetCapitalLetters.get(charFromTheText));
                }
            }
        }
    }
}