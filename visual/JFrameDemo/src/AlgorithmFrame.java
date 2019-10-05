import javax.swing.*;
import java.awt.*;

/**
 * @author: 张新征
 * @date: 2019/10/5 9:19 上午
 */
public class AlgorithmFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgorithmFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgorithmCanvas canvas = new AlgorithmCanvas();
        setContentPane(canvas);
        pack();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public AlgorithmFrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private Circle[] circles;
    public void render(Circle[] circles) {
        this.circles = circles;
        repaint();
    }

    private class AlgorithmCanvas extends JPanel {

        public AlgorithmCanvas() {
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            AlgorithmVisualHelper.setStrokeWidth(g2d, 1);
            AlgorithmVisualHelper.setColor(g2d, Color.RED);
            for (Circle circle : circles) {
                if (circle.isFilled) {
                    AlgorithmVisualHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                } else {
                    AlgorithmVisualHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                }
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
