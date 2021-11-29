import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

//this program stores the names of the winners of games 1 and 2
//in results.txt
public class result {
    private String result;
    private int score;

    public result () {
        this.result = "";
        this.score = 0;
    }

    //writing
    public result (String result, int score) {
        //writing names to file
        try {
            File file = new File("results.txt");
            FileWriter filewrite = new FileWriter(file, true);
            Scanner in = new Scanner (System.in);
            PrintWriter out = new PrintWriter (filewrite);
            in = new Scanner (file);
            out.append("\n");
            out.append("player name: " + result + ", score: " + score);
            
            System.out.println("Name saved.");
            out.close();
            in.close();
        }

        catch(IOException e) {
            System.out.println("File does not exist.");
        }
    }   

    public void setName(String result) {
        this.result = result;
    }

    public void setScore(int score) {
        this.score = score;
    }
}