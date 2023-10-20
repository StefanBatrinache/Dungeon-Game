import java.util.Scanner;
import java.util.Random;

public class Dungeon {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //variabile de Jucator

        int health = 100;
        int damage = 50;
        int potions = 3;
        int potionHealthRegen = 30;
        int potionDropChance = 50;              //procentaj - probabilitatea de a castiga o potiune de la inamic

        //Variabile inamic

        String [] enemies = {"Zombie", "Skeleton", "Warrior", "Assassin"};
        int enemyMaxHealth = 75;
        int enemyDamage = 25;

        boolean running = true;
        System.out.println("Welcome to my dungen!");

        GAME:                     //Asta e doar un Label, il poti atribui block-ului de dedesupt pentru a il gasi mai usor
        while (running) {
            System.out.println("--------------------------");

            int enemyHealth = rand.nextInt(enemyMaxHealth);
            String enemy = enemies [rand.nextInt(enemies.length)];

            System.out.println("\t# " + enemy + " has appeared! #");

            while (enemyHealth > 0) {
                System.out.printf("\t\n Your health is: " + health);
                System.out.println("\t\n The enemy health " + "(" + enemy + ")" + " is: " + enemyHealth);
                System.out.printf("\t\n What's your next move?");
                System.out.printf("\t\n1. Attack");
                System.out.printf("\t2. Drink 1 potion");
                System.out.println("\t3. RUN!");

                  String input = in.nextLine();
                  if (input.equals("1")) {
                      //cod pentru actiunea de a ataca

                      int damageDealt = rand.nextInt(damage);
                      int damageReceived = rand.nextInt(enemyDamage);

                      enemyHealth -= damageDealt;
                      health -= damageReceived;

                      System.out.println("\tYou hit " + enemy + " dealing " + damageDealt + " damage.");
                      System.out.printf("\tYou received " + damageReceived + " damage.");

                      if (health < 1) {
                          System.out.printf("\t\nYour health is too low to continue");
                          break;
                      }


                  } else if (input. equals("2")){
                      //for drinking the potion
                      if (potions >0) {
                          health += potionHealthRegen;
                          potions--;
                          System.out.printf("\tYou used one potion, you received " + potionHealthRegen + " health points" +
                                          "\n\tNow you have " + health + " health." +
                                          "\n\tAnd " + potions + " potions left.");


                      } else {
                          System.out.printf("\t\nNo more potions left, kill an enemy to have a change of getting one.");
                      }


                  }else if (input.equals("3")){
                      //for running option
                      System.out.printf("\tYu ran away from  " + enemy);
                      continue GAME;

                  }
                  else {
                      //For invalid input
                      System.out.printf("\tInvalid input!");
                  }


            }if (health < 1) {
                System.out.printf("\t\n WASTED! Better luck next time!");
                break;
               }

            System.out.printf("\t\n----------------------------------");
            System.out.printf("\t\n ~ " + " The " + " (" + enemy + ") " + "was defetead! ~");
            System.out.printf("\t\n ~ You have " + health + " health points. ~");


            if (rand.nextInt(100) < potionDropChance){     //asta inseamna 50% cica, nu prea am inteles
                potions++;
                System.out.printf("\t\n ~ You earned a potion from defeating the " + enemy + " ! ~");
                System.out.printf("\t\n ~ You have " + potions + " potions left. ~");
            }

            System.out.printf("\t\n What is your next move?");
            System.out.printf("\t\n1. Continue fighting!");
            System.out.printf("\t\n2. Quit the game, I am a coward.");
            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.printf("Invalid input!");
                input = in.nextLine();
            }

            switch (input) {
                case "1" : {
                    System.out.printf(" Continue the adventure!");
                    break;

                }
                case "2" : {
                    System.out.printf("\nYou chose to end your adventure. Good luck in your real life!");
                    break GAME;

                }
            }


        }
        System.out.printf("\n############################################");
        System.out.printf("\t\n      ~~~~ Multumim de joc! ~~~~");
        System.out.printf("\n############################################");

        }

    }
