import javax.swing.*;
import java.awt.*;

public class MyIcon implements Icon {
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(15,5,10,10);
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
