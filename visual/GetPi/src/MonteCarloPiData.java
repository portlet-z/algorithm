import java.awt.*;
import java.util.LinkedList;

/**
 * @author: 张新征
 * @date: 2019/10/5 11:58 上午
 */
public class MonteCarloPiData {
    private Circle circle;
    private LinkedList<Point> points;
    private int insideCircle = 0;

    public MonteCarloPiData(Circle circle) {
        this.circle = circle;
        this.points = new LinkedList<>();
    }

    public Circle getCircle() {
        return circle;
    }

    public Point getPoint(int i) {
        if (i<0 || i>=points.size()) {
            throw new IllegalArgumentException("out of bound in getPoint!");
        }
        return points.get(i);
    }

    public int getPointNumber() {
        return points.size();
    }

    public void addPoint(Point p) {
        points.add(p);
        if (circle.contain(p)) {
            insideCircle++;
        }
    }

    public double estimatePi() {
        if (points.size() == 0) {
            return 0.0;
        }
        int circleArea = insideCircle;
        int squareArea = points.size();
        return (double)circleArea * 4 / squareArea;
    }
}
