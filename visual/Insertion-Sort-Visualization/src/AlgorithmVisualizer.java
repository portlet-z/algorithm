import java.awt.*;

/**
 * @author: 张新征
 * @date: 2019/10/5 11:10 上午
 */
public class AlgorithmVisualizer {
    private InsertionSortData data;
    private AlgorithmFrame frame;
    private int DELAY = 40;

    public AlgorithmVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        data = new InsertionSortData(N, sceneHeight);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgorithmFrame("Insertion Sort Visualization", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run(){
        setData(0, -1);
        for (int i = 0; i < data.N(); i++) {
            setData(i, i);
            for (int j = i; j > 0 && data.get(j) < data.get(j-1); j--) {
                data.swap(j, j-1);
                setData(i+1, j-1);
            }
        }
        setData(data.N(), -1);
    }

    private void setData(int orderedIndex, int currentIndex) {
        data.orderedIndex = orderedIndex;
        data.currentIndex = currentIndex;
        frame.render(data);
        AlgorithmVisualHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 80;
        AlgorithmVisualizer visualizer = new AlgorithmVisualizer(sceneWidth, sceneHeight, N);
    }
}
