import java.awt.*;

public class FunctionHandler {

    GUI gui;

    public FunctionHandler(GUI gui){
        this.gui=gui;
    }

    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
    }

    public void open(){
        FileDialog fileDialog=new FileDialog(gui.window,"Open",FileDialog.LOAD);
        fileDialog.setVisible(true);
    }
}
