import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.*;

//this program scores words depending on their
//occurence in google ngram by using Python
public class wordscore {
    private int score;
    private String word;

    public wordscore () {
        this.score = 0;
        this.word = "";
    }

    public wordscore(String word, int score) {
        //sending word and getting score
        try { 
            this.score = score;
            InetAddress localhost = InetAddress.getByName("localhost"); 
            Socket s = new Socket(localhost, 9000); 
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream()); 
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
            //sending word 
            out.write(word); 
            out.flush(); 

            //getting result (%)
            String answer = in.readLine();
            float answer2 = Float.parseFloat(answer);
            String answer3 = String.format("%.2f", answer2);
            answer2 = Float.parseFloat(answer3);
            if (answer2 >= 0.90) {
                this.score = 1;
                System.out.println("Word assigned score: " + this.score);
            }
            else if (answer2 >= 0.80 && answer2 < 0.90) {
                this.score = 2;
                System.out.println("Word assigned score: " + this.score);
            }
            else if (answer2 >= 0.70 && answer2 < 0.80) {
                this.score = 3;
                System.out.println("Word assigned score: " + this.score);
            }
            else if (answer2 >= 0.60 && answer2 < 0.70) {
                this.score = 4;
                System.out.println("Word assigned score: " + this.score);
            }
            else if (answer2 >= 0.50 && answer2 < 0.60) {
                this.score = 5;
                System.out.println("Word assigned score: " + this.score);
            }
            else if (answer2 >= 0.40 && answer2 < 0.50) {
                this.score = 6;
                System.out.println("Word assigned score: " + this.score);
            }
            else if (answer2 >= 0.30 && answer2 < 0.40) {
                this.score = 7;
                System.out.println("Word assigned score: " + this.score);
            }
            else if (answer2 >= 0.20 && answer2 < 0.30) {
                this.score = 8;
                System.out.println("Word assigned score: " + this.score);
            }
            else if (answer2 >= 0.10 && answer2 < 0.20) {
                this.score = 9;
                System.out.println("Word assigned score: " + this.score);
            }
            else if (answer2 >= 0.01 && answer2 < 0.10) {
                this.score = 10;
                System.out.println("Word assigned score: " + this.score);
            }
        }
        catch (Exception e) { 
            System.err.println("Connection Error!"); 
            e.printStackTrace(); 
        } 
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getScore() {
        return this.score;
    }
}