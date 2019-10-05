/**
 * @author: 张新征
 * @date: 2019/10/5 12:18 下午
 */
public class ThreeGatesExperiment {

    private int N;

    public ThreeGatesExperiment(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be larger than 0");
        }
        N = n;
    }

    public void run(boolean changeDoor) {
        int wins = 0;
        for (int i=0; i<N; i++) {
            if (play(changeDoor)) {
                wins++;
            }
        }
        System.out.println(changeDoor ? "Change" : "Not Change");
        System.out.println("winning rate:" + (double)wins/N);
    }

    private boolean play(boolean changeDoor) {
        int prizeDoor = (int)(Math.random() * 3);
        int playerChoice = (int)(Math.random() * 3);
        if (playerChoice == prizeDoor) {
            return changeDoor ? false : true;
        } else {
            return changeDoor ? true : false;
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        ThreeGatesExperiment exp = new ThreeGatesExperiment(N);
        exp.run(true);
        System.out.println();
        exp.run(false);
    }
}
