package hashtable;

/**
 * 
 * @author adasari
 *
 */
import nodes.HashTableListNode;;

public class HashTable {
	private int lengthOfTable;
	private int occupiedCount;
	private HashTableNode[] table;
	
	public HashTable(int lengthOfTable) {
		super();
		this.lengthOfTable = lengthOfTable;
		table = new HashTableNode[lengthOfTable];
		for(int i = 0; i < lengthOfTable; i++)
			table[i].setStartNode(null);
	}
	public int getLengthOfTable() {
		return lengthOfTable;
	}
	public void setLengthOfTable(int lengthOfTable) {
		this.lengthOfTable = lengthOfTable;
	}
	public int getOccupiedCount() {
		return occupiedCount;
	}
	public void setOccupiedCount(int occupiedCount) {
		this.occupiedCount = occupiedCount;
	}
	public HashTableNode[] getTable() {
		return table;
	}
	public void setTable(HashTableNode[] table) {
		this.table = table;
	}
	
	public final static int LOADFACTOR = 20;
	
	public static HashTable createHashTable(int length){
		int lengthOfTable = length / LOADFACTOR;
		HashTable table = new HashTable(lengthOfTable);
		return table;
	}
	
	public int hashSearch(int k){
		HashTableListNode temp;
		temp = table[Hash(k, lengthOfTable)].getStartNode();
		while(temp != null){
			if(temp.getValue() == k)
				return 1; 
		}
		return 0;
	}
	
	public void hashInsert(int data){
		int index = Hash(data, lengthOfTable);
		HashTableListNode node = new HashTableListNode(index, data), temp;
		if(table[index].getBlockCount() > LOADFACTOR)
			rehash(table);
		temp = table[index].getStartNode().getNext();
		if(temp == null){
			table[index].getStartNode().setNext(node);
		} else {
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		table[index].setBlockCount(table[index].getBlockCount() + 1);
		setOccupiedCount(getOccupiedCount() + 1);
	}
	
	public void hashDelete(int value){
		int index = Hash(value, lengthOfTable);
		HashTableListNode temp = table[index].getStartNode().getNext(), prev = null;
		while(temp != null){
			if(temp.getValue() == value){
				if(prev!=null)
					prev.setNext(temp.getNext());
				else{
					table[index].getStartNode().setNext(temp.getNext());;
				}
				table[index].setBlockCount(table[index].getBlockCount() - 1);
				occupiedCount--;
				return;
			}
		}
	}
	
	public void rehash(HashTableNode[] table){
		HashTableNode[] newTable = new HashTableNode[lengthOfTable * 2];
		int newLength = lengthOfTable * 2;
		HashTableListNode temp;
		for(int i = 0; i < lengthOfTable; i++){
			temp = table[i].getStartNode().getNext();
			while(temp != null){
				int newIndex = Hash(temp.getValue(), newLength);
				HashTableListNode newNode = new HashTableListNode(newIndex, temp.getValue());
				newNode.setNext(newTable[newIndex].getStartNode().getNext());
				newTable[newIndex].setStartNode(newNode);
				newTable[newIndex].setBlockCount(newTable[newIndex].getBlockCount() + 1);
			}
		}
		table = newTable;
	}
	
	public static int Hash(int data, int newLengthOfTable){
		//Sophisticated hashing code goes here
		return 4;
	}
	
}
