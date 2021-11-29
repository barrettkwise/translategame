import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;

//this program gathers the words to be translated
//for game 1
public class dictionary {
    private String line;

    public dictionary() {
        this.line = "";
    }

    public dictionary (String line) {   
        //getting word
        try {
            this.line = line;
            Random random = new Random();
            Scanner in = new Scanner (System.in);
            int count = 0;
            int rand = 1 + random.nextInt(8110);
            //read file name from standard input
            File file = new File("words.txt");
            //overwrite scanner to read file
            in = new Scanner(file);
            while (in.hasNextLine() && count != rand) {
                this.line = in.nextLine();
                count = count + 1;
            }
            in.close();
        }
        catch(IOException e) {
            System.out.println("File does not exist.");
        }
    }

    public String getLine() {
        return this.line;
    }
}