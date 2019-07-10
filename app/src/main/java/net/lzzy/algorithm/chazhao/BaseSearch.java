package net.lzzy.algorithm.chazhao;

public abstract class BaseSearch <T extends Comparable<? super T>> {
    long runtime;//运行时长
    int compareCount;//比较次数
    int swapCount;//交换次数
    T[] items;

    BaseSearch(T items[]) {
        this.items = items;
    }

    protected BaseSearch() {
    }

    boolean equal(T a, T b) {
        compareCount++;
        return a.compareTo(b) == 0;
    }

    int compare(T a, T b) {
        compareCount++;
        return a.compareTo(b);
    }

    public abstract int search(T key);

    public long getDuration() {
        return runtime;
    }

    public void setDuration(long runtime) {
        this.runtime = runtime;
    }

    public int getCompareCount() {
        return compareCount;
    }

    public void setCompareCount(int compareCount) {
        this.compareCount = compareCount;
    }


    public int getSwapCount() {
        return swapCount;
    }

    public void setSwapCount(int swapCount) {
        this.swapCount = swapCount;
    }
}
