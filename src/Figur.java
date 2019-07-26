import java.awt.*;
import java.awt.event.*;
import java.util.*;

enum ZEichenModus {LINIE, RECHTECK, ELLIPSE};
public class Figur {
    int x1, y1, x2, y2, x, y, w, h;
    ZEichenModus zModus;
    boolean istgefuellt;

    Figur(ZEichenModus zm, boolean g, int px1, int py1, int px2, int py2){
        zModus= zm;
        istgefuellt = g;
        x1=px1; y1=py1; x2= px2; y2=py2;
        w=Math.abs(px1-px2);
        h=Math.abs(py1-py2);
        x=Math.min(px1,px2);
        y=Math.min(py1,py2);
    }
    void draw(Graphics g){
        if (zModus==ZEichenModus.LINIE)
            g.drawLine(x1,y1,x2,y2);
        else if (zModus==ZEichenModus.RECHTECK)
            if(istgefuellt)
                g.fillRect(x,y,w,h);
            else
                g.drawRect(x,y,w,h);
        else if (zModus==ZEichenModus.ELLIPSE)
            if(istgefuellt)
                g.fillOval(x,y,w,h);
            else
                g.drawOval(x,y,w,h);
    }
}
