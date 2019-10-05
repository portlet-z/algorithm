import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * @author: 张新征
 * @date: 2019/10/5 11:10 上午
 */
public class AlgorithmVisualizer {
    // TODO: 创建自己的数据
    private Object data;        // 数据
    private AlgorithmFrame frame;    // 视图

    public AlgorithmVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        // TODO: 初始化数据

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgorithmFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        // TODO: 编写自己的动画逻辑
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter { }
    private class AlgoMouseListener extends MouseAdapter { }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgorithmVisualizer visualizer = new AlgorithmVisualizer(sceneWidth, sceneHeight);
    }
}
