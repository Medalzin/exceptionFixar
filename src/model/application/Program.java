package model.application;

import model.entities.Account;
import model.exceptions.BussinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Titular: ");
        String holder = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = scanner.nextDouble();
        System.out.print("Limite de saque: ");
        double withdrawLimite = scanner.nextDouble();

        Account conta = new Account(number, holder, balance, withdrawLimite);

        System.out.println();
        System.out.print("Informe uma quantia para sacar: ");
        double amount = scanner.nextDouble();

        try{
            conta.withdraw(amount);
            System.out.println("Novo Saldo: " + String.format("%.2f", conta.getBalance()));
        }
        catch (BussinessException e){
            System.out.println(e.getMessage());
        }

        scanner.close();

    }
}
