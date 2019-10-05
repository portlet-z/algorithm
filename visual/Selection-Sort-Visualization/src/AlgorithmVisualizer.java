import java.awt.*;

/**
 * @author: 张新征
 * @date: 2019/10/5 11:10 上午
 */
public class AlgorithmVisualizer {
    private SelectionSortData data;
    private AlgorithmFrame frame;
    private int DELAY = 500;
    public AlgorithmVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        data = new SelectionSortData(N, sceneHeight);
        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgorithmFrame("Selection Sort with Visualization", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run(){
        setData(0, -1, -1);
        for (int i=0; i<data.N(); i++) {
            //寻找[i, n)区间里的最小值索引
            int minIndex = i;
            setData(i, -1, minIndex);
            for (int j=i+1; j<data.N(); j++) {
                setData(i, j, minIndex);
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                    setData(i, j, minIndex);
                }
            }
            data.swap(minIndex, i);
            setData(i + 1, -1, -1);
        }

        setData(data.N(), -1, -1);
    }

    private void setData(int orderedIndex, int currentCompareIndex, int currentMinIndex) {
        data.orderedIndex = orderedIndex;
        data.currentCompareIndex = currentCompareIndex;
        data.currentMinIndex = currentMinIndex;

        frame.render(data);
        AlgorithmVisualHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        int sceneWidth = 300;
        int sceneHeight = 300;
        int N = 15;

        AlgorithmVisualizer visualizer = new AlgorithmVisualizer(sceneWidth, sceneHeight, N);
    }
}
