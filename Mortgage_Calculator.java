

import java.text.NumberFormat;

public class Mortgage_Calculator {

    //Main Section
    public static void main(String[] args) {
        int principal = (int) console.readNumber("Principal: ", 1000, 1000000);
        float annualInterest = (float) console.readNumber("Annual Interest: ", 1, 100);
        byte years = (byte) console.readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        System.out.println("That's our Mortgage Value");
        System.out.println("that's it");
    }


    //calculating results,based on input , result will be shifted to Main method at above of code

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }
}
