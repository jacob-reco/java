import java.util.Random;
import java.util.Scanner;

public class GameApp {

    Scanner myScanner = new Scanner(System.in);
    Random rand = new Random();
	Scanner enterScanner = new Scanner(System.in);
    String playerName;
    int choice;

    //Game Variables
    String[] enemies = {"Scavanger", "Hunter", "Mutant" };
    int maxEnemyHealth = 50;
    int enemyAttackDamage = 25;

    //Player Variables
    int health = 100;
    int attackDamage = 50;
    
    boolean running = true;

    public static void main (String args[]){
        GameApp adventure;
        adventure = new GameApp();
        adventure.playerSetUp();
		adventure.crossRoad();
    }

     public void playerSetUp(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Please enter your name:");
		playerName = myScanner.nextLine();
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Hello " + playerName + ", let's start!");
        System.out.println("Press Enter.");
        myScanner.nextLine();
     }        

     public void crossRoad(){
        System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You wake up.");
        System.out.println("Your ears are ringing.");
        System.out.println("You stumble to your feet.");
        System.out.println("You realise where you are.");
        System.out.println("THE WASTELAND.");
        System.out.println("Continue.");
        System.out.println("\n------------------------------------------------------------------\n");
        myScanner.nextLine();

        boolean validResponse = false;
        while (!validResponse){
            System.out.println("Which way do you want to go? Enter 1,2,3 or 4.");
            System.out.println("1: North towards Solitude City");
            System.out.println("2: East towards the Neutral Zone");
            System.out.println("3: South towards Hope Falls Canyon");
            System.out.println("4: West towards Scavenger Territory");
            System.out.println("\n------------------------------------------------------------------\n");
            choice = myScanner.nextInt();

            if (choice == 1) {north(); }
            else if (choice == 2) {east(); }
            else if (choice == 3) {south(); }
            else if (choice == 4) {west(); }
            if (choice <= 4 && choice > 0) {
                validResponse = true; 
            }
        }
    }
    public void north(){
        System.out.println("SOLITUDE CITY");
        System.out.println("As you make the long journey home towards SOLITUDE CITY...you can hear something in the distance, something's running towards you!");
        System.out.println("\n------------------------------------------------------------------\n");
        
        GAME:
        while (running)  {
            int enemyHealth = rand.nextInt (maxEnemyHealth);
            String enemy = enemies [rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy +" has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\t What would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Run!");

                String input = myScanner.nextLine();
                if (input.equals ("1")) {
                    int damageDealt = rand.nextInt (attackDamage);
                    int damageTaken = rand.nextInt (enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                    
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + "damage."); 
                    System.out.println("\t> You receive " + damageTaken + " in damage retaliatiation!");

                    if(health < 1) {
                        System.out.println("\t> You have taken too much damage, your are too weak to go on!");
                        break;
                    } 
                }
                else if (input.equals("2")) {
                    System.out.println("\t> You run away from the " + enemy + "!");
                    continue GAME;
                }
            }
        }
    }

     public void east(){
        System.out.println("THE NEUTRAL ZONE");
        System.out.println("You trek towards the last known outpost of mankind, THE NEUTRAL ZONE.");
        System.out.println("\n------------------------------------------------------------------\n");
     }

     public void south(){
        System.out.println("HOPE FALLS CANYON");
        System.out.println("You've only heard stories of HOPE FALLS CANYON. But that's all you need.");
        System.out.println("\n------------------------------------------------------------------\n");
     }

     public void west(){
        System.out.println("SCAVENGER TERRITORY");
        System.out.println("This is the final frontier. SCAVENGER TERRITORY is a dangerous place to be, even for the most hostile barbarians...tread lightly.");
        System.out.println("\n------------------------------------------------------------------\n");
     }
}