import java.util.Random;

public class Room {
    Random random2 = new Random();
    private boolean visited = false;

    //checks if an encounter occurs and if it does, calls encounter
    public void enter(Player player) {
        //if the room has not been visited
        if (!this.getVisited()) {
            this.setVisited(true);
            this.encounter(player);
        } else {
            System.out.println("*a spider scuttles across the floor of an empty room*");
            System.out.println("You have already visited this room");
        }
    }

    //decides if it's a monster or loot encounter
    public void encounter(Player player) {
        //should be 1 or 2
        int encounterType = random2.nextInt(1, 3);
        if (encounterType == 1) {
            this.lootEncounter(player);
        } else {
            Monster monster = monsterType();
            this.monsterEncounter(player, monster);
        }

    }

    //called if there's a loot encounter
    public void lootEncounter(Player player) {
        int lootType = random2.nextInt(1, 3);
        //heal
        if (lootType == 1) {
            player.onHeal(random2.nextInt(1, 16));
        }
        //gold
        else {
            player.onLoot(random2.nextInt(5, 21));
            //checks if player has won
            player.checkIfWon();
        }
    }

    //determines monster subclass randomly
    public Monster monsterType() {
        Monster monster;
        int monsterType = random2.nextInt(1, 5);
        if (monsterType == 1) {
            monster = new Goblin();
        } else if (monsterType == 2) {
            monster = new Zombie();
        } else if (monsterType == 3) {
            monster = new Orc();
        } else {
            monster = new Sizemogre();
        }
        return monster;
    }

    //runs for a monster encounter
    public void monsterEncounter(Player player, Monster monster) {
        System.out.println("You've encountered a " + monster.getMonsterType() + "!");
        String playerDecision = CheckInput.attackOrRun();
        combat(player, monster, playerDecision);
    }

    //runs until player runs away, monster dies, or player dies
    public void combat(Player player, Monster monster, String playerDecision) {
        if (playerDecision.equalsIgnoreCase("R")) {
            this.runAway(player, monster);
        //keeps combat going until player runs away.
        } else {
            monster.attack(player);
            player.checkIfDead();
            if(!player.getIsDead()){
                player.attack(monster);
                if (monster.isDead(monster.getHealth())) {
                    System.out.println("The " + monster.getMonsterType() + " is dead!");
                }
                else{
                    playerDecision = CheckInput.attackOrRun();
                    if (playerDecision.equalsIgnoreCase("R")) {
                        this.runAway(player, monster);

                    } else {
                        combat(player, monster, playerDecision);
                    }

                }
            }
        }
    }
    public void runAway(Player player, Monster monster) {
        monster.attack(player);
        player.checkIfDead();
        if(!player.getIsDead()) {
            System.out.println("You run away.");
        }
    }

    public boolean getVisited() {
        return visited;
    }
    public void  setVisited(boolean visited) {
        this.visited = visited;
    }
}







