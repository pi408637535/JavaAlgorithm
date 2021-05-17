package com.study.ds;


class RightMaxHeap {
    private int[] arr;
    private final int limit;
    private int size;

    public RightMaxHeap(int limit) {
        arr = new int[limit];
        this.limit = limit;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    public void push(int value) {
        if (size == limit) {
            throw new RuntimeException("heap is full");
        }
        arr[size++] = value;
    }

    public int pop() {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        int ans = arr[maxIndex];
        arr[maxIndex] = arr[--size];
        return ans;
    }

}

public class MyHeap {
    private int[] data;
    private int capacity;
    private int size;

    public MyHeap(int capacity, int size) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.size = size;
    }

    private boolean ifEmpty(){
        return this.size == 0 ? true : false;
    }

    private boolean ifFull(){
        return this.size == this.capacity ? true : false;
    }

    public void push(int val){
        if(this.ifFull()){
            throw new RuntimeException();
        }else{
            this.data[this.size++] = val;
            this.heapInsert();
        }
    }

    private void heapInsert(){
        int index = this.size - 1;
        while (index > 0 && this.data[index] > data[(index - 1) / 2]){
            swap(index, (index - 1)  /2 );
            index = (index - 1) / 2;
        }
    }

    public int pull(){
        if(ifEmpty()){
            throw new RuntimeException();
        }else{
            int val = this.data[0];
            swap(0, --this.size);
            heapify(0);
            return val;
        }
    }

    private void heapify(int index){
        int left = index * 2 + 1;
        while (left < this.size){
            int largest = data[left + 1] > data[left] ? left + 1 : left;
            largest = data[largest] >  data[(left - 1) / 2] ? largest : (left - 1) / 2;
            if(largest == index){ //应对heap中仅有2个节点:如果data[largets] = 5, data[left] =4,此时无法跳出循环
                break;
            }
            this.swap(largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    private void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            RightMaxHeap my = new RightMaxHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}
