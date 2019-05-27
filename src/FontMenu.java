import javax.swing.*;
import java.awt.*;

public class FontMenu extends JMenu {

    Font[] fonts = {new Font("8", Font.PLAIN, 8),
            new Font("10", Font.PLAIN, 10),
            new Font("12", Font.PLAIN, 12),
            new Font("14", Font.PLAIN, 14),
            new Font("16", Font.PLAIN, 16),
            new Font("18", Font.PLAIN, 18),
            new Font("20", Font.PLAIN, 20),
            new Font("22", Font.PLAIN, 22),
            new Font("24", Font.PLAIN, 24)};

    JRadioButtonMenuItem[] radiobutton = {
            new JRadioButtonMenuItem("8"),
            new JRadioButtonMenuItem("10"),
            new JRadioButtonMenuItem("12"),
            new JRadioButtonMenuItem("14"),
            new JRadioButtonMenuItem("16"),
            new JRadioButtonMenuItem("18"),
            new JRadioButtonMenuItem("20"),
            new JRadioButtonMenuItem("22"),
            new JRadioButtonMenuItem("24")};

    public FontMenu(String s) {
        super(s);


    int i = 0;
        for(
    JRadioButtonMenuItem component:radiobutton)

    {
        component.setFont(fonts[i]);
        this.add(component);
        i++;
    }
}
}
