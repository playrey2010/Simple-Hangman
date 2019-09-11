import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SimpleHangman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        char guess = 'a';
        String word = "";
        String tempAnswer = "";
        String[] answers = {"tree", "rain", "bear", "encourage", "promise",
                "soup", "chess", "insurance", "pancakes", "stream"};
        int lives = 5;
        boolean change = false;
        boolean victory = false;

        // Choose word randomly
        // word == 1 of answers
        word = answers[r.nextInt(10)];

        // create char array containing answer word
        char [] wordArray = new char[word.length()];
        for (int i =0 ; i < word.length(); i++) {
            wordArray[i] = word.charAt(i);
        }

        // Create temporary answer with underscores
        tempAnswer = word.replaceAll("[a-zA-Z]", "_");

        // create char array containing underscores
        char [] answerNow = new char[tempAnswer.length()];
        for (int i =0 ; i < word.length(); i++) {
            answerNow[i] = tempAnswer.charAt(i);
        }

        for (char i : answerNow) {
            System.out.print(i + " ");
        }


        while (lives>0) {
            // long way to compare would include a nested for loop going through both array indexes and setting multiple conditions
            if (Arrays.equals(answerNow, wordArray)) {
                victory = true;
                break;
            } else {
                System.out.print("\nYour guess: ");
                guess = sc.next().charAt(0);
                change = false;
                for (int i =0; i < answerNow.length; i++) {
                    if (guess == wordArray[i]) {
                        answerNow[i] = guess;
                        change = true;
                    }
                }

                if (change == true) {
                    System.out.print("Your guess so far: ");
                    for (char i : answerNow) {
                        System.out.print(i + " ");
                    }
                } else {
                    lives--;
                    switch (lives) {
                        case 4:
                        case 3:
                        case 2:
                            System.out.println("You still have " + lives + " chances!");
                            break;
                        case 1:
                            System.out.println("You have one more chance!");
                            break;
                    }
                    System.out.print("Your guess so far: ");
                    for (char i : answerNow) {
                        System.out.print(i + " ");
                    }
                }

            }

        }
        if (victory) {
            System.out.println("\nYou win!!");
        }
        else {
            System.out.println("\nBetter luck next time!");
            System.out.print("The answer was ");
            for (char i : wordArray) {
                System.out.print(i + " ");
            }
        }
    }
}
