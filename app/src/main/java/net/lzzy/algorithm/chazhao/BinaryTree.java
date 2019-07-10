package net.lzzy.algorithm.chazhao;

import android.util.Pair;

public class BinaryTree<T extends Comparable<? super T>> extends BaseSearch<T> {
    private Pair<Integer, T> root;
    private BinaryTree<T> left, right;

    BinaryTree(T[] items) {
        super(items);
        root = new Pair<>(0, items[0]);
        for (int i = 1; i < items.length; i++) {
            addnode(new Pair<>(i, items[i]));
        }
    }

    private BinaryTree(Pair<Integer, T> node) {
        root = node;
    }

    private void addnode(Pair<Integer, T> node) {
        int comp = compare(node.second, root.second);

        if (comp > 0) {
            if (right == null) {
                new BinaryTree<>(node);
            } else {
                right.addnode(node);
            }
        }
        if (comp < 0) {
            if (left == null) {
                left = new BinaryTree<>(node);
            } else {
                left.addnode(node);
            }
        }
    }

    private long start = -1;

    @Override
    public int search(T key) {
        if (start < 0) {
            start = System.currentTimeMillis();
        }
        int coomp = compare(key, root.second);
        if (coomp == 0) {
            setDuration(System.currentTimeMillis() - start);
            return root.first;
        } else if (coomp > 0) {
            if (right == null) {
                setDuration(System.currentTimeMillis() - start);
                return -1;
            } else {
                return right.search(key);
            }
        } else {
            if (left == null) {
                setDuration(System.currentTimeMillis() - start);
                return -1;
            } else {
                return left.search(key);
            }
        }
    }
}
