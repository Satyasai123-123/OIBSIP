import java.util.Scanner;
import java.util.Random;

// Game class
class Game {
	
	int systemInput;
	int userInput;
	int noOfGuesses = 0;
	
	// generating random number in default constructor
	Game() {
		Random random = new Random();
		this.systemInput = random.nextInt(100) + 1;
	}
	
	
	// method to take user guesses
	public boolean takeUserInput() {
		if ( noOfGuesses < 10 ) {
			System.out.print("Guess the number : ");
			this.userInput = GuessTheNumber.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...Better luck next time\n");
			return true;
		}
	}
	
	
	public boolean isCorrectGuess() {
		
		if ( systemInput == userInput ) {
			System.out.println("Congratulations, you guess the number " + systemInput +
			" in " + noOfGuesses + " guesses");
			System.out.println("Your score is "+(10-(noOfGuesses-1))*10);
			System.out.println();
			return true;
		}
		else if ( noOfGuesses < 10 && userInput > systemInput ) {
			if ( userInput - systemInput > 10 ) {
				System.out.println("Too High");
			}
			else {
				System.out.println("Little High");
			}
		}
		else if ( noOfGuesses < 10 && userInput < systemInput ) {
			if ( systemInput - userInput > 10 ) {
				System.out.println("Too low");
			}
			else {
				System.out.println("Little low");
			}
		}
		return false;
	}
}

// main class
public class GuessTheNumber {
	
	// static method to take integer input without any limit and exception error
	// exception handling and input limit handling
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	// main method
	public static void main(String[] args) {
		
		// input for start the game
		System.out.println();
		System.out.println("\t\t - - - - - - - - - - - - - - - - - - - -");
		System.out.println("\t\t|\tWELCOME TO NUMBER GUESSING GAME\t|");
		System.out.println("\t\t - - - - - - - - - - - - - - - - - - - -");
		System.out.println("\t\t* * * * * * * * * * * * * * * * * * * * *");
		System.out.println("\t\t|\t1.START THE GAME  \t\t|");
		System.out.println("\t\t|\t2.Exit           \t\t|");
		System.out.println("\t\t* * * * * * * * * * * * * * * * * * * * *");
		System.out.println();
		System.out.print("Enter your choice : ");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
			
			// to check next round is there or not
			while ( nextRound == 1 ) {
				// creating object of Game class
				Game game = new Game();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound " + ++noOfRound + " starts...");
				System.out.println("******You have 10 Chances******");
				
				// to check correct guess and limit cross
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.takeUserInput();
					isMatched = game.isCorrectGuess();
				}
				// input for next round
				System.out.println("1. Next Round \n2. Exit");
				System.out.println("Enter your choice : ");
				nextRound = takeIntegerInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}