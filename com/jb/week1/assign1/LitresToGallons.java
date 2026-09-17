package com.jb.week1.assign1;

public class LitresToGallons implements Util {
    private static double convert(double litres) {
        double conversionFactor = 0.264172;
        return litres * conversionFactor;
    }

    @Override
    public void printInputString() {
        System.out.println("Enter volume in litres...");
    }

    @Override
    public boolean processInputAndPrintOutputString(String input) {
        double litres;
        try {
            litres = Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        double gallons = convert(litres);
        System.out.printf("%.2fL converts to %.2fgal\n", litres, gallons);
        return true;
    }
}
