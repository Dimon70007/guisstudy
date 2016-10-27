package studygui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by OTBA}|{HbIu` on 07.10.16.
 */
public class Buttons extends JFrame {
    JPanel panel;
    ImageIcon tick;
    ImageIcon cross;
    JButton btn;
    JButton tickBtn;
    JLabel crossBtn;
    ClassLoader ldr;
    public Buttons() throws HeadlessException {

        super("Swing window");
        ldr=this.getClass().getClassLoader();

        //System.out.println(Buttons.class.getResource("Buttons.class"));
        tick=new ImageIcon(Buttons.class.getResource("res/0.png"));
        cross=new ImageIcon(Buttons.class.getResource("res/bomb.png"));
        btn=new JButton("push me");
        tickBtn=new JButton(tick);
        crossBtn=new JLabel(cross);
        this.panel = new JPanel();
        panel.add(btn);
        panel.add(tickBtn);
        panel.add(crossBtn);
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);
        pack();

    }

    public static void main(String[] args) {
        Buttons gui=new Buttons();
    }
}
