package utils;

import java.net.URI;
import java.net.URL;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStream;

public class CADToUSD implements Util {
    private static final int START_IDX = 55; // Not the *most* safe thing to do, but I don't expect the JSON response to
                                             // change format anytime soon
    private static final int BUFFER_SIZE = 80; // I do anticipate the number of decimal places potentially changes, so
                                               // making buffer size 80 not 64

    private double getCurrentRate() throws IOException {
        URL url = URI.create("https://api.frankfurter.dev/v2/rate/cad/usd").toURL();
        byte[] buff = new byte[BUFFER_SIZE];
        try (InputStream stream = url.openStream()) {
            int bytesRead = 0;
            int n = 0;
            while (bytesRead < BUFFER_SIZE) {
                n = stream.read(buff, bytesRead, BUFFER_SIZE - bytesRead);
                if (n == -1) {
                    break;
                }
                bytesRead += n;
            }
        }
        int i = START_IDX;
        while (buff[i] != '}') {
            i++;
        }
        String rate = new String(Arrays.copyOfRange(buff, START_IDX, i));
        return Double.parseDouble(rate);
    }

    private double convert(double cad) throws IOException {
        double conversionFactor = getCurrentRate();
        return cad * conversionFactor;
    }

    @Override
    public void printInputString() {
        System.out.println("Input amount in $CAD...");
    }

    @Override
    public boolean processInputAndPrintOutputString(String input) throws IOException {
        double cad;
        try {
            cad = Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        printConversion(cad);
        return true;
    }

    private void printConversion(double cad) throws IOException {
        double usd = convert(cad);
        System.out.printf("$%.2fCAD converts to $%.2fUSD\n", cad, usd);
    }

}
