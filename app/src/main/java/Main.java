//Date: Feb 20th, 2025


public class Main {
    public static void main(String[] args) {
        //checks if there are string arguments
        if (args.length > 0) {
            int rows = Integer.parseInt(args[0]);
            int columns = Integer.parseInt(args[1]);
            //checks if string arguments are valid
            if (rows <= 0 || columns <= 0) {
                System.out.println("Invalid system arguments. Please re-run main with new system arguments.");
            }
            else {
                DungeonGame game = new DungeonGame(rows, columns);
                game.play();
            }
        }
        //default dungeon size
        else {
            DungeonGame game = new DungeonGame(10, 10);
            game.play();
        }

    }

}
