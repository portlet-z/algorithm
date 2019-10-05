import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author: 张新征
 * @date: 2019/10/5 10:23 上午
 */
public class AlgorithmVisualizer {

    private Circle[] circles;
    private AlgorithmFrame frame;
    private boolean isAnimated = true;

    public AlgorithmVisualizer(int sceneWidth, int sceneHeight, int N) {
        circles = new Circle[N];
        int R = 50;
        for (int i=0; i<N; i++) {
            int x = (int)(Math.random() * (sceneWidth - 2*R)) + R;
            int y = (int)(Math.random() * (sceneHeight - 2*R)) + R;
            int vx = (int)(Math.random() * 11) - 5;
            int vy = (int)(Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }

        EventQueue.invokeLater(() -> {
            frame = new AlgorithmFrame("Welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgorithmKeyListener());
            frame.addMouseListener(new AlgorithmMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    private void run() {
        while (true) {
            //绘制数据
            frame.render(circles);
            AlgorithmVisualHelper.pause(20);
            //更新数据
            if (isAnimated) {
                for (Circle circle : circles) {
                    circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
                }
            }
        }
    }

    private class AlgorithmKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent event) {

            if(event.getKeyChar() == ' ') {
                isAnimated = !isAnimated;
            }
        }
    }

    private class AlgorithmMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            event.translatePoint(0, -(frame.getBounds().height - frame.getCanvasHeight()));
            for (Circle circle : circles) {
                if (circle.contain(event.getPoint())) {
                    circle.isFilled = !circle.isFilled;
                }
            }
        }
    }

    public static void main(String[] args) {

        int sceneWidth = 500;
        int sceneHeight = 500;
        int N = 10;

        AlgorithmVisualizer visualizer = new AlgorithmVisualizer(sceneWidth, sceneHeight, N);
    }
}
