package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode208 {
    class Trie {
        node root;
        class node {
            List<node> children; // 后续结点
            char value; // 值
            boolean isWord; // 标识是不是一个单词结尾

            public node(char v) {
                this.value = v;
                this.children = new ArrayList<>();
            }
        }
        public Trie() {
            this.root = new node(' '); // 初始化根节点
        }
        public void insertWithNode(char[] arr, node n,int index) {
            if (arr.length - index == 0) {
                n.isWord = true;
                return;
            }
                // 遍历子节点,如果子节点有，那么就直接添加到子节点
                for (int i = 0; i < n.children.size(); i++) {
                    if (n.children.get(i).value == arr[index]) {
                        this.insertWithNode(arr,n.children.get(i),index+1);
                        return;
                    }
                }
                // 新增结点
                node newNode = new node(arr[index]);
                n.children.add(newNode);
                this.insertWithNode(arr,newNode,index+1);
        }
        public void insert(String word) {
           this.insertWithNode(word.toCharArray(),this.root,0);
        }

        public boolean searchWithNode(char[] arr, node n,int index, boolean needIsWord) {
           if (index == arr.length) {
               if (needIsWord) {
                   return n.isWord;
               }
               return true;
           }
            for (int i = 0; i < n.children.size(); i++) {
                if (n.children.get(i).value == arr[index]) {
                    return this.searchWithNode(arr,n.children.get(i),index+1,needIsWord);
                }
            }
            return false;
        }

        public boolean search(String word) {
            char[] arr = word.toCharArray();
            if (arr.length == 0) {
                return true;
            }
            // 遍历每一个结点
            node now = this.root;
            for (int i = 0; i < this.root.children.size(); i++) {
                if (this.root.children.get(i).value == arr[0]) {
                    return this.searchWithNode(arr,this.root.children.get(i),1,true);
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            char[] arr = prefix.toCharArray();
            // 遍历每一个结点
            node now = this.root;
            for (int i = 0; i < this.root.children.size(); i++) {
                if (this.root.children.get(i).value == arr[0]) {
                    return this.searchWithNode(arr,this.root.children.get(i),1,false);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Trie l = new Leetcode208().new Trie();
        l.insert("apple");
        System.out.println(l.search("apple"));
        System.out.println(l.search("app"));
        System.out.println(l.startsWith("app"));
    }
}
