import java.awt.*;

/**
 * @author: 张新征
 * @date: 2019/10/5 11:39 上午
 */
public class Circle {
    private int x, y, r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean contain(Point point) {
        return Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2) <= r * r;
    }
}
