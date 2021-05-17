package com.study.ds;

public class Code01_TrieTree {

    static class Node{
        private int pass;
        private int end;
        private Node[] next;

        public Node() {
            this.pass = 0;
            this.end = 0;
            this.next = new Node[26];
        }
    }

    static class Tire{
        private Node root;

        public Tire() {
            this.root = new Node();
        }

        public void insert(String str){
            if(str == null || str.length() == 0){
                return;
            }
            char[] chars = str.toCharArray();
            Node cur = root;
            for(int i = 0; i < chars.length; i++){
                cur.pass += 1;
                if(cur.next[chars[i] - 'a'] == null){
                    cur.next[chars[i] - 'a'] = new Node();
                }
                cur = cur.next[chars[i] - 'a'];
            }
            cur.pass++; //忘记添加
            cur.end++;
        }

        public int search(String str){
            if(str == null || str.length() == 0){
                return 0;
            }
            char[] chars = str.toCharArray();
            Node cur = root;
            for(int i = 0; cur != null && i < chars.length; i++){
                if(cur.next[chars[i] - 'a'] != null){
                    cur = cur.next[chars[i] - 'a'];
                }else{
                    return 0;
                }
            }
            return cur.end;
        }

        public int prefixNumber(String str){
            if(str == null || str.length() == 0){
                return 0;
            }
            char[] chars = str.toCharArray();
            Node cur = root;
            for(int i = 0; cur != null && i < chars.length ; i++){
                if(cur.next[chars[i] - 'a'] != null){
                    cur = cur.next[chars[i] - 'a'];
                }else{
                    return 0;
                }
            }
            return cur.pass;
        }

        public void delete(String str){
            if(str == null || str.length() == 0){
                return ;
            }
            int result = search(str);
            if(result > 0){
                char[] chars = str.toCharArray();
                Node cur = root;
                cur.pass--;
                for(int i = 0; i < chars.length; i++) {
                    cur = cur.next[chars[i] - 'a'];
                    if(cur.pass == 0){ //优化
                        cur.next[chars[i] - 'a'] = null;
                    }
                    cur.pass--;
                }
                cur.end--;
            }
        }



    }

}
