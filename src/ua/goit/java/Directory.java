package ua.goit.java;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by 7 on 24.03.2016.
 */
public class Directory {
    public static void main(String[] args) {

        ArrayList<String> directory = new ArrayList<>();
        directory.add("Stairway to heaven");
        directory.add("Smoke on the water");
        directory.add("Nothing else matters");
        directory.add("photo1");
        directory.add("photo2");
        directory.add("referat");


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of shifting, <= 26");

        String inputedShiftOfLetter = scanner.nextLine();
        int shiftOfLetter = Integer.parseInt(inputedShiftOfLetter);

        if (shiftOfLetter <= 26 && shiftOfLetter > 0) {
            System.out.println();
            System.out.println("Files in the directory: ");
            System.out.println();

            for (String d : directory){
                System.out.println(d);
            }
            System.out.println();
            System.out.println("Encrypted text:");
            System.out.println();
            StringBuilder encryptedBuilder = Encrypting.encryptedBuilder(shiftOfLetter, directory);
            System.out.println(encryptedBuilder);

            System.out.println();
            System.out.println("Decrypted text:");
            System.out.println();
            StringBuilder decryptedBuilder = Decrypting.decryptedBuilder(shiftOfLetter, directory);
            System.out.println(decryptedBuilder);

        } else{
            System.out.println("Error: number should be less than 25 and more than 0!");
        }
    }
}