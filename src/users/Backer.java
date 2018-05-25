package users;

public class Backer extends User{
	protected int backedAmount;
	public Backer(String name, String email, String password, int backedAmount) {
		super(name, email, password);
		this.backedAmount = backedAmount;
	}
	public int getBackedAmount() {
		return backedAmount;
	}
	public void setBackedAmount(int backedAmount) {
		this.backedAmount = backedAmount;
	}
	
}
