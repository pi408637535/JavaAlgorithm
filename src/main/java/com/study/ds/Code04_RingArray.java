package com.study.ds;

import java.io.IOException;

public class Code04_RingArray {

    public class MyQueue{
        private int front = 0;
        private int tail = 0;
        private int limit;
        private int[] arr;
        private int size = 0;

        public MyQueue(int limit) {
            arr = new int[limit];
            this.limit = limit;
        }

        public void push(int val) {
            if(size < this.limit){
                arr[this.front] = val;
                front = (front + 1) % limit;
                size++;
            }else{
                throw new RuntimeException("full");
            }
        }

        public int pop(){
            if(size == 0){
                throw new RuntimeException("full");
            }else{
                int index =  tail;
                tail = (tail + 1) % limit;
                size -= 1;
                return arr[index];
            }
        }

    }

    public static void main(String[] args) {

    }

}
