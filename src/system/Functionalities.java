package system;
import java.util.Scanner;

import enums.OpCommand;
import exceptions.InputTreatment;
import projects.Project;
import users.Admin;
import users.Backer;
import users.User;

public class Functionalities {
	static Scanner input = new Scanner(System.in);
	
	public static void register(Database database)
	{
		database.newUser();
	}
	public static void login(Database database)
	{
		System.out.println("Enter your email:");
		String email = input.nextLine(); 
		System.out.println("Enter your password:");
		String password = input.nextLine();
		for (int i = 0; i < database.getUsers().size(); i++) {
			if(database.getUsers().get(i).getEmail().equals(email) && database.getUsers().get(i).getPassword().equals(password))
			{
				System.out.println("Login sucessfully done!");
				if(database.getUsers().get(i) instanceof Admin)
					menuAdmin(database, database.getUsers().get(i));
				else
					menu(database, database.getUsers().get(i));
				return;
			}
		}
		System.out.println("No user with the matching email and password were found. Try again.");
	}
	public static void menu(Database database, User user)
	{
		int control = 1;
		do {
			System.out.println(user.getName() + ", input your action:");
			System.out.println("[1]- Create a new project");
			System.out.println("[2]- Display my projects");			
			System.out.println("[3]- Display public projects");
			System.out.println("[4]- Edit account information");
			System.out.println("[0]- Logout");
			control = InputTreatment.inputLimitedInteger(0, 4);
			switch (control) {
			case 1:
				database.newProject(user);
				break;
			case 2:
				myProjects(database, user);
				break;
			case 3:
				publicProjects(database, user);
				break;
			case 4:
				database.editUser(user);
				break;
			default:
				break;
			}
		} while (control != 0);
	}
	public static void menuAdmin(Database database, User user)
	{
		int control = 1;
		do {
			System.out.println(user.getName() + ", input your action:");
			System.out.println("[1]- Create a new project");
			System.out.println("[2]- Display my projects");			
			System.out.println("[3]- Display public projects");
			System.out.println("[4]- Display projects to be reviewed");
			System.out.println("[5]- Edit account information");
			System.out.println("[0]- Logout");
			control = InputTreatment.inputLimitedInteger(0, 5);
			switch (control) {
			case 1:
				database.newProject(user);
				break;
			case 2:
				myProjects(database, user);
				break;
			case 3:
				publicProjects(database, user);
				break;
			case 4:
				reviewProject(database);
				break;
			case 5:
				database.editUser(user);
				break;
			default:
				break;
			}
		} while (control != 0);
	}
	public static void myProjects(Database database, User user) 
	{
		if(user.getProjects().size() == 0) {
			System.out.println("You dont have any projects created.");					
		}
		else
		{
			int i;
			int selected;
			Project project;
			System.out.println("Select the project you want:");
			for (i = 0; i < user.getProjects().size(); i++) {
				System.out.println("[" + i + "] - " + user.getProjects().get(i).toString());
			}
			selected = InputTreatment.inputLimitedInteger(0, (i - 1));
			project = user.getProjects().get(selected);
			Functionalities.myProjectMenu(project);
		}
	}
	public static void myProjectMenu(Project project) {
		int control = 1;
		do {
			System.out.println("Project Menu:");
			System.out.println(project.getName() + " - Options:");
			System.out.println("[1]- Apply project to be reviewed.");
			System.out.println("[2]- Display backers and amount donated.");			
			System.out.println("[3]- Close project");
			System.out.println("[0]- Exit project Menu");
			control = InputTreatment.inputLimitedInteger(0, 3);
			switch (control) {
			case 1:
				project.toBeReviewed();
				break;
			case 2:
				project.backersListnAmount();
				break;
			case 3:
				project.closeProject();
			default:
				break;
			}
		} while (control != 0);
		
	
	}
	public static void publicProjects(Database database, User user)
	{
		int counter = 0;
		OpCommand op = new OpCommand();
		Project project;
		boolean choice;
		for (int i = 0; i < database.getProjects().size(); i++) {
			project = database.getProjects().get(i);
			if(op.execute("3").equals(project.getStatus()))
			{
				System.out.println(project.toString() + "by: " + project.getOwner());
				System.out.println("Do you want to enter the project menu?");
				choice = InputTreatment.inputBoolean();
				if(choice)
				{
					publicProjectMenu(project, user);
				}
				++counter;
			}
		}
		if (counter == 0) {
			System.out.println("There are no public projects available");
		}
	}
	public static void publicProjectMenu(Project project, User user) {
		int control = 1;
		do {
			System.out.println("Public Projects Menu:");
			System.out.println(project.getName() + " - Options:");
			System.out.println("[1]- Back this project");
			System.out.println("[2]- Display backers and amount donated.");			
			System.out.println("[0]- Exit project Menu");
			control = InputTreatment.inputLimitedInteger(0, 2);
			switch (control) {
			case 1:
				backProject(project, user);
				break;
			case 2:
				project.backersListnAmount();
				break;
			default:
				break;
			}
		} while (control != 0);
		
	
	}
	public static void reviewProject(Database database)
	{
		Project project;
		boolean choice;
		int counter = 0;
		OpCommand op = new OpCommand();
		for (int i = 0; i < database.getProjects().size(); i++) {
			project = database.getProjects().get(i);
			if(op.execute("2").equals(project.getStatus()))
			{
				System.out.println(project.toString());
				System.out.println("Do you want to aprove this project?");
				choice = InputTreatment.inputBoolean();
				if(choice)
				{
					project.aproveProject();
				}
				++counter;
			}
		}
		if (counter == 0) {
			System.out.println("There are no projects to be reviewed.");
		}
	}
	public static void backProject(Project project, User user)
	{
		int amount;
		System.out.println("What is the amount you want to back up the project?");
		amount = InputTreatment.inputLimitedInteger(0, Integer.MAX_VALUE);
		Backer backer = new Backer(user.getName(), user.getEmail(), user.getPassword(), amount);
		project.getBackers().add(backer);
		project.addCollected(amount);
		System.out.println(user.getName() + " backed the project " + project.getName() + " with the amount of " + amount);
	}
	
}
	