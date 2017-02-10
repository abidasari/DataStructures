package nodes;

/**
 * 
 * @author adasari
 *
 */

public class HashTableListNode {
	private int key;
	private int value;
	private HashTableListNode next;
	public HashTableListNode(int key, int value, HashTableListNode next) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
	}
	public HashTableListNode(int key, int value) {
		super();
		this.key = key;
		this.value = value;
		next = null;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public HashTableListNode getNext() {
		return next;
	}
	public void setNext(HashTableListNode next) {
		this.next = next;
	}
}
