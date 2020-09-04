package base.string;

import java.util.HashMap;

/**
 * @Author: Jeremy
 * @Date: 2019/12/11 11:06
 */
class Trie {
    public class TrieNode{
        public char data;
        public HashMap<Integer, TrieNode> children;
        public boolean isEnd = false;
        public TrieNode(char data){
            this.data = data;
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(!p.children.containsKey(index)){
                p.children.put(index, new TrieNode(ch));
            }
            p = p.children.get(index);
        }
        p.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(!p.children.containsKey(index)){
                return false;
            }
            p = p.children.get(index);
        }
        return p.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if(!p.children.containsKey(index)){
                return false;
            }
            p = p.children.get(index);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        boolean res = trie.search("apple");
        System.out.println(res);

        boolean res2 = trie.startsWith("ap");
        System.out.println(res2);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */