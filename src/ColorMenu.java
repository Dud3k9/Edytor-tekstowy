import javax.swing.*;
import java.awt.*;

public class ColorMenu extends JMenu {

    Color colors[]={Color.green,Color.ORANGE,Color.red,Color.black,Color.white,Color.yellow,Color.blue};

    JRadioButtonMenuItem[] radioButons={
            new JRadioButtonMenuItem("  green"),
            new JRadioButtonMenuItem("  orange"),
            new JRadioButtonMenuItem( "  red"),
            new JRadioButtonMenuItem("  black"),
            new JRadioButtonMenuItem("  white"),
            new JRadioButtonMenuItem("  yelow"),
            new JRadioButtonMenuItem("  blue")};

    public ColorMenu(String s){
        super(s);


        ButtonGroup buttonGroup=new ButtonGroup();
        int i=0;
        for(JRadioButtonMenuItem component:radioButons){
            component.setIcon(new MyIcon());
            component.setForeground(colors[i]);
            buttonGroup.add(component);
            this.add(component);
            i++;
        }

    }
}
