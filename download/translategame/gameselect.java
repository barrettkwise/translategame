import java.util.Scanner;
import java.io.IOException;

//makes it easier for user to
//select game/start python
public class gameselect {
    public static void main(String args[]) throws IOException {
        //select game
        try {
            System.out.println("Welcome to TranslateGame!");
            Scanner in = new Scanner(System.in);
            downloader d = new downloader();
            d.downloader();
            System.out.println("Enter the name assigned to your Windows user: ");
            String name = in.nextLine();
            //start python
            String app = "py";
            String path = "C:/Users/" + name + "/Downloads/translategame-master/download/ngramcount.py";
            ProcessBuilder pb = new ProcessBuilder(app, path);
            Process p = pb.start();
            game1 g = new game1();
            game2 f = new game2();
            int choice = 0;
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
            System.out.println("Could not find python script.");
        }
    }
}