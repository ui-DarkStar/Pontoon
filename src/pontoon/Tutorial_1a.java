package pontoon;

import java.util.Scanner;

public class Tutorial_1a {

	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		String choice ="";
		int card1 = 0;
		int card2 = 0;
		int newCard = 0;
		int total = 0;
		card1 = (int)(Math.random()*10) +1;
		card2 = (int)(Math.random()*10) +1;
		total = card1 + card2;
		System.out.println("1st Card is: "+card1);
		System.out.println("2nd Card is: "+card2);
		System.out.println("the total is: "+total+". Do you wish to pick up a new card y/n?");
		choice = kboard.next();
		while (choice.equalsIgnoreCase("y"))
		{
			newCard = (int)(Math.random()*10) +1;
			total = total + newCard;
			System.out.println("Your new card is: "+newCard);
			System.out.println("the new total is: "+total+". Do you wish to pick up a new card y/n?");
			choice = kboard.next();
		}
		if(total>=19 && total<=21) {
			System.out.println("You have Won");
		}else {
			System.out.println("You have Lost");
			
		}
	}

}
