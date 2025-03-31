import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu file,edit,format,color;
    JMenuItem nnew,open,save,saveAs,exit;


    public static void main(String[] args){
        new GUI();
    }

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        window.setVisible(true);
    }

    public void createWindow(){
        window=new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea(){
        textArea=new JTextArea();
        //window.add(textArea);
        scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar(){
        menuBar=new JMenuBar();
        window.setJMenuBar(menuBar);

        file=new JMenu("File");
        menuBar.add(file);

        edit=new JMenu("Edit");
        menuBar.add(edit);

        format=new JMenu("Format");
        menuBar.add(format);

        color=new JMenu("Color");
        menuBar.add(color);
    }

    public void createFileMenu(){
        nnew=new JMenuItem("New");
        file.add(nnew);

        open=new JMenuItem("Open");
        file.add(open);

        save=new JMenuItem("Save");
        file.add(save);

        saveAs=new JMenuItem("SaveAs");
        file.add(saveAs);

        exit=new JMenuItem("Exit");
        file.add(exit);

    }

}
