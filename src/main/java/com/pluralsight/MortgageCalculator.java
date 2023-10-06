package com.pluralsight;

import java.util.Scanner;
import java.text.DecimalFormat;

public class MortgageCalculator {
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public static void calculate(){

        System.out.print("Enter the principal: $");
        double principal = USER_INPUT.nextDouble();

        System.out.print("Enter the interest rate: ");
        double interestRate = USER_INPUT.nextDouble() / 100;

        System.out.print("Enter the length of the loan in years: ");
        int loanLength = USER_INPUT.nextInt();

        double monthlyPayment = calculateMonthlyPayment(principal, interestRate, loanLength);
        double totalInterest = calculateTotalInterest(monthlyPayment, principal, loanLength);

        printResult(principal, interestRate, loanLength, monthlyPayment, totalInterest);
    }

    private static double calculateMonthlyPayment(double principal, double interestRate, int loanLength){
        interestRate /= 12;
        return principal * interestRate / (1 - Math.pow((1 + interestRate), (-1 * (loanLength * 12))));
    }

    private static double calculateTotalInterest(double monthlyPayment, double principal, int loanLength){
        return (monthlyPayment * (loanLength * 12)) - principal;
    }

    private static void printResult(double principal, double interestRate, int loanLength,
                                       double monthlyPayment, double totalInterest) {
        System.out.println("A $" + principal + " loan at " + (interestRate * 100) + "% interest for " +
                loanLength + " years would have a $" + DECIMAL_FORMAT.format(monthlyPayment) + " / month payment with " +
                "a total interest of $" + DECIMAL_FORMAT.format(totalInterest));
    }
}

