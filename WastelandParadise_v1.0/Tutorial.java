import java.util.Scanner;

public class Tutorial {
	private int selection = 0;
	
	// The default constructor for the Tutorial object; it does not require any arguments
	Tutorial() {
		runTutorial();
	}
	
	public void runTutorial() {
		System.out.println("Welcome to Wasteland Paradise!");
		System.out.println("This is a text-based post-apocalyptic game. It is fairly simple to play.");
		System.out.println("When prompted, enter the number of the option you wish to"
				+ "select. Simple enough?"
				+ "\n\t(1) Yes!"
				+ "\n\t(2) No, what's happening? Why does this game have such a lame name?!");
		selection = select();
		
		if (selection == 1) {
			System.out.println("Great! I will tell you a bit about this world, then.\n\n");
			introLore();
		} else if (selection == 2) {
			System.out.println("I can't think of a better name...\nIt would also be a pain to move all this to a new Eclipse project.\n\n");
			runTutorial();
		} else {
			System.out.println("This is not hard, I promise.\n\n");
			runTutorial();
		}
	}
	
	private void introLore() {
		System.out.println("In 2018, the world saw the creation of political bots from a CS 110 course.");
		System.out.println("These bots inevitably caused political turmoil -- flame wars on Twitter sparked wars in the real world.");
		System.out.println("After the fall of President Pepe in 2077, the world spiraled toward nuclear war.");
		System.out.println("Now, the year is 2456, and the planet still has yet to see any real order return to it.");
		System.out.println("This is where your story begins! You can do whatever you want in this world, within the parameters of the imagination of a freshman Physics major at WVU.");
		System.out.println("\t(1) Okay. What else do I need to know?"
				+ "\n\t(2) Where are the microtransactions?!");
		selection = select();
		
		if (selection == 1) {
			System.out.println("\n\n");
			introMechanics();
		} else if (selection == 2) {
			System.out.println("To learn this information, plese pay $0.99 to the creator of the game, Matthew Lazo.\n\n");
			introLore();
		} else {
			introLore();
		}
	}
	
	private void introMechanics() {
		System.out.println("There are a few things you will need to know about the game.");
		System.out.println("First, you will choose your adventure by picking options when prompted.");
		System.out.println("Second, there is some rudamentary combat in this game. It is turn-based, and you will select options to pick what to do while fighting.");
		System.out.println("Finally, there is also an option to save your game! This will be done by saving your character data to a .txt file in a specific format. Do not change this file!");
		System.out.println("That is all! Are you ready to play?");
		System.out.println("\t(1) Yes!"
				+ "\n\t(2) No!");
		selection = select();
		
		if (selection == 1) {
			System.out.println("Hooray! Good luck!");
		} else if (selection == 2) {
			System.out.println("Okay, I will go over what you will need to know once more.");
			introMechanics();
		} else {
			introMechanics();
		}
	}
	
	private int select() {
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
}
