package net.lzzy.algorithm.chazhao;

import net.lzzy.algorithm.algorlib.DirectSort;

public class SortChazhao {
    public static <T extends Comparable<? super T>> BaseSearch<T> getInstance(int key, T[] items) {
        BaseSearch<T> search;
        switch (key) {
            case 0:
                search = new DirectSearch(items);
                break;
            case 1:
                search=new BinarySearch<>(items);
                break;
            case 2:
                search=new BinaryTree<>(items);
                break;
            default:
                return null;
        }
        return search;
    }
}

