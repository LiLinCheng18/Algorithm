package net.lzzy.algorithm.algorlib;

import android.util.Log;

public class InsertSort<T extends Comparable<T>> extends BaseSort{

    public InsertSort(Integer[] items) {
        super(items);
    }

    @Override
    public void sort() {
        long current = System.currentTimeMillis();
        Log.e("curent", current + "");
        for(int i=1;i<items.length;i++){
            int j=i-1;
            if(items[j].compareTo(items[i])<0){
                continue;
            }
            Integer tmp=items[i];
            while (j>=0&&items[j].compareTo(tmp)>0){
                items[j+1]=items[j];
                j--;
            }
            items[j+1]=tmp;
        }
        long end = System.currentTimeMillis();
        Log.e("end", end + "");
        runtime = end - current;
        Log.e("runtime", runtime + "");
    }
}
