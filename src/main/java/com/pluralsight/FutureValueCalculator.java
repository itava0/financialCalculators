package com.pluralsight;

import java.util.Scanner;
import java.text.DecimalFormat;

public class FutureValueCalculator {
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public static void calculate(){
        System.out.print("Enter the deposit amount for the CD: $");
        double deposit = getValidDouble();
        System.out.print("Enter the interest rate: ");
        double interestRate = getValidDouble() / 100;
        System.out.print("Enter the number of year for it to mature: ");
        int years = getValidInt();

        CDInvestment cd = new CDInvestment(deposit, interestRate, years);
        double futureValue = cd.calculateFutureValue();
        double totalInterest = cd.calculateTotalInterest();

        System.out.println("If you deposit $" + deposit + " in a CD that earns " +
                interestRate + "% interest and matures in " + years + "years, " +
                "your CD's ending balance will be $" + DECIMAL_FORMAT.format(futureValue) +
                " and you will have earned $" + DECIMAL_FORMAT.format(totalInterest) +
                " in interest.");
    }

    private static double getValidDouble() {
        while (!USER_INPUT.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            USER_INPUT.next();
        }
        return USER_INPUT.nextDouble();
    }

    private static int getValidInt() {
        while (!USER_INPUT.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            USER_INPUT.next();
        }
        return USER_INPUT.nextInt();
    }
}

class CDInvestment {
    private final double deposit;
    private final double interestRate;
    private final int years;

    public CDInvestment(double deposit, double interestRate, int years) {
        this.deposit = deposit;
        this.interestRate = interestRate;
        this.years = years;
    }

    public double calculateFutureValue() {
        double futureValue = deposit * Math.pow((1 + interestRate), years);
        System.out.println(futureValue);
        return futureValue;
    }

    public double calculateTotalInterest() {
        return calculateFutureValue() - deposit;
    }
}
