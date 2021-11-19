import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class game1 {
    public game1() throws IOException {    
        //intro to game
        Scanner in = new Scanner (System.in);
        System.out.println("Welcome to Language Jeopardy!");
        System.out.println("In this game, you will guess what words in foreign languages mean.");
        ArrayList <String> win = new ArrayList <String> (); //stores winner names
        String w = "";
        boolean value = false;

        //getting word
        String z = "";
        dictionary d = new dictionary (z);
        z = d.getLine();
        int score = 0;
        wordscore word = new wordscore(z, score);
        word.setWord(z);
        score = word.getScore();

        //setting lang1 and lang2
        String x = "en";
        System.out.println("Choose the language you want to guess words in: ");
        String y = in.nextLine();
        langsel lang = new langsel (y);
        lang.setLang(y);
        System.out.println("Chosen language: (" + lang.getLang2() + ", " + lang.getLang() + ")");
        y = lang.getLang();
        translate t = new translate (x, y, z);
        t.setInitLang(x);
        t.setEndLang(y);
        t.setText(z);

        //translating word from dict.
        String j = t.translate(x, y, z);
        System.out.println("What does this word mean: " + j);

        //guessing word (aka the game)
        System.out.println("You have 3 guesses.");
        for (int i = 1; i < 4; i++) {
            System.out.println("Attempt #" + (i) + ": ");
            String guess = in.nextLine();
            if (guess.equals(t.getText()) == true) {
                System.out.println("You win! It took: " + i + " tries.");
                //records winner
                System.out.println("Enter name for leaderboard: ");
                w = in.nextLine();
                result r = new result (w, score);
                r.setName(w);
                r.setScore(score);
                value = true;
                break;
            }
            else if (i < 3) {
                System.out.println("Try again!");
            }
        }
        if (value == false) {
            System.out.println("You lose! The word was: " + z);
        }
        in.close();
    }
}
