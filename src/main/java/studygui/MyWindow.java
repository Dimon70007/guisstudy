package studygui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by OTBA}|{HbIu` on 06.10.16.
 */
public class MyWindow extends JFrame{
    private static Image space;
    private static Image workForFun;
    private static Image background;

    private static MyWindow myWindow;
    private static long lastFrameTime;
    private static float workForFunLeft=-100;
    private static float workForFunTop=-100;
    private static float workRorFunV=50;




    public static void main(String[] args) throws IOException {

        space= ImageIO.read(MyWindow.class.getResourceAsStream("pictures/space.png"));
        workForFun= ImageIO.read(MyWindow.class.getResourceAsStream("pictures/work for fun.jpg"));
        background= ImageIO.read(MyWindow.class.getResourceAsStream("pictures/mountain.jpg"));

        myWindow=new MyWindow();
        myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myWindow.setLocation(200,100);
        myWindow.setSize(800,600);
        //myWindow.setResizable(false);
        GameFiled gameFiled=new GameFiled();
        lastFrameTime=System.nanoTime();
//        gameFiled.setPreferredSize(new Dimension(9*32,9*32));
        myWindow.add(gameFiled);
//        myWindow.pack();
        myWindow.setVisible(true);
    }


    private static void onRepaint(Graphics g) {
        long currentTime=System.nanoTime();
        float deltaTime=(currentTime-lastFrameTime)*0.000000001f;
        lastFrameTime=currentTime;
        workForFunTop=workForFunTop+workRorFunV*deltaTime;
        workForFunLeft=workForFunLeft+workRorFunV*deltaTime;
        g.drawImage(background,0,0,800,600,null);

//       for (int x=1;x<11;x++){
//           for (int y=1;y<11;y++) {
//               g.drawImage(tmp, x*32-32, y*32-32, 32, 32, null);
//           }
//        }
        g.drawImage(workForFun,(int)workForFunLeft,(int)workForFunTop,null);

    }

    private static class GameFiled extends JComponent{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();//чтобы отрисовка происходила постоянно
        }
    }
}
