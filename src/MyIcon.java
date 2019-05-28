import javax.swing.*;
import java.awt.*;

public class MyIcon implements Icon {
    int x=15;
    int y=5;
    Color color=null;

    public MyIcon(){
        super();
    }

    public MyIcon(int x,int y,Color color){
        super();
        this.x=x;
        this.y=y;
        this.color=color;
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if(color!=null){
            g.setColor(color);
        }
        g.fillOval(this.x,this.y,10,10);
    }

    @Override
    public int getIconWidth() {
        return 0;
    }

    @Override
    public int getIconHeight() {
        return 0;
    }
}
