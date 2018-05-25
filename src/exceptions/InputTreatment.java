package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputTreatment {
	static Scanner input = new Scanner(System.in);
	
	public static boolean inputBoolean()
	{
		try
		{
			System.out.println("Input [true] or [false]:");
			boolean b = input.nextBoolean();
			return b;
		}
		catch (InputMismatchException e) {
			System.err.println("You must input true or false. Please try again.");
			input.nextLine();
			return inputBoolean();
		} 
	}

	public static int inputInteger()
	{
		try
		{
			System.out.println("Input a integer number:");
			int i = input.nextInt();
			return i;
		}
		catch (InputMismatchException e) {
			System.out.println("You must input a integer. Please try again.");
			input.nextLine();
			return inputInteger();
		} 
	}
	public static int inputLimitedInteger(int bottom, int upper)	{
		try
		{
			System.out.println("Input a integer number:");
			int i = input.nextInt();
			if(i < bottom ||  i > upper)
				throw new IntegerOutOfBound(bottom, upper);
			return i;
		}
		catch (InputMismatchException e) {
			System.err.println("You must input a integer. Please try again.");
			input.nextLine();
			return inputLimitedInteger(bottom, upper);
		} 
		catch (IntegerOutOfBound e) {
			System.err.println(e.toString() + ". Please try again.");
			input.nextLine();
			return inputLimitedInteger(bottom, upper);
		}
	}


}
