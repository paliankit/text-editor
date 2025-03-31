import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FunctionHandler {

    GUI gui;
    String filename;
    String fileLocation;

    public FunctionHandler(GUI gui){
        this.gui=gui;
    }

    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
    }

    public void open() {
        FileDialog fileDialog=new FileDialog(gui.window,"Open",FileDialog.LOAD);
        fileDialog.setVisible(true);
        if(fileDialog.getFile()!=null){
            filename=fileDialog.getFile();
            fileLocation=fileDialog.getDirectory();
            System.out.println(filename);
            System.out.println(fileLocation);
            gui.window.setTitle(filename);
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation + filename));
            gui.textArea.setText("");
            String line=br.readLine();
            while(line!=null){
                gui.textArea.append(line+ "\n");
                line=br.readLine();
            }
            br.close();
        }catch(Exception e){
            System.out.println("Something's wrong with the open functionality");
        }
    }
}
