package com.javarush.task.task20.task2028;

/*
Построй дерево(1)
*/

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    List<Entry<String>> list = new LinkedList<>();
    int size = 0;

    public CustomTree() {
        this.root = new Entry<String>("0");
        root.parent = root;
        list.add(root.parent);
    }

    String getParent(String s) {
        String parent = null;
        for (int i = 0; i < list.size(); i++) {
            if (s.equals(list.get(i).elementName)) {
                parent = list.get(i).parent.elementName;
                break;
            }
        }
        return parent;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(String s) {
        Entry<String> entry = new Entry<>(s);
        for (int i = 0; i < list.size(); i++) {
            entry.parent = list.get(i);
            if (entry.parent.isAvailableToAddChildren()) {
                list.add(entry);
                size++;
                if (entry.parent.availableToAddLeftChildren) {
                    list.add(entry.parent);
                    entry.parent.availableToAddLeftChildren = false;
                    return true;
                }
                if (entry.parent.availableToAddRightChildren) {
                    list.add(entry.parent);
                    entry.parent.availableToAddRightChildren = false;
                    return true;
                }
            }
        }
        return false;
    }

    static class Entry<T> implements Serializable {

        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }
}
