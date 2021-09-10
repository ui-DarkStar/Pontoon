package pontoon;

import java.util.Scanner;

public class Tutorial_1 {
	
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		String choice ="";
		System.out.println("Do you wish to continue y/n?");
		choice = kboard.next();
		while (choice.equalsIgnoreCase("y"))
		{
			System.out.println("Hello");
			System.out.println("Do you wish to continue y/n?");
			choice = kboard.next();
		}
		System.out.println("Bye");
	}

}
