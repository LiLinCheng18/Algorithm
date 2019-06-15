package net.lzzy.algorithm.algorlib;

public class DirectSort {

    private Integer[] items;
    private  int compareCount;

    DirectSort (Integer[] items){
        this.items = items;
        compareCount = 0;
    }

    boolean bigger(Integer a, Integer b){
        compareCount ++;
        return a.compareTo(b) > 0;
    }

    public long getDuration(){
        return getDuration();
    }

    public int getCompareCount(){
        return compareCount;
    }
}
