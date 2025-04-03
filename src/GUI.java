import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapp;
    JMenuBar menuBar;
    JMenu file,edit,format,color;
    JMenuItem nnew,open,save,saveAs,exit;
    JMenuItem wordWrap,fontArial,fontCSMS,fontTNR,fontSize8,fontSize12,fontSize16,fontSize18;
    JMenu font,fontSize;
    JMenuItem color1,color2,color3;
    FileFunctionHandler fileFunctionHandler =new FileFunctionHandler(this);
    FormatFunctionHandler formatFunctionHandler=new FormatFunctionHandler(this);
    ColorFunctionHandler colorFunctionHandler =new ColorFunctionHandler(this);


    public static void main(String[] args){
        new GUI();
    }

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();

        formatFunctionHandler.selectedFont="Arial";
        formatFunctionHandler.createFont(16);
        colorFunctionHandler.changeColor("White");

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

    public void createFormatMenu(){
        wordWrap=new JMenuItem("Word Wrap");
        wordWrap.addActionListener(this);
        wordWrap.setActionCommand("Word Wrap");
        format.add(wordWrap);

        font=new JMenu("Font");
        format.add(font);

        fontArial=new JMenuItem("Arial");
        fontArial.addActionListener(this);
        fontArial.setActionCommand("Arial");
        font.add(fontArial);

        fontCSMS=new JMenuItem("Comic Sans MS");
        fontCSMS.addActionListener(this);
        fontCSMS.setActionCommand("Comic Sans MS");
        font.add(fontCSMS);

        fontTNR=new JMenuItem("Times New Roman");
        fontTNR.addActionListener(this);
        fontTNR.setActionCommand("Times New Roman");
        font.add(fontTNR);

        fontSize=new JMenu("Font Size");
        format.add(fontSize);

        fontSize8=new JMenuItem("8");
        fontSize8.addActionListener(this);
        fontSize8.setActionCommand("8");
        fontSize.add(fontSize8);

        fontSize12=new JMenuItem("12");
        fontSize12.addActionListener(this);
        fontSize12.setActionCommand("12");
        fontSize.add(fontSize12);

        fontSize16=new JMenuItem("16");
        fontSize16.addActionListener(this);
        fontSize16.setActionCommand("16");
        fontSize.add(fontSize16);

        fontSize18=new JMenuItem("18");
        fontSize18.addActionListener(this);
        fontSize18.setActionCommand("18");
        fontSize.add(fontSize18);
    }

    private void createColorMenu() {
        color1=new JMenuItem("White");
        color1.addActionListener(this);
        color1.setActionCommand("White");
        color.add(color1);

        color2=new JMenuItem("Black");
        color2.addActionListener(this);
        color2.setActionCommand("Black");
        color.add(color2);

        color3=new JMenuItem("Blue");
        color3.addActionListener(this);
        color3.setActionCommand("Blue");
        color.add(color3);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        switch(command){
            case "New": fileFunctionHandler.newFile();break;
            case "Open": fileFunctionHandler.open();break;
            case "Save": fileFunctionHandler.save();break;
            case "SaveAs": fileFunctionHandler.saveAs();break;
            case "Exit": fileFunctionHandler.exit();break;
            case "Word Wrap": formatFunctionHandler.wordWrap();break;
            case "Arial": formatFunctionHandler.setFont(command);break;
            case "Comic Sans MS": formatFunctionHandler.setFont(command);break;
            case "Times New Roman": formatFunctionHandler.setFont(command);break;
            case "8": formatFunctionHandler.createFont(8);break;
            case "12": formatFunctionHandler.createFont(12);break;
            case "16": formatFunctionHandler.createFont(16);break;
            case "18": formatFunctionHandler.createFont(18);break;
            case "White": colorFunctionHandler.changeColor(command);break;
            case "Black": colorFunctionHandler.changeColor(command);break;
            case "Blue": colorFunctionHandler.changeColor(command);break;
        }
    }
}
