package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class History {

    private BufferedWriter file ;
    public  void save (double res){
        String home  = System.getProperty("user.home");
        String filePath = String.valueOf(Paths.get(home,"Desktop","history.log" ));
        try {
            file = new BufferedWriter(new FileWriter(filePath,true));
            file.write(String.valueOf(res));
            file.newLine();
            file.flush();
        }
        catch (IOException e){
            System.out.println("Error Writing history: " + e.getMessage());
        }
    }

    public void closeFile(){
        try {
            if (file != null)
                file.close();
        }
        catch (IOException e){
            System.out.println("Error Writing history: " + e.getMessage());
        }
    }
}
