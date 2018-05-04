import java.util.ArrayList;
import java.util.Scanner;


public class User {
	private String name;
	private String email;
	private String password;
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public static User newUser(ArrayList<User> users)
	{
		Scanner scanner = new Scanner(System.in);
		
		String name = new String(); 
		String email = new String(); 
		String password = new String(); 
		
		System.out.println("Type your name:");
		name = scanner.nextLine();
		
		System.out.println("Type your email:");
		email = scanner.nextLine();
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equals(email))
			{
				System.out.println("There is already an account wiht the given email. Please try again");
				email = scanner.nextLine();
				//scanner.close();
				return null;
			}	
		}
		
		System.out.println("Type your password:");
		password = scanner.nextLine();
		
		//scanner.close();
		return new User(name, email, password);
	}
	public static User login(ArrayList<User> users)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your email:");
		String email = input.nextLine(); 
		System.out.println("Enter your password:");
		String password = input.nextLine();
		//input.close();
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password))
			{
				System.out.println("Login sucessfully done!");
				return users.get(i);
			}
		}
		System.out.println("No user with the matching email and password were found. Try again.");
		return null; 
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
