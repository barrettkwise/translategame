import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class game2 {
    public game2() throws IOException {    
        String w = "";
        String b = null;
        Boolean value = false;
        Scanner in = new Scanner (System.in);
        //intro to game
        
        System.out.println("Welcome to Phrase Jeopardy!");
        System.out.println("In this game, you will guess what common phrases mean in different languages.");
        String x = "en";
        System.out.println("Choose the language you want to guess phrases in: ");
        String y = in.nextLine();
        langsel lang = new langsel (y);
        lang.setLang(y);
        System.out.println("Chosen language: (" + lang.getLang2() + ", " + lang.getLang() + ")");

        //getting phrases
        ArrayList <String> l = new ArrayList <String> (); //translated 
        ArrayList <String> k = new ArrayList <String> (); //english
        ArrayList <String> o = new ArrayList <String> (); //guesses
        ArrayList <String> a = new ArrayList <String> (); //to python
        dictionary2 d = new dictionary2 (k);
        k = d.getPhrase();

        //translating
        String z = "";
        y = lang.getLang();
        translate t = new translate (x, y, z);
        t.setInitLang(x);
        t.setEndLang(y);
        int score = 0;
        for (int i = 0; i < k.size(); i++) {
            z = k.get(i);
            t.setText(z);
            String j = t.translate(x, y, z);
            l.add(j);
        }
        //sending words to python
        a = k;
        wordscore2 word2 = new wordscore2(a, score);
        word2.setWord(a);
        score = word2.getScore();
        //game start
        System.out.print("What does this phrase mean:");
        for (int i = 0; i < l.size(); i++) {
            String h = l.get(i);
            System.out.print(" " + h);   
        }

        //getting guesses/logic
        String n = "";
        String m = "";
        int count = 0;
        int count2 = 0;
        int p = 0;
        System.out.println("");
        System.out.println("You have 3 guesses.");
        attempts:
        for (int i = 0; i < 3; i++)  {
            //resets "try again count"
            p = i;
            count2 = 0;
            //counts attempts
            System.out.println("Attempt #" + (i + 1) + ": ");
            for (int j = 0; j < 4; j++) {
                //takes words
                System.out.println("Enter word #" + (j + 1) + ": ");
                String guess = in.nextLine();
                o.add(guess);
                if (j == 3) {
                    //breaks word loop after 4 words entered
                    words:
                    for (int h = 0; h < 4; h++) {
                        //gets words to compare
                        n = o.get(h);
                        m = k.get(h);
                        compare:
                        for (int q = 0; q < 4; q++) {
                            if (n.equals(m) == true) {
                                count = count + 1;
                            }
                            //game logic
                            if (count == 4) {
                                value = true;
                                System.out.println("You win! It took: " + (p + 1) + " tries.");
                                //records winner
                                System.out.println("Enter name for leaderboard: ");
                                w = in.nextLine();
                                result r = new result (w, score);
                                r.setName(w);
                                r.setScore(score);
                                break attempts;
                            }
                            else if (count == 0) {
                                count2 = count2 + 1;
                                if (count2 == 1) {
                                    if (p <= 1) {
                                        System.out.println("Try again!");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //tells user that they lost
        if (value == false) {
            System.out.println("You lose! The phrase was: ");
            for (int i = 0; i < 4; i++) {
                String h = k.get(i);
                System.out.print(" " + h);
            }
        }
    }
}    