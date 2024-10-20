import java.util.Random;
import java.util.Scanner;

public class Main
{


    public static void main(String[] args)
    {

        Random gen = new Random();
        Scanner in = new Scanner(System.in);

        int die1 = 0;
        int die2 = 0;
        int crapsRoll = 0;
        int crapsPoint = 0;
        String playAgain = "";
        boolean doneInput = false;
        boolean donePlaying = false;
        boolean donePoint = false;



        do {
            System.out.println("Welcome to the Crap game!");
            die1 = gen.nextInt(6) + 1;
            die2 = gen.nextInt(6) + 1;

            crapsRoll = die1 + die2;
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12)
            {
                System.out.println("Die 1\tDie 2\tTotal");
                System.out.println("---------------------");
                System.out.printf("%4d\t%4d\t%4d\n", die1, die2, crapsRoll);
                System.out.println("You rolled a " + crapsRoll + ". You crapped out!");
            }
            else if (crapsRoll == 7 || crapsRoll == 11)
            {
                System.out.println("Die 1\tDie 2\tTotal");
                System.out.println("---------------------");
                System.out.printf("%4d\t%4d\t%4d\n", die1, die2, crapsRoll);
                System.out.println("You rolled a " + crapsRoll + ". You rolled a natural! You win!");
            }
            else
            {
                System.out.println("Die 1\tDie 2\tTotal");
                System.out.println("---------------------");
                System.out.printf("%4d\t%4d\t%4d\n", die1, die2, crapsRoll);
                System.out.println("You rolled a " + crapsRoll + ". This is now the point.");
                crapsPoint = crapsRoll;
                die1 = gen.nextInt(6) + 1;
                die2 = gen.nextInt(6) + 1;

                crapsRoll = die1 + die2;

                do {
                    die1 = gen.nextInt(6) + 1;
                    die2 = gen.nextInt(6) + 1;
                    crapsRoll = die1 + die2;

                    if (crapsRoll == 7) {
                        System.out.println("Die 1\tDie 2\tTotal");
                        System.out.println("---------------------");
                        System.out.printf("%4d\t%4d\t%4d\n", die1, die2, crapsRoll);
                        System.out.println("You rolled a " + crapsRoll + ". You crapped out!");
                        donePoint = true;
                    } else if (crapsRoll == crapsPoint) {
                        System.out.println("Die 1\tDie 2\tTotal");
                        System.out.println("---------------------");
                        System.out.printf("%4d\t%4d\t%4d\n", die1, die2, crapsRoll);
                        System.out.println("You rolled a " + crapsRoll + ". You rolled point and win!");
                        donePoint = true;
                    } else {
                        System.out.println("Die 1\tDie 2\tTotal");
                        System.out.println("---------------------");
                        System.out.printf("%4d\t%4d\t%4d\n", die1, die2, crapsRoll);
                        System.out.println("You rolled a " + crapsRoll + ". You need a " + crapsPoint + " to get point and win.");
                    }
                }while(!donePoint);

                }


            doneInput = false;

            do {
                System.out.print("Would you like to play again? [Y/N]: ");
                playAgain = in.nextLine();
                if (playAgain.equalsIgnoreCase("Y"))
                {
                    doneInput = true;
                    playAgain = "";
                    donePlaying = false;
                    donePoint = false;
                }
                else if (playAgain.equalsIgnoreCase("N"))
                {
                    System.out.println("Thanks for playing!");
                    doneInput = true;
                    donePlaying = true;
                }
                else
                    System.out.println(playAgain + " is an invalid choice. Please pick Y/N.");


            } while (!doneInput);


        }while (!donePlaying);




    }


}