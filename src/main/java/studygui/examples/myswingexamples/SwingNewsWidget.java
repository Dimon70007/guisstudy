package studygui.examples.myswingexamples;

import org.omg.CORBA.Object;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Date;

/**
 * Created by OTBA}|{HbIu` on 07.10.16.
 */
public class SwingNewsWidget {

    public static void main(String[] args) {
        initNews(args);
    }

    private static void initNews(String[] args) {

        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table=new JTable(new RssFeedTableModel());
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0,0));
        table.setRowHeight(30);
        table.setTableHeader(null);

        table.setDefaultRenderer(String.class, new DefaultTableCellRenderer(){
            Color oddColor=new Color(0x25,0x25,0x25);
            Color evenColor=new Color(0x1a,0x1a,0x1a);
            Color titleColor=new Color(0x3a,0xa2,0xd7);

            public Component getTableCellRendererComponent(JTable table,
                                                           Object value,
                                                           boolean isSelected,
                                                           boolean hasFocus,
                                                           int row,
                                                           int column){

                super.getTableCellRendererComponent(table,
                        value,isSelected,hasFocus,row,column);
                setBackground(row%2==0?oddColor:evenColor);
                setForeground(titleColor);
                setFont(getFont());
                return this;
            }
        });

        JScrollPane scrollPane=new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));

        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);

        JLabel titleLabel1=new JLabel("Xakep RSS");
        Font titleFont = new Font("Arial",Font.BOLD,20);
        titleLabel1.setFont(titleFont);
        titleLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel1.setForeground(Color.WHITE);
        titleLabel1.setPreferredSize(new Dimension(0,40));
        frame.getContentPane().add(titleLabel1,BorderLayout.NORTH);

        addListener(titleLabel1,frame);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                frame.setShape(new RoundRectangle2D.Double(0,0,frame.getWidth(),
                        frame.getHeight(),20,20));
            }
        });

        frame.setSize(520,300);
        frame.setUndecorated(true);
        frame.setOpacity(0.85f);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });




    }

    private static void addListener(JComponent titleLabel1, JFrame frame) {
        MouseAdapter listener=new MouseAdapter() {
            int startX;
            int startY;

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON1){
                    startX=e.getX();
                    startY=e.getY();
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point currCoords=e.getLocationOnScreen();
                frame.setLocation(currCoords.x-startX,currCoords.y-startY);

            }
        };
        titleLabel1.addMouseListener(listener);
        titleLabel1.addMouseMotionListener(listener);
    }

    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return Date.class;
        }
        return Object.class;
    }
}
