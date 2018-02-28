import java.util.Scanner;
import java.io.*;

public class WastelandParadise {
	private Scanner in = new Scanner(System.in);
	private String playerName = "PLAYER";
	private String playerHealth = "100";
	private String playerDamage = "0";
	private String[] playerData = new String[3];
	private int selection = 0;
	
	// One constructor handles both new and saved games
	WastelandParadise(int selection) throws FileNotFoundException {
		// Start a new game
		if (selection == 1) {
			System.out.print("\nWhat will your character's name be? ");
			playerName = in.nextLine();
			
			System.out.println("Okay, we will call you " + playerName + ".");
			
			saveGame();
		
			System.out.println("STARTING GAME...");
			
			startGame();
		// Load a saved game
		} else if (selection == 2) {
			String temp = "";
			System.out.println("\nWhat is your character's name?");
			temp = in.nextLine();
			
			System.out.println("\nLOADING GAME...");
			loadGame();
			
			if (temp.equals(playerData[0])) {
				System.out.println("STARTING GAME...");
				startGame();
			} else {
				System.out.println("The name you entered did not match the data found!");
			}
		}
	}
	
	// Begin the game!
	public void startGame() throws FileNotFoundException {
		System.out.println("\nYou find yourself in Woodburn Hall."
				+ "\n\tYour name is " + playerData[0]
				+ "\n\tYour health is " + playerData[1]
				+ "\n\tYou currently deal " + playerData[2] + " damage per turn");
		System.out.println("What will you do?");
		System.out.println("\t(1) Look around the room."
				+ "\n\t(2) Leave with what you have.");
		selection = select();
		
		if (selection == 1) {
			scavenge();
			saveGame();
			startGame();
		} else if (selection == 2) {
			saveGame();
			goOutside();
		} else {
			System.out.println("It's okay, take your time.\n\n");
			startGame();
		}
	}
	
	// Look around the area for a weapon
	public void scavenge() {
		int randomNum = (int)(Math.random() * 100);
		
		System.out.println("SCAVENGING...");
		
		if (randomNum >= 0 && randomNum <= 65) {
			// Low-tier weapon
			System.out.println("You found a baseball bat that does 10 damage!");
			playerDamage = "10";
		} else if (randomNum >= 66 && randomNum <= 85) {
			// Mid-tier weapon
			System.out.println("You found a pistol that does 25 damage!");
			playerDamage = "25";
		} else if (randomNum >= 86 && randomNum <= 95) {
			// High-tier weapon
			System.out.println("You found a rifle that does 50 damage!");
			playerDamage = "50";
		} else if (randomNum >= 96 && randomNum <= 99) {
			// Legendary weapon
			System.out.println("You found a physics textbook that is massive and does 100 damage!");
			playerDamage = "100";
		} else {
			// Super-secret ultra-tier weapon!!!
			System.out.println("You found a dusty computer science textbook that does 0 damage!");
			playerDamage = "0";
			// I actually figured out how to write the load/save system from the textbook <3
		}
	}
	
	// Leave Woodburn Hall
	public void goOutside() throws FileNotFoundException {
		System.out.println("\nYou step outside and see nothing but chaos."
				+ "\n\tYour name is " + playerName
				+ "\n\tYour health is " + playerHealth
				+ "\n\tYou currently deal " + playerDamage + " damage per turn");
		System.out.println("There are monsters everywhere! Close by, you mainly see mutated animals and zombies.");
		System.out.println("What will you do?");
		System.out.println("\t(1) Run back inside!"
				+ "\n\t(2) Fight something!"
				+ "\n\t(3) I'm hungry... I wonder if Chick-fil-A is open."
				+ "\n\t(4) Sneak around.");
		selection = select();
		
		if (selection == 1) {
			startGame();
		} else if (selection == 2) {
			if (fight() == true) {
				System.out.println("You beat the monster and return to Woodburn Hall.");
				goOutside();
			} else {
				// Player has died; no more code to run
			}
		} else if (selection == 3) {
			saveGame();
			goToLair();
		} else if (selection == 4) {
			saveGame();
			sneak();
		}
	}
	
	// Go to the Mountainlair; 50% chance to run into a monster
	public void goToLair() throws FileNotFoundException {
		int randomNum1 = (int)(Math.random() * 100);
		
		System.out.println("You sprint across Woodburn Circle toward the Mountainlair, trying to dodge monsters on the way.");
		
		if (randomNum1 >= 0 && randomNum1 <= 50) {
			System.out.println("You run into a monster!");
			if (fight() == true) {
				System.out.println("You beat the monster and return to Woodburn Hall.");
				goOutside();
			} else {
				// Player has died; no more code to run
			}
		} else {
			System.out.println("You make it safely to the Mountainlair, but remember that it is Sunday.");
			System.out.println("You groan and try to run back to Woodburn Hall.");
			
			int randomNum2 = (int)(Math.random() * 100);
			if (randomNum2 >= 0 && randomNum2 <= 50) {
				System.out.println("You run into a monster!");
				if (fight() == true) {
					System.out.println("You beat the monster and return to Woodburn Hall.");
					goOutside();
				} else {
					// Player has died; no more code to run
				}
			} else {
				goOutside();
			}
		}
	}
	
	// Sneak around campus; 30% chance to run into a monster
	public void sneak() throws FileNotFoundException {
		int randomNum = (int)(Math.random() * 100);
		
		System.out.println("You sneak around the Downtown Campus, careful to avoid monsters.");
		
		if (randomNum >= 0 && randomNum <= 30) {
			System.out.println("You hear something growl at you, and turn around to see a monster rushing at you!");
			if (fight() == true) {
				System.out.println("You beat the monster and return to Woodburn Hall.");
				goOutside();
			} else {
				// Player has died; no more code to run
			}
		} else {
			System.out.println("You explore the Downtown Campus.");
			System.out.println("The Mountainlair is overrun with monsters -- maybe it would be best if you avoided it.");
			System.out.println("Frat Row is crawling with zombie frat boys... They could also just be inebriated.");
			System.out.println("You find a PRT car broken down on the tracks. Several zombie students are trapped inside.");
			goToLair();
		}
	}
	
	// Handles fighting a mutated animal or a zombie; return 1 if player wins, 0 if player loses
	public boolean fight() throws FileNotFoundException {
		int randomNum = (int)(Math.random() * 100);
		
		if (randomNum >= 0 && randomNum <= 50) {
			Enemy enemy = new Enemy("Animal");
			
			while (getPlayerHealth() > 0 && enemy.getHealth() > 0) {
				System.out.println("You attack the " + enemy.getType() + " and deal " + playerDamage + " damage!");
				enemy.setHealth(getPlayerDamage());
				
				if (enemy.getHealth() > 0) {
					System.out.println("The " + enemy.getType() + " attacks you and deals " + enemy.getDamage() + " damage!");
					setHealth(enemy.getDamage());
					
					if (getPlayerHealth() == 0) {
						System.out.println("You have died!");
						saveGame();
						return false;
					}
				}
			}
			
			if (getPlayerHealth() > 0) {
				System.out.println("You have beaten the " + enemy.getType() + "!");
				enemy = null;
				saveGame();
				return true;
			} else {
				System.out.println("You have died!");
				enemy = null;
				saveGame();
				return false;
			}
		} else if (randomNum >= 51 && randomNum <= 100) {
			Enemy enemy = new Enemy("Zombie");
			
			while (getPlayerHealth() > 0 && enemy.getHealth() > 0) {
				System.out.println("You attack the " + enemy.getType() + " and deal " + playerDamage + " damage!");
				enemy.setHealth(getPlayerDamage());
				
				if (enemy.getHealth() > 0) {
					System.out.println("The " + enemy.getType() + " attacks you and deals " + enemy.getDamage() + " damage!");
					setHealth(enemy.getDamage());
					
					if (getPlayerHealth() == 0) {
						System.out.println("You have died!");
						saveGame();
						return false;
					}
				}
			}
			
			if (getPlayerHealth() > 0) {
				System.out.println("You have beaten the " + enemy.getType() + "!");
				enemy = null;
				saveGame();
				return true;
			} else {
				System.out.println("You have died!");
				enemy = null;
				saveGame();
				return false;
			}
		} else {
			return false;
		}
	}
	
	// Save playerData to a .txt file
	public void saveGame() throws FileNotFoundException {
		try {
			File fileOut = new File("playerdata.txt");
			PrintWriter write = new PrintWriter(fileOut);
			
			playerData[0] = playerName;
			playerData[1] = playerHealth;
			playerData[2] = playerDamage;
			
			for (int i = 0; i < playerData.length; i++) {
				write.println(playerData[i]);
				System.out.println(playerData[i]);
			}
			
			System.out.println("\nGAME SAVED");
			
			write.close();
		} catch (Exception e) {
			System.out.println("ERROR: Something went wrong trying to save your game! Sorry! :(");
			System.out.println("Please restart the game and try again.");
		}
	}
	
	// Load playerData from a .txt file
	public void loadGame() throws FileNotFoundException {
		try {
			File fileIn = new File("playerdata.txt");
			Scanner read = new Scanner(fileIn);
			
			for (int i = 0; i < playerData.length; i++) {
				playerData[i] = read.nextLine();
				System.out.println(playerData[i]);
			}
			
			System.out.println("GAME LOADED");
			
			read.close();
		} catch (Exception e) {
			System.out.println("ERROR: We could not find a saved game.");
			System.out.println("Please restart the game and start a new game.");
		}
	}
	
	// Method called whenever the player can select an option
	public int select() {
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
	
	public int getPlayerHealth() {
		return Integer.parseInt(playerHealth);
	}
	
	public int getPlayerDamage() {
		return Integer.parseInt(playerDamage);
	}
	
	public void setHealth(int damage) {
		int health = Integer.parseInt(playerHealth);
		
		health = health - damage;
		
		this.playerHealth = Integer.toString(health);
	}
}
