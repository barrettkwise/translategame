import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.*;
import java.util.ArrayList;

//this program scores phrases depending on their
//occurence in google ngram by using Python
public class wordscore2 {
    private int score;
    private ArrayList <String> word = new ArrayList <String> ();

    public wordscore2 () {
        this.score = 0;
        this.word = null;
    }

    public wordscore2(ArrayList <String> word, int score) {
        this.score = score;
        try { 
            InetAddress localhost = InetAddress.getByName("localhost"); 
            Socket s = new Socket(localhost, 9000); 
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream()); 
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
            //sending phrase
            for (int i = 0; i < word.size(); i++) {
                String word2 = word.get(i);
                if (i <= 2) {
                    word2 += ",";
                }
                out.write(word2);
                out.flush();
            }

            //getting result (%)
            String answer = in.readLine();
            float answer2 = Float.parseFloat(answer);
            if (answer2 >= 0.90) {
                this.score = 1;
                System.out.println("Phrase assigned score: " + this.score);
            }
            else if (answer2 >= 0.80 && answer2 < 0.90) {
                this.score = 2;
                System.out.println("Phrase assigned score: " + this.score);
            }
            else if (answer2 >= 0.70 && answer2 < 0.80) {
                this.score = 3;
                System.out.println("Phrase assigned score: " + this.score);
            }
            else if (answer2 >= 0.60 && answer2 < 0.70) {
                this.score = 4;
                System.out.println("Phrase assigned score: " + this.score);
            }
            else if (answer2 >= 0.50 && answer2 < 0.60) {
                this.score = 5;
                System.out.println("Phrase assigned score: " + this.score);
            }
            else if (answer2 >= 0.40 && answer2 < 0.50) {
                this.score = 6;
                System.out.println("Phrase assigned score: " + this.score);
            }
            else if (answer2 >= 0.30 && answer2 < 0.40) {
                this.score = 7;
                System.out.println("Phrase assigned score: " + this.score);
            }
            else if (answer2 >= 0.20 && answer2 < 0.30) {
                this.score = 8;
                System.out.println("Phrase assigned score: " + this.score);
            }
            else if (answer2 >= 0.10 && answer2 < 0.20) {
                this.score = 9;
                System.out.println("Phrase assigned score: " + this.score);;
            }
            else if (answer2 >= 0.01 && answer2 < 0.10) {
                this.score = 10;
                System.out.println("Phrase assigned score: " + this.score);
            }

        } catch (Exception e) { 
            System.err.println("Connection Error"); 
            e.printStackTrace(); 
        } 
    }

    public void setWord(ArrayList <String> word) {
        this.word = word;
    }

    public int getScore() {
        return this.score;
    }
}