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
        this.word = word;
        this.score = score;
        try { 
            InetAddress localhost = InetAddress.getByName("localhost"); 
            Socket s = new Socket(localhost, 9000); 
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream()); 
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
            //sending word 
            out.write(word); 
            out.flush(); 

            //getting result (%)
            String answer = in.readLine();
            System.out.println(answer);
            float answer2 = Float.parseFloat(answer);
            System.out.println(answer2);
            if (answer2 >= 0.90) {
                score = 1;
            }
            else if (answer2 >= 0.80 && answer2 < 0.90) {
                score = 2;
            }
            else if (answer2 >= 0.70 && answer2 < 0.80) {
                score = 3;
            }
            else if (answer2 >= 0.60 && answer2 < 0.70) {
                score = 4;
            }
            else if (answer2 >= 0.50 && answer2 < 0.60) {
                score = 5;
            }
            else if (answer2 >= 0.40 && answer2 < 0.50) {
                score = 6;
            }
            else if (answer2 >= 0.30 && answer2 < 0.40) {
                score = 7;
            }
            else if (answer2 >= 0.20 && answer2 < 0.30) {
                score = 8;
            }
            else if (answer2 >= 0.10 && answer2 < 0.20) {
                score = 9;
            }
            else if (answer2 >= 0.01 && answer2 < 0.10) {
                score = 10;
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