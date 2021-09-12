package pontoon;

import java.util.Scanner;

public class Tutorial_1d {

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

	public static void houseBusted(int z) {
		if (z >=22) {
			System.out.print(" and the house has busted with: "+z);
		}else {
			System.out.print(" and the house has: "+z);
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

	public static void drawnCards(int userCards[]) {
		System.out.print("The cards you have drawn are: ");
		for (int i = 0;i<10;i++) {
			if (userCards[i]!=0) {
				if (i==0) {
					System.out.print(userCards[i]);
				}else {
					System.out.print(","+userCards[i]);
				}
			}
		}
		System.out.println();
	}

	public static int debug(int x,int y) {
		if (x == 1) {
			return 1;
		}else if (x == 2) {
			return 21;
		}else if (x == 3) {
			return 22;
		}else {
			return y;
		}
	}

	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		String choice ="";
		int debugHouse = 2;//0 = disabled| 1 = set house to 1| 2 = set house to 21| 3 = set house to 22.
		int debugUser = 2;//0 = disabled| 1 = set total to 1| 2 = set total to 21| 3 = set total to 22.
		int total;
		int cardNum = 2;
		int userCards[] = new int[10];
		int house = house();
		userCards[0] = rng();
		userCards[1] = rng();
		total = calcTotal(userCards[0],userCards[1]);

		//System.out.println("debug house has "+house);
		System.out.println("1st Card is: "+userCards[0]);
		System.out.println("2nd Card is: "+userCards[1]);
		System.out.println("the total is: "+total+". Do you wish to pick up a new card y/n?");
		choice = kboard.next();
		while (choice.equalsIgnoreCase("y"))
		{
			userCards[cardNum] = rng();
			total = calcTotal(total,userCards[cardNum]);

			System.out.println("Your new card is: "+userCards[cardNum]);
			cardNum ++;
			if(busted(total)==true) {
				System.out.println("the new total is: "+total+". You are busted!!!");
				System.exit(0); //reference https://stackoverflow.com/questions/22452930/terminating-a-java-program
			}else{
				System.out.println("the new total is: "+total+". Do you wish to pick up a new card y/n?");
				choice = kboard.next();
			}
		}
		house = debug(debugHouse,house);
		total = debug(debugUser,total);
		if(result(total,house)==true) {
			System.out.println("You have Won");
			drawnCards(userCards);
			System.out.print("You have "+total);
			houseBusted(house);
			//System.out.println("You have "+total+" and the house has "+house);
		}else if(draw(total,house)==true) {
			System.out.println("it is a draw");
			drawnCards(userCards);
			System.out.print("You have "+total);
			houseBusted(house);
			//System.out.println("You have "+total+" and the house has "+house);
		}else {
			System.out.println("You have Lost");
			drawnCards(userCards);
			System.out.print("You have "+total);
			houseBusted(house);
			//System.out.println("You have "+total+" and the house has "+house);
		}

	}
}
