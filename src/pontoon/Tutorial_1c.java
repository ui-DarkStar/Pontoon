package pontoon;

import java.util.Scanner;

public class Tutorial_1c {

	public static int rng() {
		return (int)(Math.random()*10) +1;
	}

	public static int calcTotal(int x,int y) {
		return x+y;
	}

	public static boolean getResult(int z) {
		if (z >= 18 && z <= 21 ) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean busted(int z) {
		if (z >=22) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int house() {
		int x=0;
		while(x <= 16) {
			x = x + rng();
		}
		return x;
	}
	
	public static boolean result(int total,int house) {
		if(total > house || house > 21) {
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean draw(int total,int house) {
		if(total == house) {
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		String choice ="";
		int card1,card2,newCard,total;
		int house = house();
		card1 = rng();
		card2 = rng();
		total = calcTotal(card1,card2);
		
		//System.out.println("debug house has "+house);
		System.out.println("1st Card is: "+card1);
		System.out.println("2nd Card is: "+card2);
		System.out.println("the total is: "+total+". Do you wish to pick up a new card y/n?");
		choice = kboard.next();
		while (choice.equalsIgnoreCase("y"))
		{
			newCard = rng();
			total = calcTotal(total,newCard);

			System.out.println("Your new card is: "+newCard);
			if(busted(total)==true) {
				System.out.println("the new total is: "+total+". You are busted!!!");
				System.exit(0); //reference https://stackoverflow.com/questions/22452930/terminating-a-java-program
			}else{
				System.out.println("the new total is: "+total+". Do you wish to pick up a new card y/n?");
				choice = kboard.next();
			}
		}

		if(result(total,house)==true) {
			System.out.println("You have Won");
			System.out.println("You have "+total+" and the house has "+house);
		}else if(draw(total,house)==true) {
			System.out.println("it is a draw");
			System.out.println("You have "+total+" and the house has "+house);
		}else {
			System.out.println("You have Lost");
			System.out.println("You have "+total+" and the house has "+house);
		}

	}
}
