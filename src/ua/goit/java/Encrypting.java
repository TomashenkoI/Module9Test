package ua.goit.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 7 on 31.03.2016.
 */
public class Encrypting {
    public static StringBuilder encryptedBuilder(int shiftOfLetter, List<String> directory) {
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

        HashMap<Character, Character> shiftedAlphabetSmallLetters = new HashMap();
        for (int a = 0; a < alphabetSmallLetters.size(); a++) {
            shiftedAlphabetSmallLetters.put(alphabetSmallLetters.get(a), shiftingAlphabetSmallLetters.get(a));
        }
        HashMap<Character, Character> shiftedAlphabetCapitalLetters = new HashMap();
        for (int a = 0; a < alphabetCapitalLetters.size(); a++) {
            shiftedAlphabetCapitalLetters.put(alphabetCapitalLetters.get(a), shiftingAlphabetCapitalLetters.get(a));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < directory.size(); i++) {
            builder.append("\t"+directory.get(i) + "\n");
        }

        TextEditing.textEditing(builder,alphabetSmallLetters,shiftedAlphabetSmallLetters,alphabetCapitalLetters, shiftedAlphabetCapitalLetters);
        return builder;
    }
}