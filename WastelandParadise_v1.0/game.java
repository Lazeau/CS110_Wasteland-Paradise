import java.util.Scanner;
import java.io.FileNotFoundException;

public class game {
	
	public static int select() {
		Scanner in = new Scanner(System.in);
		String choice = null;
		int selection = 0;
		
		System.out.print("> ");
		choice = in.nextLine();
		selection = Integer.parseInt(choice);
		
		if (selection != 0) {
			return selection;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		
		boolean playing = true;
		int selection = 0; // Used with the select() method to navigate through menus
		
		while (playing == true) {
			// Main menu for the game
			System.out.println("Welcome to Wasteland Paradise!");
			System.out.println("\nWould you like to start a new game, or continue a saved one?");
			System.out.println("Enter the number of the option you would like to select.");
			System.out.println("If this is your first time playing, please try the tutorial!");
			System.out.println("\n\t\tNEW GAME\t(1)"
					+ "\n\t\tCONTINUE\t(2)"
					+ "\n\t\tTUTORIAL\t(3)"
					+ "\n\t\tQUIT\t\t(4)");
			selection = select();
			
			// Set of if-else statements to execute player's selection on the main menu
			if (selection == 1) {
				// Start a new game
				System.out.println("You chose to start a new game!");
				WastelandParadise game = new WastelandParadise(selection);
				
			} else if (selection == 2) {
				// Load a saved game
				System.out.println("You chose to continue a saved game!");
				WastelandParadise game = new WastelandParadise(selection);
				
			} else if (selection == 3) {
				// Run the tutorial
				System.out.println("Loading tutorial...\n\n\n");
				Tutorial tutorial = new Tutorial();
				
			} else if (selection == 4) {
				System.out.println("quit");
				playing = false;
				break;
			} else {
				System.out.println("ERROR: Invalid input! Terminating program...");
				playing = false;
				break;
			}
			
			// Handle player decision when game ends
			System.out.println("GAME OVER"
					+ "\n\nReturn to main menu?"
					+ "\n\t(1) Yes, return to main menu"
					+ "\n\t(2) No, quit game");
			selection = select();
			if (selection == 1) {
				playing = true;
			} else if (selection == 2) {
				System.out.println("TERMINATED");
				playing = false;
			} else {
				System.out.println("ERROR: Invalid input! Terminating program...");
				playing = false;
				break;
			}
			
		}
		
		in.close();
	}
	
}
