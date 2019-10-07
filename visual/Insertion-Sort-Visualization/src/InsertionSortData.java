import java.util.Arrays;

/**
 * @author: 张新征
 * @date: 2019/10/7 7:30 下午
 */
public class InsertionSortData {

    public enum Type{
        DEFAULT,
        NEAR_ORDERED;
    }
    private int[] numbers;
    /**
     * [0...orderedIndex)是有序的
     */
    public int orderedIndex = -1;
    public int currentIndex = -1;

    public InsertionSortData(int N, int randomBound, Type type) {
        numbers = new int[N];

        for (int i=0; i<N; i++) {
            numbers[i] = (int)(Math.random() * randomBound) + 1;
        }

        if (type == Type.NEAR_ORDERED) {
            Arrays.sort(numbers);
            int swapTime = (int) (0.02 * N);
            for (int i = 0; i < swapTime; i++) {
                int a = (int)(Math.random() * N);
                int b = (int)(Math.random() * N);
                swap(a, b);
            }
        }
    }

    public InsertionSortData(int N, int randomBound) {
        this(N, randomBound, Type.DEFAULT);
    }

    public int N() {
        return numbers.length;
    }

    public int get(int index) {
        if (index < 0 || index >= numbers.length) {
            throw new IllegalArgumentException("Invalid index to access Sort Data");
        }

        return numbers[index];
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= numbers.length || j < 0 || j >= numbers.length) {
            throw new IllegalArgumentException("Invalid index access to Sort Data");
        }
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
