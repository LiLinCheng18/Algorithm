package net.lzzy.algorithm.chazhao;

import net.lzzy.algorithm.chazhao.BaseSearch;

public class DirectSearch<T extends Comparable<? super T>> extends BaseSearch<T> {

    DirectSearch(Comparable[] items) {
        super((T[]) items);
    }

    @Override
    public int search(T key) {
        long start = System.currentTimeMillis();
        int pos = 0;
        for (T items : items) {
            if (equal(items, key)) {
                setDuration(System.currentTimeMillis() - start);
                return pos;
            }
            pos++;
        }
        setDuration(System.currentTimeMillis() - start);
        return -1;
    }


}
