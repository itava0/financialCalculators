package com.pluralsight;
//imports
import java.util.*;
import java.text.*;

public class OrdinaryAnnuity {
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public static void calculate(){

        System.out.print("Enter the monthly payout $: ");
        double monthly_payout = USER_INPUT.nextDouble();

        System.out.print("Enter the expected interest rate %: ");
        double interest_rate = USER_INPUT.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = USER_INPUT.nextInt();

        double present_value = calculateValue(monthly_payout, interest_rate, years);


        System.out.println("To fund an annuity that pays $" + monthly_payout + " monthly for " +
                years + " years and earns an expected " + interest_rate + "% interest, you " +
                "would need to invest $" + DECIMAL_FORMAT.format(present_value) + " today.");
    }


    public static double calculateValue(double payment, double interest, int years){
        double present = 0.0;

        interest /= 1200;
        present = payment * (( 1 - Math.pow((1 + interest), (-1 * (years * 12)))) / interest);
        return present;
    }
}

