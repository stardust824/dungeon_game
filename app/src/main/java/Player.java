
public class Player {

    //initializes variables
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;

    private boolean hasWon = false;
    private boolean isDead = false;

    //player position
    private int rowPosition = 0;
    private int columnPosition = 0;




    //constructor
    protected Player (int health, int gold, int damage, String playerClass, double lootModifier){
        this.health = health;
        this.gold = gold;
        this.damage = damage;
        this.playerClass = playerClass;
        this.lootModifier = lootModifier;
    }


    /* Hits the targeted Monster */
    public void attack(Monster target) {
        //should print something like "You attack the Goblin for 15 damage!"
        //changes monster's health
        target.decreaseHealth(this.getDamage());
        System.out.println("*slash*");
        System.out.println ("You attack the " + target.getMonsterType() + " for " + this.getDamage() + " damage!");

    }

	/* Removes health from this Player
    when hit by a Monster */
    //damage should be a positive number
    public void onHit(int damage) {
        decreaseHealth(damage);

    }

	/* Adds health to this Player when healed */
    public void onHeal(int amountHealed) {
        increaseHealth(amountHealed);
        System.out.println("You find a mysterious potion. You drink it. You gain " + amountHealed + " hp.");

    }

	/* Adds gold to this Player when obtained */
    public void onLoot(int goldGained) {
        setGold(goldGained);
        //gets the amount gold was increased
        int goldIncreased = goldGained(goldGained);
        System.out.println("You find a small chest. You open it.");
        System.out.println("*CREAKKK*");
        System.out.println("You gain " + goldIncreased + " gold!");

    }

    //all the getters
    //used to get fields in subclasses
    public int getHealth () {
        return health;
    }
    public int getGold () {
        return gold;
    }
    public int getDamage () {
        return damage;
    }
    public String playerClass() {
        return playerClass;
    }
    public double lootModifier () {
        return lootModifier;
    }
    public boolean getIsDead() {
        return isDead;
    }
    public int getRowPosition() {
        return rowPosition;
    }
    public int getColumnPosition() {
        return columnPosition;
    }
    public boolean hasWon() {
        return hasWon;
    }

    //setters
    public void increaseHealth (int amountIncreased) {
        this.health = (health + amountIncreased);
        if (health > 100 && this.playerClass.equalsIgnoreCase("W")) {
            this.health = 100;
        }
        if (health > 70 && this.playerClass.equalsIgnoreCase("T")) {
            this.health = 70;
        }
    }
    public void decreaseHealth (int amountDecreased) {
        //amountDecreased should be a positive number when put into the method
        this.health = (health - amountDecreased);
    }
    public void setGold (int amountIncreased) {
        this.gold = (int) (gold + (amountIncreased * this.lootModifier()));
    }
    public int goldGained(int amountIncreased) {
        int goldGained = (int) (amountIncreased * this.lootModifier());
        return goldGained;
    }

    public void checkIfWon() {
        if (this.gold >= 100) {
            this.hasWon = true;
        }
        else {
            this.hasWon = false;
        }
    }

    public void checkIfDead() {
        if (this.health <= 0) {
            this.isDead = true;
        }
        else {
            this.isDead = false;
        }
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public void setColumnPosition(int columnPosition){
        this.columnPosition = columnPosition;
    }
}
