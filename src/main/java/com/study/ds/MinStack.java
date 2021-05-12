package com.study.ds;

public class MinStack {
    private int[] data;
    private int[] backup;
    private int index;
    /** initialize your data structure here. */
    public MinStack() {
        data = new int[10000];
        backup = new int[10000];
        index = 0;
    }

    public void push(int val) {
        if(index == 0){
            data[index] = val;
            backup[index] = val;
        }else{
            if(backup[index-1] < val){
                backup[index] = backup[index-1];
            }else{
                backup[index] = val;
            }
            data[index] = val;
        }
        index++;
    }

    public void pop() {
        if(index >= 0){
            index--;
        }
    }

    public int top() {
        return data[index-1];
    }

    public int getMin() {
        return backup[index-1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());

    }
}
