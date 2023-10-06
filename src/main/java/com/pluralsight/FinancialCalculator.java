package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : Mortgage calculator");
        System.out.println("2 : CD Calculator");
        System.out.println("3 : Annuity Calculator");
        System.out.print("Please, select which calculator would you like to use: ");

         int userInput = scanner.nextInt();

         switch (userInput) {
             case 1:
                 MortgageCalculator mortgageCalculator = new MortgageCalculator();
                 mortgageCalculator.calculate();
                 break;
             case 2:
                 FutureValueCalculator cd = new FutureValueCalculator();
                 cd.calculate();
                 break;
             case 3:
                 OrdinaryAnnuity ordinaryAnnuity = new OrdinaryAnnuity();
                 ordinaryAnnuity.calculate();
                 break;

             default:
                 System.out.println("Please select a valid number");
         }
    }
}
