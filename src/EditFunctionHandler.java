public class EditFunctionHandler {

    GUI gui;

    public EditFunctionHandler(GUI gui){
        this.gui=gui;
    }

    public void undo(){
        gui.undoManager.undo();
    }

    public void redo(){
        gui.undoManager.redo();
    }

}
