import javax.swing.*;
import java.awt.*;

public class Edytor {

    static MyScroll scroll;
    static MyBar bar;
    static JFrame jf;

public static void main(String args[]){
    new Edytor();
}
public Edytor(){
    SwingUtilities.invokeLater(()->edytor());

}

    public void edytor(){
        jf=new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setPreferredSize(new Dimension(700,500));
        jf.setResizable(true);
        jf.setLocation(500,200);
        jf.pack();
        jf.setVisible(true);
        jf.setTitle("Prosty edytor-brak tytułu");


        scroll=new MyScroll();
        jf.add(scroll);

        bar=new MyBar();
        jf.setJMenuBar(bar);

    }

}
