import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;

public class Edytor {

    static MyScroll scroll;
    static MyBar bar;
    static JFrame jf;
    static JMenuItem bg;
    static JMenuItem fg;
    static JMenuItem fs;
    static JMenuItem state;

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

        jf.setVisible(true);
        jf.setTitle("Prosty edytor-brak tytułu");

        BorderLayout borderLayout=new BorderLayout();
        jf.setLayout(borderLayout);
        JPanel panel=new JPanel();
        scroll=new MyScroll();

        jf.add(scroll,BorderLayout.CENTER);
        jf.add(panel,BorderLayout.SOUTH);

        MyIcon iconfg=new MyIcon(0,5,Edytor.scroll.textArea.getForeground());
        fg=new JMenuItem("  fg");
        fg.setIcon(iconfg);

        MyIcon iconbg=new MyIcon(0,5,Edytor.scroll.textArea.getBackground());
        bg=new JMenuItem("  bg");
        bg.setIcon(iconbg);


        fs=new JMenuItem("12");

        state=new JMenuItem("new");


        panel.add(fg);
        panel.add(bg);
        panel.add(fs);
        panel.add(state);



        jf.pack();

        bar=new MyBar();
        jf.setJMenuBar(bar);

    }

}
