package hashtable;

/**
 * 
 * @author adasari
 *
 */

import nodes.HashTableListNode;;

public class HashTableNode {
	private int blockCount;
	private HashTableListNode startNode;
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public HashTableListNode getStartNode() {
		return startNode;
	}
	public void setStartNode(HashTableListNode startNode) {
		this.startNode = startNode;
	}	
}
