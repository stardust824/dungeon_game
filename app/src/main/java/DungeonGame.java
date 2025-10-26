public class DungeonGame {
    private DungeonMap map;
    private Player player;
    private boolean gameOver = false;

    /* Initializes the size of the dungeon */
    //constructor + game intro + makes map and stuff
	public DungeonGame(int rows, int columns) {
        System.out.println("You find yourself in a dungeon.");
        System.out.println("Somehow you know that the rooms are full of monsters.");
        System.out.println("But you also know that some rooms contain healing potions or gold.");
        printCat();
        System.out.println("I've traveled far to tell you that an evil professor has locked you in this dungeon.");
        System.out.println("But fear not, for if you collect 100 gold pieces, you can escape.");
        String playerClass = CheckInput.chooseClass();
        if (playerClass.equalsIgnoreCase("T")){
            System.out.println("Good luck on your journey clever thief.");
            player = new Thief();
        }
        if(playerClass.equalsIgnoreCase("W")) {
            System.out.println("Good luck on your journey brave warrior.");
            player = new Warrior();
        }
        map = new DungeonMap(rows, columns, player);
	}
	
	/* Main loop of the game, which handles
	non-combat related user input. Continues
	until the Player either wins or loses. */
    public void play() {
        while(gameOver == false) {
            System.out.println("=======================================================");
            this.display();
            String moveTo = CheckInput.whereMove();
            this.map.move(player, moveTo);
            //returns room player is in
            Room room = this.map.currentRoom();
            room.enter(player);
            if(player.getIsDead()){
                System.out.println("Everything starts to go black...");
                System.out.println("The dungeon has claimed you as one of its many victims.");
                System.out.println("You have died.");
                setGameOver(true);
            }
            if(player.hasWon()){
                display();
                printCat();
                System.out.println("Oh. Did I say 100 gold pieces?");
                System.out.println("I meant one");
                System.out.println("*the cat eats one of your gold pieces*");
                System.out.println("*the rooms fills with white light*");
                System.out.println("You have escaped the dungeon.");
                setGameOver(true);

            }

        }
    }

    //prints map + gold + health
    public void display() {
        map.print();
        System.out.println("Gold: " + player.getGold());
        System.out.println("Health: " + player.getHealth());
    }
    //prints the cat character
    public static void printCat() {
        System.out.println(" /\\_/\\\n" + "( o.o )\n" + " > ^ <");
    }
    public boolean isGameOver(){
        return gameOver;
    }
    public void setGameOver(boolean tOrF ) {
        gameOver = tOrF;
    }
}
