import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu file,edit,format,color;
    JMenuItem nnew,open,save,saveAs,exit;
    FunctionHandler functionHandler=new FunctionHandler(this);


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
        nnew.addActionListener(this);
        nnew.setActionCommand("New");
        file.add(nnew);

        open=new JMenuItem("Open");
        open.addActionListener(this);
        open.setActionCommand("Open");
        file.add(open);

        save=new JMenuItem("Save");
        save.addActionListener(this);
        save.setActionCommand("Save");
        file.add(save);

        saveAs=new JMenuItem("SaveAs");
        saveAs.addActionListener(this);
        saveAs.setActionCommand("SaveAs");
        file.add(saveAs);

        exit=new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setActionCommand("Exit");
        file.add(exit);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        switch(command){
            case "New": functionHandler.newFile();break;
            case "Open": functionHandler.open();break;
            case "Save": functionHandler.save();break;
            case "SaveAs": functionHandler.saveAs();break;
            case "Exit": functionHandler.exit();break;

        }
    }
}
