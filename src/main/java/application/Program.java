package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = input.nextInt();

        for(int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char option = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = input.nextDouble();
            if(option == 'c') {
                System.out.print("Number of employees: ");
                int numberOfEmployees = input.nextInt();
                taxPayerList.add(new Company(name, anualIncome, numberOfEmployees));
            } else if (option == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = input.nextDouble();
                taxPayerList.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.println("Invalid option!");
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        for(TaxPayer taxPayer : taxPayerList) {
            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
        }
        System.out.println();
        double sum = 0.00;
        for(TaxPayer taxPayer : taxPayerList) {
            sum += taxPayer.tax();
        }
        System.out.println("TOTAl TAXES: $ " + String.format("%.2f", sum));

        input.close();

    }
}
