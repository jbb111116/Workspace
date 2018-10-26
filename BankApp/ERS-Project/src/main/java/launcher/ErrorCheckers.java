package launcher;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ErrorCheckers {
	public static int correctInput(int num1, int num2) {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		// Catches any errors
		while (choice < num1 || choice > num2) {
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
			}
			else {
				try {
					choice = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input");
					sc.nextLine();
				}
			}
		}
		return choice;
	}
}
