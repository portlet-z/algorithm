import java.awt.*;
import java.util.Arrays;

/**
 * @author: 张新征
 * @date: 2019/10/5 11:10 上午
 */
public class AlgorithmVisualizer {
    private int[] money;
    private AlgorithmFrame frame;
    private static int DELAY = 40;

    public AlgorithmVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        money = new int[100];
        for (int i=0; i<money.length; i++) {
            money[i] = 100;
        }

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgorithmFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        while (true) {
            Arrays.sort(money);
            frame.render(money);
            AlgorithmVisualHelper.pause(DELAY);
            for (int k=0; k<50; k++) {
                for (int i=0; i<money.length; i++) {
                    //if (money[i] > 0) {
                        int j = (int)(Math.random() * money.length);
                        money[i] -= 1;
                        money[j] += 1;
                    //}
                }
            }
        }
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 1000;

        AlgorithmVisualizer visualizer = new AlgorithmVisualizer(sceneWidth, sceneHeight);
    }
}
