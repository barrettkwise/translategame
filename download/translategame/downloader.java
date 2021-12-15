import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

//downloads python packages
public class downloader {
    public static void downloader () throws IOException {
        File file = new File("status.txt");
        try {
            String read = "";
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                read = in.nextLine();
                if (read.equalsIgnoreCase("yes")) {
                    String app = "notepad.exe";
                    String cmd = "status.txt";
                    ProcessBuilder pb = new ProcessBuilder(app, cmd);
                    pb.start();
                    System.out.println("Module already installed.");
                }
            }
            in.close();
        }
        
        catch(IOException e) {
            System.out.println("File not found, starting process.");
            String app = "py";
            String cmd = "-m pip install requests";
            ProcessBuilder pb = new ProcessBuilder(app, cmd);
            pb.start();
            file.createNewFile();
            FileWriter filewrite = new FileWriter(file);
            BufferedWriter write = new BufferedWriter(filewrite);
            write.write("yes");
            write.close();
            System.out.println("Module installed.");
        }
    }
}

