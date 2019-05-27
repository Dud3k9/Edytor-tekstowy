import javax.swing.*;
import java.awt.*;

public class MyScroll extends ScrollPane {
    JTextArea textArea;
    public MyScroll(){
        textArea=new JTextArea();
        this.add(textArea);
    }
}