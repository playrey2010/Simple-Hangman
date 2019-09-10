import java.util.Random;
import java.util.Scanner;

public class SimpleHangman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String word = "";
        String answer = "";
        char guess = 'a';
        String[] answers = {"tree", "rain", "bear", "encourage", "promise",
        "soup", "chess", "insurance", "pancakes", "stream"};
        int lifeCounter = 5;


        // Choose a word randomly
        word = answers[r.nextInt(10)];
        System.out.println(word);
        // new variable with just underscores, same length
        answer = word.replaceAll("[a-zA-Z]", "_");
        // create char array containing answer word
        char [] word1 = new char[word.length()];
        for (int i =0 ; i < word.length(); i++) {
            word1[i] = word.charAt(i);
        }

        char [] answer1 = new char[answer.length()];
        for (int i =0 ; i < word.length(); i++) {
            answer1[i] = answer.charAt(i);
        }
        while (lifeCounter > 0) {
            System.out.print("\nYour guess: ");
            guess = sc.next().charAt(0);
            for (int i = 0; i < answer1.length; i++) {
                int rightGuess = 0;
                if (guess == word1[i]) {
                    answer1[i] = guess;
                    rightGuess++;
                }
//                System.out.print(answer1[i]);
            }

            for (int i =0 ; i < word.length(); i++) {
                System.out.print(answer1[i]);
            }

        }

        for (int i =0 ; i < word.length(); i++) {
            System.out.print(answer1[i]);
        }


//        System.out.println(word);
//        char [] answer1 = new char[word.length()];
//        for (int i =0 ; i < word.length(); i++) {
//            answer1[i] = word.charAt(i);
//            System.out.println(answer1[i]);
//        }






// is there a way to use for letter:word and make it work?
//        for (String letter:word) {
//            System.out.println(letter);
//        }
    }
}
