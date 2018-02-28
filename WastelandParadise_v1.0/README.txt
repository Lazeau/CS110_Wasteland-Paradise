Wasteland Paradise
Created by Matthew Lazo
CS 110
Dr. Saiph Savage
Section 001

>> DESCRIPTION
Wasteland Paradise is a text-based post-apocalyptic game coded in Java as
a CS 110 project. Explore post-apocalyptic Morgantown and fight off bad
guys!

[WARNING: If you wish to play with the code dealing with saving and
loading data, please ensure that you know what you are doing. I referred
to Chapter 11, Section 1 of the course textbook to learn basic file
reading and writing. Additionally, there are several concepts used
throughout the code which have not been covered in class yet, such as
arrays and loops. These are also covered in the course textbook.]

The game begins with a menu screen on which the player has the option to
choose to create a new game, load a saved game, play the tutorial to learn
how to play the game, or to quit the game. If the player chooses to start
a new game, a new "playerdata.txt" file is created with the player's
stats. If the player chooses to load a saved game, the program will look
for a "playerdata.txt" file to read the player's stats from. The tutorial
does not deal with stats. Quuitting the game terminates the program. This
is handled within the "game.java" class.

Upon starting the game, the player will find themselves in Woodburn Hall,
and will be able to either find a weapon or leave. Upon leaving, the
player has several options: go back inside, fight a monster, go to the
Mountainlair, or sneak around the Downtown Campus. The first of these
options holds no risk, but the latter three all carry at least some risk
of fighting a monster, and potentially dying to it. If the player dies,
the game is over, and they must create a new character or quit the game.
This is all handled within the "WastelandParadise.java" class.

Enemies are created by the "Enemy.java" class, and can be either a mutated
Animal or a Zombie. Animals have 100 Health and deal 10 Damage per turn,
while Zombies have 150 Health and deal 30 Damage per turn. There is an
additional enemy, the Super Mutant, which is not created within the normal
parameters of the game. If someone were to tamper with the code, then it
is possible for this enemy to be created, for better or for worse.

The "Tutorial.java" class is fairly straightforward and simple, and guides
the player through a linear tutorial to teach them the basics of playing
the game.


>> HOW TO RUN
To run the game, first ensure that all files for the game are in the same
folder on your hard drive. As of v0.1, all of the game files are:
- game.java
- Tutorial.java

Run the game however you can get Java files to run. This game will run
entirely in the console. Run in terminal window to feel cool.


>> UPDATE LOG
Version 1.0
February 11, 2018

- Main menu functions
- Player can load/save data and start a new game or load a saved one
- Player can complete the tutorial
- Combat system implemented