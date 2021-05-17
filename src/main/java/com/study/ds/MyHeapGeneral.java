package com.study.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyHeapGeneral <T>{
    private ArrayList<T> data;
    private final int limit;
    private int size;
    private Map<T,Integer> indexMap; //记录每个对象的位置

    public MyHeapGeneral(int limit) {
        this.data = new ArrayList<>(limit);
        this.limit = limit;
        size = 0;
        this.indexMap = new HashMap<>();
    }
}
