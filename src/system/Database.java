package system;
import java.util.ArrayList;
import java.util.Scanner;

import enums.Categories;
import enums.Country;
import enums.OpCommand;
import exceptions.InputTreatment;
import projects.Project;
import users.Admin;
import users.User;

public class Database {
	ArrayList<User> users;
	ArrayList<Project> projects;
	
	Scanner input = new Scanner(System.in);


	public Database() {
		super();
		this.users = new ArrayList<User>();
		this.users.add(new Admin("Carlos", "chta@ic.ufal.br", "password"));
		this.projects = new ArrayList<Project>();
		
	}


	public void newUser()
	{
		String name = new String(); 
		String email = new String(); 
		String password = new String(); 
		
		System.out.println("Type your name:");
		name = input.nextLine();
		
		System.out.println("Type your email:");
		email = input.nextLine();
		for (int i = 0; i < users.size(); i++) {
			if(this.users.get(i).getEmail().equals(email))
			{
				System.out.println("There is already an account wiht the given email. Please input a valid email:");
				email = input.nextLine();
			}	
		}
		
		System.out.println("Type your password:");
		password = input.nextLine();
		this.users.add(new User(name, email, password));

	}
	
	public void editUser(User user)
	{
		boolean control;
		System.out.println("Do you want to change your name?");
		control = InputTreatment.inputBoolean();
		if(control)
		{
			System.out.println("Input your new name:");
			user.setName(input.nextLine());
			System.out.println("Your name now is " + user.getName());
		}
		System.out.println("Do you want to change your email?");
		control = InputTreatment.inputBoolean();
		if(control)
		{
			System.out.println("Input your new email:");
			user.setEmail(input.nextLine());
			System.out.println("Your email now is " + user.getEmail());
		}
		System.out.println("Do you want to change your password?");
		control = InputTreatment.inputBoolean();
		if(control)
		{
			System.out.println("Input your new password:");
			user.setPassword(input.nextLine());
			System.out.println("Password changed sucessfully");
		}
	}
	
	
	public void newProject(User user)
	{
		String name = new String(); 
		String description = new String(); 
		int goal;
		int country; 
		int category; 
		Project project;
		
		System.out.println("Type the name of your project:");
		name = input.nextLine();
			
		System.out.println("Give us a descripton of what your project is:");
		description = input.nextLine();
			
		System.out.println("Inform how much your project needs to be found:");
		goal = InputTreatment.inputLimitedInteger(0, Integer.MAX_VALUE);
			
		System.out.println("Select the number which represents your country:");
		for (Country c : Country.values()) {
			System.out.println("["+ c.ordinal() + "] - " + c);
		}
		country = InputTreatment.inputLimitedInteger(0, 20);//Country Enum limitations
	
		System.out.println("Select the category of your project:");
		for(Categories c : Categories.values())
		{
			System.out.println("["+ c.ordinal() + "] - " + c);
		}
		category = InputTreatment.inputLimitedInteger(0, 14);//Category Enum limitations
	
		project = new Project(name, description, Categories.getCategory(category), Country.getCountry(country), goal, user.getName());
		this.projects.add(project);
		user.getProjects().add(project);
		System.out.println("Projeto criado com sucesso");
	}


	public ArrayList<User> getUsers() {
		return users;
	}

	
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}


	public ArrayList<Project> getProjects() {
		return projects;
	}


	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}




}
