package net.lzzy.algorithm.algorlib;

public class HillRank<T extends Comparable<T>> extends BaseSort<T> {
    public HillRank(T[] items) {
        super(items);
    }

    //希尔排序////////////////////////
    @Override
    public void sort() {
        int lenn=items.length;
        int g=lenn/2;
        while (g>0){
            for(int i=g;i<items.length;i+=g){
                int j=i-g;
                if(compareTow(items[i],items[j])){
                    compareCount++;
                }
                T tmp= items[i];
                while (j>=0 && compareTow(items[j],tmp)){
                    items[j+g]=items[j];
                    j-=g;
                    swapCount++;
                }
                items[j+g]=tmp;
            }g=g/2;
        }
    }

}




