package fr.zinox.solution;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ZiNoX
 */

public class Solution
{
    private static final int ROWS_MIN = 3;
    private static final int ROWS_MAX = 50;

    private static final char EVAPORATOR_CASE_CHAR = 'x';
    private static final char EMPTY_CASE_CHAR = '.';

    public static void main(String[] args)
    {
        final Scanner scanner = new Scanner(System.in);

        int lines;
        boolean randomRows;
        int cultivableHuts = 0;

        System.out.println("Do you want a random number between " + ROWS_MIN + " and " + ROWS_MAX + " representing your row number ?");
        System.out.println("Enter yes if you want a random number or not if you enter your own number");

        randomRows = scanner.nextLine().equalsIgnoreCase("yes");

        if (randomRows)
        {
            lines = ThreadLocalRandom.current().nextInt(ROWS_MIN, ROWS_MAX);

            System.out.println("The random number is: " + lines);
        }
        else
        {
            do
            {
                System.out.println("You have chosen to enter your own number.");
                System.out.println("Please enter a number between " + ROWS_MIN + " and " + ROWS_MAX + " representing your li number");
                lines = scanner.nextInt();
            } while (lines < ROWS_MIN || lines > ROWS_MAX);
        }

        final String[] patterns = new String[lines];
        final char[][] farm = new char[lines][lines];

        for (int i = 0; i < lines; i++)
        {
            StringBuilder pattern = new StringBuilder();

            for (int j = 0; j < lines; j++)
            {
                pattern.append(ThreadLocalRandom.current().nextBoolean() ? EVAPORATOR_CASE_CHAR : EMPTY_CASE_CHAR);
            }
            patterns[i] = pattern.toString();
        }

        for (int i = 0; i <= farm.length - 1; i++)
        {
            for (int j = 0; j <= farm[i].length - 1; j++)
            {
                char currentChar = patterns[i].charAt(j);
                farm[i][j] = currentChar;
                if (currentChar == EMPTY_CASE_CHAR)
                {
                    cultivableHuts++;
                }
            }
        }

        System.out.println("There are " + cultivableHuts + " cultivable spaces on your farm");
    }
}
