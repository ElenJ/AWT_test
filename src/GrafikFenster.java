import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class GrafikFenster extends Frame {
    private static Button stopButton = new Button("Stop Button");
    private static Button linieButton = new Button("Linie malen");
    private static Button rechteckButton = new Button("Rechteck malen");
    private static Button ellipseButton = new Button("Ellipse malen");
    private static Button fillButton = new Button("Gefüllt?");
    private ZEichenModus zModus = ZEichenModus.LINIE;
    private boolean istgefuellt = false;
    private int xAlt, yAlt;

    private ArrayList<Figur> figurListe = new ArrayList<Figur>();

    GrafikFenster(String title, int breite, int hoehe){
        super(title);
        setLayout(new FlowLayout());

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fensterBeenden();
            }
        });
        add(stopButton);

        linieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                zModus=ZEichenModus.LINIE;
            }
        });
        add(linieButton);

        rechteckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                zModus=ZEichenModus.RECHTECK;
            }
        });
        add(rechteckButton);

        ellipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                zModus=ZEichenModus.ELLIPSE;
            }
        });
        add(ellipseButton);

        fillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                istgefuellt = !istgefuellt;
            }
        });
        add(fillButton);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xAlt=e.getX(); yAlt=e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int xNeu = e.getX(); int yNeu = e.getY();
                Figur f = new Figur(zModus,istgefuellt,xAlt,yAlt,xNeu,yNeu);
                Graphics g = getGraphics();
                g.setColor(new Color(130,135,185));
                f.draw(g);
                figurListe.add(f);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fensterBeenden();
            }
        });

        setBackground(Color.lightGray);
        setSize(breite, hoehe);
        setVisible(true);

    } // Ende KOnstruktor
    void fensterBeenden(){
        dispose();
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        for (Figur f:figurListe)
            f.draw(g);
    }
}
