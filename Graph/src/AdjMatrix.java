import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangxinzheng
 * @date 2020/10/8 15:27
 */
public class AdjMatrix {

    /**
     *顶点
     */
    private int V;
    /**
     *边
     */
    private int E;
    /**
     * 邻接矩阵
     */
    private int[][] adj;

    public AdjMatrix(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            adj = new int[V][V];
            E = scanner.nextInt();
            for (int i=0; i<E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                sb.append(adj[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix);
    }
}
