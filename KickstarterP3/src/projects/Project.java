package projects;

import java.util.ArrayList;
import enums.Categories;
import enums.Country;
import enums.Status;
import users.Backer;

public class Project {
	private String name;
	private String description;
	private String owner;
	private Categories category;
	private Country country;
	private int goal;
	private ArrayList<Backer> backers = new ArrayList<Backer>();
	int collected = 0;
	private Status status = Status.PRIVATE;
	
	public Project(String name, String description, Categories category, Country country, int goal, String owner) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.country = country;
		this.goal = goal;
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int getCollected() {
		return collected;
	}


	public void addCollected(int collected) {
		this.collected += collected;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Backer> getBackers() {
		return backers;
	}


	public void setBackers(ArrayList<Backer> backers) {
		this.backers = backers;
	}
	
	public int getGoal() {
		return goal;
	}


	public void setGoal(int goal) {
		this.goal = goal;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	public void toBeReviewed()
	{
		this.status = Status.UNDER_REVIEW;
		System.out.println("The project " + this.name + " is now under review.");
	}
	
	public void aproveProject()
	{
		this.status =  Status.PUBLIC;
		System.out.println("The project " + this.name + " is public.");
	}
	
	public void closeProject()
	{
		this.status = Status.ENDED;
		System.out.println("The project " + this.name + " is now closed.");
	}

	@Override
	public String toString() {
		return "Projects [name: " + name + ", description: " + description + ", category: " + category + ", country: "
				+ country + " goal: " + goal + "]";
	}
	
	public void backersListnAmount()
	{
		if(this.backers.size() == 0)
			System.out.println("There are no backers for this project yet");
		else
			System.out.println("People who backed " + this.name + ":");
			for (int i = 0; i < this.backers.size(); i++) {
				System.out.println(this.backers.get(i).getName() + " backed the amount of:  " +this.backers.get(i).getBackedAmount());
			}
			System.out.println("Total amount collected: " + this.collected);
	}









}
