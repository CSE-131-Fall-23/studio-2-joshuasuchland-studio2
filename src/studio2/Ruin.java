package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);

		// Get values from user
		System.out.println("Please enter the amount of money you start with."); 
		int startAmount = in.nextInt();	
		
		System.out.println("Please enter the percent chance to win."); 
		int winChance = in.nextInt();
		
		System.out.println("Please enter the amount you want to leave with."); 
		int winLimit = in.nextInt();
		
		System.out.println("Please enter the number of simulations."); 
		int totalSimulations = in.nextInt();
		
		
		// Play game
		int saveStartAmount = startAmount;
		int playAmount = 0;
		int ruined = 0;
		double expectedRuin = 0;
		String winOrLose = "placeholder";
		for (int count = 1; count <= totalSimulations; count = count + 1)
		{
			startAmount = saveStartAmount;
			playAmount = 0;
		while (startAmount < winLimit && startAmount > 0)
		{
			if (winChance >= (Math.random()*100.0))
			{
				startAmount = startAmount + 1;
			}
			else
			{
				startAmount = startAmount - 1;
			}
			playAmount = playAmount + 1;

		}
		boolean gameWon = startAmount == winLimit;
		if (gameWon == true)
		{
			winOrLose = "You won! You have $" + startAmount + ".";
		}
		else
		{
			winOrLose = "You lost! You have $" + startAmount + ".";
			ruined = ruined + 1;
		}
				
		System.out.println("It is day " + count + ". Today you played " + playAmount + " times. " + winOrLose);

		}
		double ruinRate = (ruined*1.0)/(totalSimulations*1.0);
		ruinRate = Math.round(ruinRate*1000.0)/10.0;
		double alpha = (1.0 - (winChance/100.0))/(winChance/100.0);
		if (winChance == 50)
		{
			expectedRuin = 1.0 - ((double)saveStartAmount)/((double)winLimit);
		}
		else
		{
			expectedRuin =  (Math.pow(alpha, saveStartAmount) - Math.pow(alpha, (double)winLimit))/(1 - Math.pow(alpha, (double)winLimit));
		}
		expectedRuin = expectedRuin*100.0;
		System.out.println("The rate of ruin is " + ruinRate + "%. The expected rate of ruin is " + expectedRuin + "%.");
			}
		
	}

