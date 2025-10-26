import java.util.Random;

public class Monster {
    private int health;
    //Max damage this Monster inflicts
    private int damage;
    private String monsterType;
    Random random = new Random();


    //constructor
    protected Monster (int health, int damage, String monsterType) {
        this.health = health;
        this.damage = damage;
        this.monsterType = monsterType;
    }


    /* Hits the targeted Player */
    public void attack(Player target) {
        //make damage randomized
        int damageTaken = random.nextInt(1, this.getDamage() + 1 );
        target.onHit(damageTaken);
        System.out.println("The " + this.monsterType + " attacks you! You take " + damageTaken + " damage.");

    }

    /* Removes health from this Monster
    when hit by a Player */
    public void onHit(int damage) {
        decreaseHealth(damage);
        System.out.println("You hit the " + this.getMonsterType() + " and deal " + damage + " damage");
        System.out.println("The " + this.getMonsterType() + " has " + this.getHealth() + " health");
    }

    public boolean isDead (int health) {
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    //getters
    public int getHealth() {
        return health;
    }
    //max damage
    public int getDamage() {
        return damage;
    }
    public String getMonsterType() {
        return monsterType;
    }

    public void decreaseHealth (int amountDecreased) {
        this.health = (health - amountDecreased);
    }
}
