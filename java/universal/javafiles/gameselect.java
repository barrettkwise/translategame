import java.util.Scanner;
import java.io.IOException;

//makes it easier for user to
//select game/start python
public class gameselect {
    public static void main(String args[]) throws IOException {
        //select game
        try {
            //start python
            ProcessBuilder pb = new ProcessBuilder("python", "C:/Users/Barrett/Documents/ngramcount.py");
            Process p = pb.start();
            Scanner in = new Scanner (System.in);
            game1 g = new game1();
            game2 f = new game2();
            int choice = 0;
            System.out.println("Welcome to TranslateGame!");
            System.out.println("Type 1 for game1 (words) or 2 for game2 (phrases)");
            while (choice != 1 && choice != 2) {
                choice = in.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("No game associated with that number.");
                }
            }
            if (choice == 1) {
                g.game1();
            }
            else if (choice == 2) {
                f.game2();
            }
        }
        catch(IOException e) {
            System.out.println("No.");
        }
    }
}