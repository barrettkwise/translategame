import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
//this program translates the word/phrases
public class translate {
    private String text;
    
    public translate () {
        this.langFrom = ""; 
        this.langTo = "";
        this.text = "";
    }
    
    public translate (String langFrom, String langTo, String text) {
        langFrom = this.langFrom;
        langTo = this.langTo;
        text = this.text;
    }
    
    public static String translate(String langFrom, String langTo, String text) throws IOException {
        //connection to web script
        String urlStr = "https://script.google.com/a/nhrec.org/macros/s/AKfycbylWW25DK78W092P0na5OdKfmuwpYK-YF51O106/exec" +
            "?q=" + URLEncoder.encode(text, "UTF-8") +
            "&target=" + langTo +
            "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        while ((text = in.readLine()) != null) {
            response.append(text);
        }
        in.close();
        return response.toString();
    }
    
    //all sets
    public void setInitLang(String langFrom) {
        this.langFrom = langFrom;
    }

    public void setEndLang(String langTo) {
        this.langTo = langTo;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    //all gets
    public String getInitLang() {
        return langFrom;
    }

    public String getEndLang() {
        return langTo;
    }
    
    public String getText() {
        return text;
    }
}