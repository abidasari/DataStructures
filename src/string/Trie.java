package string;

/**
 * 
 * @author adasari
 *
 */

import java.util.*;

public class Trie {
	public class TrieNode{
		public Map<Character, TrieNode> children;
		public boolean endOfWord;
		public TrieNode(){
			children = new HashMap<>();
			endOfWord = false;
		}
	}
	
	public TrieNode root;;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public void insertIterative(String s){
		TrieNode current = root;
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			TrieNode node = current.children.get(c);
			if(node == null){
				current.children.put(c, new TrieNode());
			}
			current = node;
		}
		current.endOfWord = true;
	}
	
	public void insertRecursive(String s){
		insertRecursive(root, s, 0);
	}
	
	public void insertRecursive(TrieNode current, String s, int index) {
		if(index == s.length()){
			current.endOfWord = true;
			return;
		}
		char c = s.charAt(index);
		TrieNode node = current.children.get(c);
		if(node == null){
			node = new TrieNode();
			current.children.put(c, node);
		}
		insertRecursive(node, s, index + 1);
	}
	
	public boolean searchIterative(String s){
		TrieNode current = root;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!current.children.containsKey(c))
				return false;
			current = current.children.get(c);
		}
		return current.endOfWord;			
	}
	
	public boolean searchRecursive(String s){
		return searchRecursive(root, s, 0);
	}
	
	public boolean searchRecursive(TrieNode current, String s, int index){
		if(index == s.length())
			return current.endOfWord;
		char c = s.charAt(index);
		if(!current.children.containsKey(c))
			return false;
		return searchRecursive(current.children.get(c), s, index + 1);
	}
}
