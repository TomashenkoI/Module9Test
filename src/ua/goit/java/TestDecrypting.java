package ua.goit.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7 on 07.04.2016.
 */
public class TestDecrypting {

    @Test(timeout = 1000)
    public void testEncrypting () {
        ArrayList<String> directory = new ArrayList<>();
        directory.add("Stairway to heaven");
        directory.add("Smoke on the water");
        directory.add("Nothing else matters");
        directory.add("photo1");
        directory.add("photo2");
        directory.add("referat");

        List<Character> alphabetSmallLetters = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetSmallLetters.add(c);
        }

        List<Character> alphabetCapitalLetters = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabetCapitalLetters.add(c);
        }

        StringBuilder directory1 = new StringBuilder();
        for (int i = 0; i < directory.size(); i++) {
            directory1.append(directory.get(i));
        }
        StringBuilder directoryBeforeEncrypting = new StringBuilder();
        for (int i = 0; i < directory1.length(); i++) {
            char CharFromTheText = directory1.charAt(i);
            for (int y = 0; y < alphabetCapitalLetters.size(); y++) {
                if (CharFromTheText == alphabetCapitalLetters.get(y)) {
                    directoryBeforeEncrypting.append(CharFromTheText);
                }
            }
            for (int y = 0; y < alphabetSmallLetters.size(); y++) {
                if (CharFromTheText == alphabetSmallLetters.get(y)) {
                    directoryBeforeEncrypting.append(CharFromTheText);
                }
            }
        }

        StringBuilder builder = Encrypting.encryptedBuilder(4, directory);
        builder = Decrypting.decryptedBuilder(4, directory);

        StringBuilder directory2 = new StringBuilder();
        for (int i = 0; i < builder.length(); i++) {
            directory2.append(builder.charAt(i));
        }
        StringBuilder directoryAfterDecrypting = new StringBuilder();
        for (int i = 0; i < directory2.length(); i++) {
            char CharFromTheText = directory2.charAt(i);
            for (int y = 0; y < alphabetCapitalLetters.size(); y++) {
                if (CharFromTheText == alphabetCapitalLetters.get(y)) {
                    directoryAfterDecrypting.append(CharFromTheText);
                }
            }
            for (int y = 0; y < alphabetSmallLetters.size(); y++) {
                if (CharFromTheText == alphabetSmallLetters.get(y)) {
                    directoryAfterDecrypting.append(CharFromTheText);
                }
            }
        }

        Assert.assertEquals("\t"+directoryBeforeEncrypting, "\t"+directoryAfterDecrypting);
    }

//    public StringBuilder builderMakingForTheComparison(StringBuilder directory, List<Character> alphabetSmallLetters, List<Character> alphabetCapitalLetters){
//        for (int i = 0; i < directory.length(); i++) {
//            char CharFromTheText = directory.charAt(i);
//            for (int y = 0; y < alphabetCapitalLetters.size(); y++) {
//                if (CharFromTheText == alphabetCapitalLetters.get(y)) {
//                    builderMakingForTheComparison(directory,alphabetCapitalLetters,alphabetCapitalLetters).append(CharFromTheText);
//                }
//            }
//            for (int y = 0; y < alphabetSmallLetters.size(); y++) {
//                if (CharFromTheText == alphabetSmallLetters.get(y)) {
//                    builderMakingForTheComparison(directory,alphabetCapitalLetters,alphabetCapitalLetters).append(CharFromTheText);
//                }
//            }
//        } return builderMakingForTheComparison(directory,alphabetCapitalLetters,alphabetCapitalLetters);
//    }
}


