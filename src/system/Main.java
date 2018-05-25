package system;

import java.util.Scanner;

import exceptions.InputTreatment;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int control = 1;
		Database database = new Database();
		
		System.out.println("Welcome to Kickstarter!");
		do {
			System.out.println("Enter the number of the wanted action:");
			System.out.println("1- Create a new user");
			System.out.println("2- Login");
			System.out.println("0- Close Kickstarter");
			control = InputTreatment.inputLimitedInteger(0, 2);
			switch (control) {
			case 1:
				Functionalities.register(database);
				break;
			case 2:
				Functionalities.login(database);
				break;
			default:
				break;
			}
		
		} while (control != 0);
		input.close();
	}
}
