package exceptions;

public class IntegerOutOfBound extends Exception {
	private int bottom;
	private int upper;
	
	public IntegerOutOfBound(int bottom, int upper) {
		super();
		this.bottom = bottom;
		this.upper = upper;
	}

	@Override
	public String toString() {
		return "IntegerOutOfBound: the integer inputted was not between bottom = " + bottom + " and upper = " + upper;
	}


}
