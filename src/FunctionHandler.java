import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

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
        filename=null;
        fileLocation=null;
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

    public void save(){
        if(filename==null){
            saveAs();
        }else{
            try{
                FileWriter fileWriter=new FileWriter(fileLocation+filename);
                fileWriter.write(gui.textArea.getText());
                fileWriter.close();
            }catch (Exception e){
                System.out.println("Something's wrong with the save functionality");
            }
        }
    }

    public void saveAs(){
        FileDialog fileDialog=new FileDialog(gui.window,"Save",FileDialog.SAVE);
        fileDialog.setVisible(true);
        if(fileDialog.getFile()!=null){
            filename=fileDialog.getFile();
            fileLocation=fileDialog.getDirectory();
            gui.window.setTitle(filename);
        }
        try{
            FileWriter fileWriter=new FileWriter(fileLocation+filename);
            fileWriter.write(gui.textArea.getText());
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Something's wrong with the SaveAs functionality");
        }
    }

    public void exit(){
        System.exit(0);
    }
}
