/**
 * @author: 张新征
 * @date: 2019/10/5 9:42 下午
 */
public class SelectionSortData {

    private int[] numbers;

    /**
     * [0, orderedIndex)是有序的
     */
    public int orderedIndex = -1;
    /**
     * 当前找到的最小元素的索引
     */
    public int currentMinIndex = -1;
    /**
     * 当前正在比较的元素的索引
     */
    public int currentCompareIndex = -1;

    public SelectionSortData(int N, int randomBound) {
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
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


}
