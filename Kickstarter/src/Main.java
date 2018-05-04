import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		int control = 1;
		User user = null;
		System.out.println("Welcome to Kickstarter!");
		do {
			System.out.println("Enter the number of the wanted action:");
			System.out.println("1- Create a new user");
			System.out.println("2- Login");
			System.out.println("0- Close Kickstarter");
			control = input.nextInt();
			switch (control) {
			case 1:
				users.add(User.newUser(users));
				break;
			case 2:
				user = User.login(users);
				break;
			default:
				break;
			}
		
		
		
		} while (control != 0);
		input.close();
	}
	
}
