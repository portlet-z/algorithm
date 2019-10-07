/**
 * @author: 张新征
 * @date: 2019/10/7 7:30 下午
 */
public class InsertionSortData {

    private int[] numbers;
    /**
     * [0...orderedIndex)是有序的
     */
    public int orderedIndex = -1;
    public int currentIndex = -1;

    public InsertionSortData(int N, int randomBound) {
        numbers = new int[N];

        for (int i=0; i<N; i++) {
            numbers[i] = (int)(Math.random() * randomBound) + 1;
        }
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
