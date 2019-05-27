import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class MyBar extends JMenuBar {
    String lastLocation = "D:\\GUI\\Zad18 Edytor\\src";
    String checkfile = null;


    public MyBar() {
//File--------
        JMenu file = new JMenu("File");
        JMenuItem componentsF[] = {
                new JMenuItem("Open", 'o'),
                new JMenuItem("Save", 's'),
                new JMenuItem("Save As", 'a')};
        componentsF[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        componentsF[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        componentsF[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));


//Open------
        componentsF[0].addActionListener((e) -> {
            open();
        });
//Save as------
        componentsF[2].addActionListener((e) -> {
            saveAs();
        });
//Save-------
        componentsF[1].addActionListener((e)->{
            save();
        });

        for (JMenuItem component : componentsF) {
            file.add(component);
        }
        JPopupMenu.Separator separator = new JPopupMenu.Separator();
        separator.setForeground(Color.red);
        file.add(separator);
        JMenuItem exit;
        file.add(exit = new JMenuItem("Exit", 'x'));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
//Exit-------
        exit.addActionListener((e)->{
            System.exit(0);
        });
        this.add(file);
//edit------
        JMenu edit = new JMenu("Edit");
        JMenu adresy = new JMenu("Adresy");
        edit.add(adresy);
        JMenuItem componentsE[] = {
                new JMenuItem("Praca",'P'),
                new JMenuItem("Dom",'D'),
                new JMenuItem("Szkoła",'S')};
        componentsE[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
        componentsE[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
        componentsE[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));

        componentsE[0].addActionListener((e)->{
            pasteAdress("Brak");
        });

        componentsE[1].addActionListener(e -> {
            pasteAdress("Warszawa Czerniakowska 22");
        });

        componentsE[2].addActionListener((e)->{
            pasteAdress("Warszawa Koszykowa 86");
        });

        for (JMenuItem component : componentsE) {
            adresy.add(component);
        }
        this.add(edit);
//option-----
        JMenu option = new JMenu("Option");

        ColorMenu foreground=new ColorMenu("Foreground");
        JMenu Background=new ColorMenu("Background");
        JMenu fontSize=new JMenu("Font size");
        option.add(foreground);
        option.add(Background);
        option.add(fontSize);


        for(int i=0;i<foreground.radioButons.length;i++)
            foreground.radioButons[i].addActionListener((e)->{
                
                Edytor.scroll.textArea.setForeground(foreground.colors[]);
            });




        this.add(option);

    }

    public void pasteAdress(String a){
        Edytor.scroll.textArea.insert(a,Edytor.scroll.textArea.getCaretPosition());
    }

    public void saveAs(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(lastLocation));
        fileChooser.showOpenDialog(MyBar.this);
        checkfile = fileChooser.getSelectedFile().getAbsoluteFile().toString();
        lastLocation = fileChooser.getSelectedFile().getAbsolutePath();
        Edytor.jf.setTitle("Prosty edytor-"+checkfile);
        try {
            FileWriter fileWriter = new FileWriter(checkfile);
            fileWriter.write(Edytor.scroll.textArea.getText().toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void open(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(lastLocation));
        fileChooser.showOpenDialog(MyBar.this);
        fileChooser.getSelectedFile().getAbsoluteFile();
        checkfile = fileChooser.getSelectedFile().getAbsoluteFile().toString();
        lastLocation = fileChooser.getSelectedFile().getAbsolutePath();
        Edytor.jf.setTitle("Prosty edytor-"+checkfile);
        try {
            FileReader fileReader = new FileReader(checkfile);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; (i = fileReader.read()) > 0; ) {
                sb.append((char) i);
            }
            Edytor.scroll.textArea.setText(sb.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void save(){
        try {
            if(checkfile==null){
                saveAs();
            }else {
                FileWriter fileWriter = new FileWriter(checkfile);
                fileWriter.write(Edytor.scroll.textArea.getText().toString());
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
