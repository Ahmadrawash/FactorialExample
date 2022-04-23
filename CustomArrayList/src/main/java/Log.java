import java.io.BufferedWriter;
import java.io.FileWriter;

//contains methods required to log messages to Log.txt file. The message are appended to the file.
public class Log {

    String filename ="";
    FileWriter fw;
    BufferedWriter bw;

    Log(String filename)
    {
        this.filename = filename;
    }

    public void writeToLog(String sentence)
    {
        try
        {
            fw = new FileWriter(filename, true); //append to file if exits
            bw = new BufferedWriter(fw);
            bw.write(sentence + "\n");
            bw.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
