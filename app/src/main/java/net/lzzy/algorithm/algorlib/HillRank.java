package net.lzzy.algorithm.algorlib;

public class HillRank<T extends Comparable<T>> extends BaseSort{
    public HillRank(Integer[] items) {
        super(items);
    }

    @Override
    public void sort() {
        int dk=items.length;       //定义dk做为步长
        while (dk!=1){
            dk = dk/2;             //刚开始选择的长度为一半
            for(int k=0;k<=dk;k++){     //k是每个子序列的第一个元素的下标
                for(int i=1;k+i*dk<items.length;i++){       //通过i改变倍数，确定下标
                    for(int j=0;j<i;j++){                   //j是子序列中小于i的所以下标
                        if(items[k+j*dk]>items[k+i*dk]){    //子序列进行插入排序
                            int tmp=items[k+i*dk];
                            for(int p=i;p>j;p--){
                                items[k+p*dk] = items[k+(p-1)*dk];
                                items[k+j*dk] = tmp;
                            }
                        }
                    }
                }
            }
        }

    }
}
