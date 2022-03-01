	/*
	 * Class: CMSC203 
	 * Instructor: Dr. Grinberg
	 * Description: Build an application that will receive a guess and report if your guess is the random number that was generated.  Your application will narrow down the choices according to your previous guesses and continue to prompt you to enter until you guess correctly.
	 * Due: 2/28/2022
	 * Platform/compiler: eclipse/repl.it
	 * I pledge that I have completed the programming assignment independently.
	   I have not copied the code from a student or any source.
	   I have not given my code to any student.
	   William Tiwari
	*/


import java.util.Scanner;
public class RandomNumberGuesser {
	
	public static void main(String[] args) {
		RNG randNum = new RNG();
		Scanner key = new Scanner(System.in);
		String answer = "yes";
		int nextGuess = 0;
		int lowGuess = 0;
		int highGuess = 99;
	

		
		System.out.println("========== Random Number Game ===========\n");
		//call RNG class method and store the int returned in the rand variable 
		int number = randNum.rand();
		
		//print the random number for the test run 
		//System.out.println(number);
		
		//prompt for input
		System.out.println("Enter your first guess");	
		
		//reset count
		randNum.resetCount();
		
		//do-while loop 
		do {
			
			nextGuess = key.nextInt();
			
			//while loop for input validation 
			while(!randNum.inputValidation(nextGuess, lowGuess, highGuess)){
				//prompt for user and store number in the guess variable 
				System.out.println("Enter your guess");		
				nextGuess = key.nextInt();
			}
			//if else statemts for updating fields 
      		if (nextGuess > number) {
      
      			highGuess = nextGuess;
				
				System.out.println( "Your number of guesses is " + randNum.getCount() +"\n"
						+ "Your guess is too high\n"
						+ "Enter your guess between " +lowGuess + " and " + highGuess);
				
			
			}else if(nextGuess < number) {
				
				lowGuess = nextGuess;
				
				System.out.println("Your number of guesses is " + randNum.getCount() +"\n"
						+ "Your guess is too low\n"
						+ "Enter your guess between " +lowGuess + " and " + highGuess);
				
			
			} else if(nextGuess == number) {
				System.out.println("Congratulations, you guessed correctly \n"
						+ "Try again? (yes or no)");
				//clear scanner object 
				key.nextLine();
				//receive input for new round 
				answer = key.nextLine();
				if(answer.equals("yes")) {
					
					//reprint prompt for input 
					System.out.println("Enter your first guess");
					
					//reset count and values of highGuess, lowGuess, and nextGuess and generate new 
					//number
					number = randNum.rand();
					randNum.resetCount();
					nextGuess = 0;
					lowGuess = 0;
					highGuess = 99;
				}
			}
		}while(answer.equals("yes"));
		
		System.out.println("Thanks for playing...");
		
	}

}
