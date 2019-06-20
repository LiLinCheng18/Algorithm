package net.lzzy.algorithm.algorlib;

import android.util.Log;

public class DirectSort<T extends Comparable<T>> extends BaseSort{

    public DirectSort(Integer[] items) {
        super(items);
    }

    @Override
    public void sort() {
        //直接选择排序////////////////////////
        long current = System.currentTimeMillis();
        Log.e("curent", current + "");
        int sum = 0;                                   //创建局部变量
        for (int i = 0; i < items.length - 1; i++) {       //利用循环i一个个全部循环j对比大小
            for (int j = 0; j < items.length - 1; j++) {
                if (compareTow(items[j],items[j+1])) {//循环j，每循环一次i就循环items。length个j
                    swap(j,sum);
                }
            }
            long end = System.currentTimeMillis();
            Log.e("end", end + "");
            runtime = end - current;
            Log.e("runtime", runtime + "");
        }
    }
    }
