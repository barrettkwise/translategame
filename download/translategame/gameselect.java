import java.io.IOException;
import java.util.Scanner;

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
            String name = System.getProperty("user.name");
            //start python
            String path = "C:/Users/" + name + "/Downloads/translategame-master/download/ngramcount.exe";
            ProcessBuilder pb = new ProcessBuilder(path);
            Process p = pb.start();
            game1 g = new game1();
            game2 f = new game2();
            int choice = 0;
            do {
                System.out.println("Type 1 for game1 (words) or 2 for game2 (phrases)");
                choice = in.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("No game assigned to that number.");
                }
            }
            while (choice != 1 && choice != 2);
            if (choice == 1) {
                g.game1();
            }
            else {
                f.game2();
            }
        }
        catch(IOException e) {
            System.out.println("Could not find Python script.");
        }
    }
}
