package ds.bplus;

import java.util.ArrayList;

import eminem.DBAppException;

/**
 * A B+ tree Since the structures and behaviors between internal node and
 * external node are different, so there are two different classes for each kind
 * of node.
 * 
 * @param <TKey> the data type of the key
 * @param <TValue> the data type of the value
 */
public class BTree<TKey extends Comparable<TKey>, TValue> {
	private BTreeNode<TKey> root;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return root.toString();
	}

	public BTree() throws DBAppException {
		this.root = new BTreeLeafNode<TKey, TValue>();
	}

	/**
	 * Insert a new key and its associated value into the B+ tree.
	 * 
	 * @throws DBAppException
	 */
	public void insert(TKey key, TValue value) throws DBAppException {
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		leaf.insertKey(key, value);

		if (leaf.isOverflow()) {
			BTreeNode<TKey> n = leaf.dealOverflow();
			if (n != null)
				this.root = n;
		}
	}

	/**
	 * Search a key value on the tree and return its associated value.
	 */

	public TValue search(TKey key) { // returns ReferenceValues that contains a list of overflow nodes
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);

		int index = leaf.search(key);
		return (index == -1) ? null : leaf.getValue(index);
	}

	public ArrayList<TValue> rangeMinSearch(TKey startkey) throws DBAppException {
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeStartKey(startkey);
		ArrayList<TValue> v = new ArrayList<TValue>();
		for (int i = 0; i < leaf.keys.length; i++) {
			//System.out.println(leaf.keys[i]);
			v.add(leaf.getValue(leaf.searchMinStart(startkey)));
		}
		// int index = leaf.search(startkey);
		// return (index == -1) ? null : leaf.getValue(index);
		return v;

	}

	/**
	 * Delete a key and its associated value from the tree.
	 * 
	 * @throws DBAppException
	 */
	public void delete(TKey key, TValue value) throws DBAppException { // key=fady tvalue =page 1 deletes only one
																		// instance of key fady and page 1
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);

		if (leaf.delete(key, value) && leaf.isUnderflow()) {
			BTreeNode<TKey> n = leaf.dealUnderflow();
			if (n != null)
				this.root = n;
		}

	}

	public void update(TKey key, TValue oldRef, TValue newRef) { // fady page 1 wadeto page 2 (fady,page1,page2) only
																	// one instance
		BTreeLeafNode node = findLeafNodeShouldContainKey(key);
		node.update(key, oldRef, newRef);
	}

	/**
	 * Search the leaf node which should contain the specified key
	 */
	@SuppressWarnings("unchecked")
	private BTreeLeafNode<TKey, TValue> findLeafNodeShouldContainKey(TKey key) {
		BTreeNode<TKey> node = this.root;
		while (node.getNodeType() == TreeNodeType.InnerNode) {
			node = ((BTreeInnerNode<TKey>) node).getChild(node.search(key));
		}

		return (BTreeLeafNode<TKey, TValue>) node;
	}

	private BTreeLeafNode<TKey, TValue> findLeafNodeStartKey(TKey key) {
		BTreeNode<TKey> node = this.root;
		while (node.getNodeType() == TreeNodeType.InnerNode) {
			node = ((BTreeInnerNode<TKey>) node).getChild(node.searchMinStart(key));
		}

		return (BTreeLeafNode<TKey, TValue>) node;
	}
}
