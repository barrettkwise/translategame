import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//this program stores the names of the winners of games 1 and 2
//in results.txt
public class result {
    private String result;
    private int score;

    public result () {
        this.result = "";
        this.score = 0;
    }

    public result (String result, int score) {
        //writing names to file
        try {
            this.score = score;
            File file = new File("results.txt");
            FileWriter filewrite = new FileWriter(file, true);
            Scanner in = new Scanner (System.in);
            PrintWriter out = new PrintWriter (filewrite);
            in = new Scanner (file);
            out.append("\n");
            out.append("player name: " + result + ", score: " + score);
            
            System.out.println("Name saved in: " + file);
            String[] cmdArray = new String[2];
            cmdArray[0] = "notepad.exe";
            cmdArray[1] = "results.txt";
            Process p = Runtime.getRuntime().exec(cmdArray, null);
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