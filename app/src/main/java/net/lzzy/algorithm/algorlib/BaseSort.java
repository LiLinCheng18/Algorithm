package net.lzzy.algorithm.algorlib;

public abstract class BaseSort <T extends Comparable<? super T>>{
    //<T extends **********<T>>extends ******<T>
    long runtime;//运行时长
    int compareCount;//比较次数
    int movCount;//移动次数
    int swapCount;//交换次数
    T[] items;

     BaseSort(T items[]) {
        this.items = items;
    }

    boolean  bigger(T a, T b){
         compareCount++;
         return a.compareTo(b)>0;
    }

    int compareTo(Object o) {
        return 0;
    }

     long getDuration() {          //运行时长
        return runtime;
    }

     public int getCompareCount() {      //比较次数
        return compareCount;
    }

     public int getMovCount() {          //移动次数
        return movCount;
    }

     public int getSwapCount() {         //交换次数
        return swapCount;
    }

      boolean compareTow(T a,T b) {       //两个数比较大小
        compareCount++;
        return a.compareTo(b)>0;
    }

     void swap(int j, T kIndex) {           //两个数交换
        swapCount++;
        kIndex = items[j];
        items[j] = items[j + 1];
        items[j + 1] = kIndex;
    }

     void move() {
        movCount++;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public abstract void sort();

}
