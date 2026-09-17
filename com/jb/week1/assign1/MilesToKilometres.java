package com.jb.week1.assign1;

public class MilesToKilometres implements Util {
    private static double convert(double miles) {
        double conversionFactor = 1.60934;
        return miles * conversionFactor;
    }

    @Override
    public void printInputString() {
        System.out.println("Enter distance in miles...");
    }

    @Override
    public boolean processInputAndPrintOutputString(String input) {
        double miles;
        try {
            miles = Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        double kilometres = convert(miles);
        System.out.printf("%.2fmi converts to %.2fkm\n", miles, kilometres);
        return true;
    }
}
