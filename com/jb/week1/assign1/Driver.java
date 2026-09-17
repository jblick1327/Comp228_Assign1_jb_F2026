package com.jb.week1.assign1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.jb.week1.assign1.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        System.out.println("Make a selection...\n-------------");
        System.out.println("(1) convert grades");
        System.out.println("(2) convert miles to kilometres");
        System.out.println("(3) convert litres to gallons");
        System.out.println("(4) convert CAD to USD");

        Scanner scanner = new Scanner(System.in);
        int selection = 0;
        while (selection < 1 || selection > 4) {
            try {
                selection = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(e.toString());
                System.out.println("Try again...");
                scanner.next();
            }
        }

        Util currentUtility;
        if (selection == 1) {
            currentUtility = new GradeCalculation();
        } else if (selection == 2) {
            currentUtility = new MilesToKilometres();
        } else if (selection == 3) {
            currentUtility = new LitresToGallons();
        } else {
            currentUtility = new CADToUSD();
        }

        try {
            scanner.nextLine();
            boolean success = false;
            while (!success) {
                currentUtility.printInputString();
                String input = scanner.nextLine();
                success = currentUtility.processInputAndPrintOutputString(input);
                if (!success) {
                    System.out.println("Try again...");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
