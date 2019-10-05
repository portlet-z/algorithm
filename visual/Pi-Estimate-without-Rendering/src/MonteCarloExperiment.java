import java.awt.*;

/**
 * @author: 张新征
 * @date: 2019/10/5 12:09 下午
 */
public class MonteCarloExperiment {

    private int squareSide;
    private int N;

    public MonteCarloExperiment(int squareSide, int N) {
        if (squareSide <= 0 || N <= 0) {
            throw new IllegalArgumentException("squareSide and N must larger than zero");
        }
        this.squareSide = squareSide;
        this.N = N;
    }

    public void run() {
        Circle circle = new Circle(squareSide/2, squareSide/2, squareSide/2);
        MonteCarloPiData data = new MonteCarloPiData(circle);
        for (int i=0; i<N; i++) {
            if (i % 10000 == 0) {
                System.out.println(data.estimatePi());
            }
            int x = (int)(Math.random() * squareSide);
            int y = (int)(Math.random() * squareSide);
            data.addPoint(new Point(x, y));
        }
    }

    public static void main(String[] args) {
        int squareSide = 800;
        int N = 10000000;
        MonteCarloExperiment exp = new MonteCarloExperiment(squareSide, N);
        exp.run();
    }
}
