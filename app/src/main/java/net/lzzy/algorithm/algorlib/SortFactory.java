package net.lzzy.algorithm.algorlib;

public class SortFactory {
    public  static <T extends Comparable<? super T>> BaseSort<T> getInstance(int key,T[]items){
        BaseSort<T> sort=null;
        //工厂类
        switch (key){
            case 0:
                sort=new DirectSort(items);
                break;
            case 1:
                sort=new InsertSort(items);
                break;
            case 2:
                sort=new HillRank(items);
                break;
            case 3:
                sort=new BubbleSort(items);
                break;
                default:
                    return null;
        }

        return sort;
    }
}