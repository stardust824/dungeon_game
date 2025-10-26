import java.util.Scanner;

public class CheckInput {

    //gets input from user
    public static String getInput(String tellUser) {
        //new scanner object to read input
        Scanner sc = new Scanner(System.in);

        System.out.println(tellUser);
        String input = sc.nextLine();

        return input;
    }

    //allows user to select a class and checks the input
    //will return W or T upper or lower case
    public static String chooseClass() {
        String input = getInput("Select your class: [W]arrior or [T]hief. ");
        if (!input.equalsIgnoreCase("W") && !input.equalsIgnoreCase("T")) {
            System.out.println("Invalid input. Please enter \"W\" or \"T\" ");
            return chooseClass();
        }
        else {
            return input;
        }
    }

    //asks user if they want to attack or run and checks input
    //will return A or R upper or lower case
    public static String attackOrRun() {
        String input = getInput("Would you like to [A]ttack or [R]un? ");
        if(!input.equalsIgnoreCase("A") && !input.equalsIgnoreCase("R")) {
            System.out.println("Invalid input. Please enter \"A\" or \"R\" ");
            return attackOrRun();
        }
        else {
            return input;
        }
    }

    //asks user to choose where to move and checks input
    //returns WASD regardless of case
    public static String whereMove() {
        String input = getInput("Would you like to go [W]up, [A]left, [S]down, or [D]right? ");
        if(!input.equalsIgnoreCase("D") && !input.equalsIgnoreCase("A") && !input.equalsIgnoreCase("W") && !input.equalsIgnoreCase("S")) {
            System.out.println("Invalid input. Please enter \"W\", \"A\", \"S\", or \"D\". ");
            return whereMove();
        }
        else {
            return input;
        }
    }
}
