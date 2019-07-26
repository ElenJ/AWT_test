import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fenster extends Frame {
    private static Button stopButton = new Button("Stop Button");
    private static Button tuWasButton = new Button("TuWas");
    Fenster() {
        super("Fenster zum Hof");
        setLayout(new FlowLayout());

        stopButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        fensterBeenden();
                    }
                });
        add(stopButton);

        tuWasButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        tuWas();
                    }
                });
        add(tuWasButton);
        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        fensterBeenden();}
                    });
        setBackground(Color.lightGray);
        setSize(500,700);
        setVisible(true);
                } //ende des Konstruktors
    void fensterBeenden(){
        dispose();
    }
    void tuWas(){
        Font font = new Font("CASTELLAR",Font.BOLD,36);
        Graphics g = getGraphics();
        g.setColor(Color.RED);
        g.setFont(font);
        g.drawString("Tu was",100,100);
        g.setColor(Color.ORANGE);
        g.fillOval(200,200,200,150);
        g.setColor(Color.black);
        for (int i=150; i>=50;i -= 10)
            g.drawOval(200,200,i+50,i);
        g.setColor(Color.CYAN);
        g.drawOval(300,500,50,50);
       }

}
