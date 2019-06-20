package net.lzzy.algorithm.algorlib;

public abstract class BaseSort <T extends Comparable<T>>{
    //<T extends **********<T>>extends ******<T>
    long runtime;//运行时长
    int compareCount;//比较次数
    int movCount;//移动次数
    int swapCount;//交换次数
    Integer[] items;

     BaseSort(Integer items[]) {
        this.items = items;
    }
     int compareTo(Object o) {
        return 0;
    }

     long getRutime() {
        return runtime;
    }

     int getCompareCount() {      //比较次数
        return compareCount;
    }

     int getMovCount() {          //移动次数
        return movCount;
    }

     int getSwapCount() {         //交换次数
        return swapCount;
    }

     boolean compareTow(int a, int b) {       //两个数比较大小
        compareCount++;
        return a > b ? true : false;
    }

     void swap(int j, int kIndex) {           //两个数交换
        swapCount++;
        kIndex = items[j];
        items[j] = items[j + 1];
        items[j + 1] = kIndex;
    }

     void move() {
        movCount++;
    }

     Integer[] returnResoult() {              //返回排序的结果
        return items;
    }

     abstract void sort();



}
