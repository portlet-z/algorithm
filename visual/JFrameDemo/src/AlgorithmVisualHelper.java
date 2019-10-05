import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author: 张新征
 * @date: 2019/10/5 9:43 上午
 */
public class AlgorithmVisualHelper {

    private AlgorithmVisualHelper(){}

    public static void setStrokeWidth(Graphics2D g2d, int w) {
        int strokeWidth = w;
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public static void strokeCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }

    public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }

    public static void setColor(Graphics2D g2d, Color color) {
        g2d.setColor(color);
    }

    public static void pause(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
