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
        this.word = word;
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