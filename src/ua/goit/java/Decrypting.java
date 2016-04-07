package ua.goit.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 7 on 31.03.2016.
 */
public class Decrypting {
    public static StringBuilder decryptedBuilder(int shiftOfLetter, List<String> directory) {
        List<Character> alphabetSmallLetters = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetSmallLetters.add(c);
        }

        List<Character> alphabetCapitalLetters = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabetCapitalLetters.add(c);
        }
        HashMap<Integer, Character> shiftingAlphabetSmallLetters = new HashMap();
        for (int a = 0; a < alphabetSmallLetters.size(); a++) {
            if ((a + shiftOfLetter) < alphabetSmallLetters.size()) {
                shiftingAlphabetSmallLetters.put(a, alphabetSmallLetters.get(a + shiftOfLetter));
            } else {
                shiftingAlphabetSmallLetters.put(a, alphabetSmallLetters.get((a - alphabetSmallLetters.size()) + shiftOfLetter));
            }
        }

        HashMap<Integer, Character> shiftingAlphabetCapitalLetters = new HashMap();
        for (int a = 0; a < alphabetCapitalLetters.size(); a++) {
            if ((a + shiftOfLetter) < alphabetCapitalLetters.size()) {
                shiftingAlphabetCapitalLetters.put(a, alphabetCapitalLetters.get(a + shiftOfLetter));
            } else {
                shiftingAlphabetCapitalLetters.put(a, alphabetCapitalLetters.get((a - alphabetCapitalLetters.size()) + shiftOfLetter));
            }
        }

        HashMap<Character, Character> unShiftedAlphabetSmallLetters = new HashMap();
        for (int a = 0; a < alphabetSmallLetters.size(); a++) {
            unShiftedAlphabetSmallLetters.put(shiftingAlphabetSmallLetters.get(a), alphabetSmallLetters.get(a));
        }
        HashMap<Character, Character> unShiftedAlphabetCapitalLetters = new HashMap();
        for (int a = 0; a < alphabetCapitalLetters.size(); a++) {
            unShiftedAlphabetCapitalLetters.put(shiftingAlphabetCapitalLetters.get(a), alphabetCapitalLetters.get(a));
        }

        StringBuilder builder = Encrypting.encryptedBuilder(shiftOfLetter, directory);

        TextEditing.textEditing(builder,alphabetSmallLetters,unShiftedAlphabetSmallLetters,alphabetCapitalLetters, unShiftedAlphabetCapitalLetters);
        return builder;
    }


}