package Algorithms.Trees.trie_DS;

import java.util.*;

class TrieNode{  
  Map<Character, TrieNode> children;
  boolean isEndOfString;
  TrieNode() {
    children = new HashMap<>();
    isEndOfString =false;
  }
}

public class Main {
  private static TrieNode root = new TrieNode();
  public Main() { root = new TrieNode(); }
  public static void insert(String str) {
    TrieNode ptr = root;
    for(int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      TrieNode node = ptr.children.get(ch);
      if(node == null) { node = new TrieNode(); ptr.children.put(ch, node); }
      ptr = node;
    }
    ptr.isEndOfString =  true;
  }

  public static boolean search(String str) {
    return _search(root, str, 0);
  }

  private static boolean _search(TrieNode ptr, String str, int index) {
    if( index == str.length()) { return ptr.isEndOfString; }
    TrieNode node = ptr.children.get(str.charAt(index));
    if(node == null) {return false;}
    return _search(node, str, index+1);
  }
  public static void main(String[] args) {
    insert("apple");
    insert("pineapple");
    System.out.println(search("pineappl"));
  }
}