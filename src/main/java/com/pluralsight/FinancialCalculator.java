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
                 MortgageCalculator.calculate();
                 break;
             case 2:
                 FutureValueCalculator.calculate();
                 break;
             case 3:
                 OrdinaryAnnuity.calculate();
                 break;

             default:
                 System.out.println("Please select a valid number");
         }
    }
}
