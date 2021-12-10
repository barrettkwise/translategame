import java.util.Scanner;
import java.util.Random;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.file.Path;

//this program gathers the phrase to be translated
//for game 2
public class dictionary2 {
    private ArrayList <String> p = new ArrayList <String> ();

    public dictionary2() {
        this.p = null;
    }

    public dictionary2 (ArrayList <String> p) {   
        //getting phrase
        try {
            this.p = p;
            Random random = new Random();
            Scanner in = new Scanner (System.in);
            int rand = 1 + random.nextInt(4);
            //choosing 4 word phrase
            if (rand == 0) {
                for (int i = 0; i < 4; i++) {
                    String l = Files.readAllLines(Paths.get("phrases.txt")).get(i);
                    p.add(l);
                }
                in.close();
            }
            else if (rand == 1) {
                for (int i = 5; i < 9; i++) {
                    String l = Files.readAllLines(Paths.get("phrases.txt")).get(i);
                    p.add(l);
                }
                in.close();
            }
            else if (rand == 2) {
                for (int i = 10; i < 14; i++) {
                    String l = Files.readAllLines(Paths.get("phrases.txt")).get(i);
                    p.add(l);
                }
                in.close();
            }
            else if (rand == 3) {
                for (int i = 15; i < 19; i++) {
                    String l = Files.readAllLines(Paths.get("phrases.txt")).get(i);
                    p.add(l);
                }
                in.close();
            }
        }
        catch(IOException e) {
            System.out.println("File does not exist.");
        }
    }

    public ArrayList <String> getPhrase() {
        return this.p;
    }
}