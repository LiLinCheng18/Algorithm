package net.lzzy.algorithm.algorlib;

public class BubbleSort <T extends Comparable<T>> extends BaseSort {
    public BubbleSort(T[] items) {
        super(items);
    }
    //冒泡排序////////////////////////
    @Override
    public void sort() {
        int sum=0;
        for (int i=0;i<items.length;i++){
            for(int j=0;j<items.length-1-i;j++){
                if(compareTow((int)items[j],(int)items[j+1])){
                    swap(j,sum);
                }
            }
        }
    }
}
