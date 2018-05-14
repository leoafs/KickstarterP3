package users;
import java.util.ArrayList;
import java.util.Scanner;

import projects.Project;


public class User {
	protected String name;
	protected String email;
	protected String password;
	protected ArrayList<Project> projects = new ArrayList<Project>();
	
	Scanner input = new Scanner(System.in);
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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



	public ArrayList<Project> getProjects() {
		return projects;
	}



	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}



	public Scanner getInput() {
		return input;
	}



	public void setInput(Scanner input) {
		this.input = input;
	} 
	
	
}