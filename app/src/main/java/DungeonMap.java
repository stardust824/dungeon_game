
/* Contains the Rooms in the dungeon 
and logic for Player movement */
public class DungeonMap {

	// Rooms in the dungeon
    private Room[][] rooms;
    // Reference to the Player in the dungeon
    private Player player;
    private int rows;
    private int columns;

    /* Initializes the rooms and shared Player reference */
    //makes the rooms and gives DungeonMap the player
    //should only be called once per game
    public DungeonMap (int rows, int columns, Player player){
        this.rows = rows;
        this.columns = columns;
        this.rooms = new Room[rows][columns];
        this.player = player;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.rooms[i][j] = new Room();
            }
        }
        this.rooms[0][0].setVisited(true);
    }

    /* Displays the dungeon's rooms, walls,
    and player's current location */
    //prints rooms
    public void print() {
        //print top walls
        System.out.print("+");
        for (int t = 0; t < rooms[0].length; t++){
            System.out.print("-");
        }
        System.out.print("+");
        System.out.println("");
        for(int row = 0; row < rooms.length; row++){
            //print a side wall
            System.out.print("|");
            for(int column = 0; column < rooms[0].length; column++){
                //if player is in the room, prints "W" or "T" depending on player class (not handled here)
                if(player.getRowPosition() == row && player.getColumnPosition() == column) {
                    System.out.print(player.playerClass());
                }
                //prints asterisk if room has been visited
                else if (this.rooms[row][column].getVisited()){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            //print another side wall and a newline
            System.out.println("|");
        }
        //print the bottom wall
        System.out.print("+");
        for (int b = 0; b < rooms[0].length; b++){
            System.out.print("-");
        }
        System.out.println("+");

        //rooms.length is the number of rows
        //rooms[0].length is the number of columns

    }

    //moves the player and calls the other move methods
    public void move(Player player, String where) {
        switch (where.toUpperCase()) {
            case "A":
                this.moveLeft(player);
                break;
            case "D":
                this.moveRight(player);
                break;
            case "S":
                this.moveDown(player);
                break;
            case "W":
                this.moveUp(player);
                break;
        }
    }
    public void moveLeft(Player player){
        if(isWall(player.getColumnPosition() - 1, player.getRowPosition())) {
            System.out.println("You can't move into a wall.");
            String where = CheckInput.whereMove();
            move(player, where);
        }
        else{
            player.setColumnPosition(player.getColumnPosition() - 1);
        }
    }
    public void moveRight(Player player){
        if(isWall(player.getColumnPosition() + 1, player.getRowPosition())) {
            System.out.println("You can't move into a wall.");
            String where = CheckInput.whereMove();
            move(player, where);
        }
        else{
            player.setColumnPosition(player.getColumnPosition() + 1);
        }
    }
    public void moveDown(Player player) {

        if(isWall(player.getColumnPosition(), player.getRowPosition() + 1)) {
            System.out.println("You can't move into a wall.");
            String where = CheckInput.whereMove();
            move(player, where);
        }
        else{
            player.setRowPosition(player.getRowPosition() + 1);
        }

    }
    public void moveUp(Player player){
        if(isWall(player.getColumnPosition(), player.getRowPosition() - 1)) {
            System.out.println("You can't move into a wall.");
            String where = CheckInput.whereMove();
            move(player, where);
        }
        else{
            player.setRowPosition(player.getRowPosition() - 1);
        }

    }
    //checks if the user is trying to move into a wall
    public boolean isWall (int newRow, int newColumn) {
        if(newRow < 0 || newColumn < 0){
            return true;
        }
        else if(newRow == this.rows){
            return true;
        }
        else if(newColumn == this.columns){
            return true;
        }
        else{
            return false;
        }
    }
    public int getColumns() {
        return columns;
    }
    public int getRows(){
        return rows;
    }
    //returns player's current room
    public Room currentRoom () {
        return rooms[player.getRowPosition()][player.getColumnPosition()];
    }
}
