package Classwork;

import java.util.InputMismatchException;
import java.util.Scanner;
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}
public class Q2 {
    private double balance;
    public Q2(double initialBalance) {
        this.balance = initialBalance;
    }
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Error: Amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Error: Insufficient funds. Your balance is " + balance + "."
            );
        }

        balance -= amount;
        System.out.printf("Withdrawal successful. Remaining balance: %.2f%n", balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q2 wallet = new Q2(500);

        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            wallet.withdraw(amount);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
            scanner.nextLine(); // clear invalid input

        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println(e.getMessage());

        } finally {
            scanner.close();
        }
    }
}