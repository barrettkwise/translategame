import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//this program makes it easier for the user to 
//select their language in game 1 and 2
public class langsel {
    private String retlang;
    private String retlang2;
    private String setlang;
    public langsel() {
        this.retlang = "";
        this.retlang2 = "";
        this.setlang = "";
    }

    public langsel (String setlang) {
        this.setlang = setlang;
        try {
            //lang code array
            ArrayList <String> lang = new ArrayList <String> ();
            //languages array
            ArrayList <String> lang2 = new ArrayList <String> ();
            Scanner in = new Scanner (System.in);
            Scanner in2 = new Scanner (System.in);
            //read file name from standard input
            //overwrite scanner to read file
            File file = new File("lang.txt");
            in = new Scanner(file);

            File file2 = new File("lang2.txt");
            in2 = new Scanner(file2);
            while (in.hasNextLine() == true && in2.hasNextLine() == true) {
                //putting lang codes and lang in array
                String l = in.nextLine();
                String h = in2.nextLine();
                lang2.add(h);
                lang.add(l);
            }
            //compare userlang and all lang to find lang
            for (int i = 0; i < 107; i++) {
                String q = lang2.get(i);
                String p = lang.get(i);
                if (this.setlang.equalsIgnoreCase(q) == true) {
                    retlang2 = q;
                    retlang = p;
                }
            }
        }

        catch(IOException e) {
            System.out.println("File does not exist.");
        }
    }

    public void setLang(String setlang) {
        this.setlang = setlang;
    }

    public String getLang() {
        return this.retlang;
    }

    public String getLang2() {
        return this.retlang2;
    }
}