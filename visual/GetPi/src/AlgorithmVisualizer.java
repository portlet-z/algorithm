import java.awt.*;

/**
 * @author: 张新征
 * @date: 2019/10/5 11:10 上午
 */
public class AlgorithmVisualizer {
    private MonteCarloPiData data;
    private AlgorithmFrame frame;
    private int N;
    private static int DELAY = 40;

    public AlgorithmVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        if (sceneWidth != sceneHeight) {
            throw new IllegalArgumentException("This demo must be run in a square");
        }
        Circle circle = new Circle(sceneWidth/2, sceneHeight/2, sceneHeight/2);
        data = new MonteCarloPiData(circle);
        this.N = N;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgorithmFrame("Get Pi With Monte Carlo", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run(){
        for (int i=0; i<N; i++) {
            if (i % 100 == 0) {
                frame.render(data);
                AlgorithmVisualHelper.pause(DELAY);
                System.out.println(data.estimatePi());
            }
            int x = (int)(Math.random() * frame.getCanvasWidth());
            int y = (int)(Math.random() * frame.getCanvasHeight());

            data.addPoint(new Point(x, y));
        }
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10000;

        AlgorithmVisualizer visualizer = new AlgorithmVisualizer(sceneWidth, sceneHeight, N);
    }
}
