import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public class SnakeAndLadder 
{
    static HashMap<Integer, Integer> snakes = new HashMap<>();
    static HashMap<Integer, Integer> ladders = new HashMap<>();
    static final int WIN_POSITION = 100;    
    static 
	{
        snakes.put(99, 10);
        snakes.put(95, 20);
        snakes.put(80, 40);
        snakes.put(60, 45);
        snakes.put(45, 5);
        ladders.put(3, 22);
        ladders.put(8, 30);
        ladders.put(28, 55);
        ladders.put(58, 80);
        ladders.put(75, 97);
    }
    public static int rollDice() 
	{
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    public static int movePlayer(int position, int diceRoll) {
        int newPosition = position + diceRoll;
        if (newPosition > WIN_POSITION) 
		{
            return position;
        }
        if (snakes.containsKey(newPosition)) 
		{
            System.out.println("Oh no! A snake! Moving down to " + snakes.get(newPosition));
            return snakes.get(newPosition);
        }
        if (ladders.containsKey(newPosition)) 
		{
            System.out.println("Great! A ladder! Climbing up to " + ladders.get(newPosition));
            return ladders.get(newPosition);
        }
        return newPosition;
    }
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        int playerPosition = 0;
        System.out.println("Welcome to Snake and Ladder Game!");    
        while (playerPosition < WIN_POSITION) 
		{
            System.out.println("Press Enter to roll the dice...");
            scanner.nextLine();
            int diceRoll = rollDice();
            System.out.println("You rolled a " + diceRoll);
            playerPosition = movePlayer(playerPosition, diceRoll);
            System.out.println("Your new position: " + playerPosition);
            System.out.println("----------------------------");
        }
        System.out.println("Congratulations! You won the game!");
        scanner.close();
    }
}