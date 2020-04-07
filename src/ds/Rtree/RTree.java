package ds.Rtree;

import java.awt.Polygon;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import eminem.DBAppException;
import eminem.myPolygon;

/**
 * A B+ tree Since the structures and behaviors between internal node and
 * external node are different, so there are two different classes for each kind
 * of node.
 * 
 * @param <TKey> the data type of the key
 * @param <TValue> the data type of the value
 */
public class RTree<TKey extends Comparable<TKey>, TValue> implements Serializable {
	private RTreeNode<TKey> root;
	public String treeName;

	private ArrayList<RTreeLeafNode<TKey, TValue>> findLeafNodeStartKey(TKey key) {
		RTreeNode<TKey> node = this.root;
		ArrayList<RTreeLeafNode<TKey, TValue>> result = new ArrayList<RTreeLeafNode<TKey, TValue>>();
		while (node.getNodeType() == TreeNodeType.InnerNode) {
			// System.out.println("check");
			node = ((RTreeInnerNode<TKey>) node).getChild(node.search(key));
		}
		// System.out.println("check");
		result.add((RTreeLeafNode<TKey, TValue>) node);
		while ((RTreeLeafNode<TKey, TValue>) node.rightSibling != null) {
			result.add((RTreeLeafNode<TKey, TValue>) node.rightSibling);
			node = (RTreeLeafNode<TKey, TValue>) node.rightSibling;
		}

		return result;
		// return (RTreeLeafNode<TKey, TValue>) node;
	}

	public ArrayList<String> rangeMinSearch(Polygon poly) { // returns RTreeReferenceValues that contains a list of overflow
		TKey key = (TKey)new myPolygon(poly);
		// nodes
// RTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		ArrayList<RTreeLeafNode<TKey, TValue>> leaves = new ArrayList<RTreeLeafNode<TKey, TValue>>();
		leaves = this.findLeafNodeStartKey(key);
// System.out.println(leaf.keys[1]);
		ArrayList<String> result = new ArrayList<String>();
//System.out.println(leaves.size());
		for (int w = 0; w < leaves.size(); w++) {
			RTreeLeafNode<TKey, TValue> leaf = leaves.get(w);
			for (int i = 0; i < leaf.keys.length; i++) {
				if (leaf.getKey(i) != null) {
					if (leaf.getKey(i).compareTo(key) >= 0) {
//System.out.println(leaf.keys[i]);
						int index = leaf.searchMin(leaf.getKey(i));
// System.out.println(index + "s");
						if (index != -1) {
							RTreeReferenceValues ref = (RTreeReferenceValues) leaf.getValue(index);
//System.out.println(ref.getReferences().size());
							for (int z = 0; z < ref.getRTreeOverflowNodes().size(); z++) {
								RTreeOverflowNode f = ref.getRTreeOverflowNodes().get(z);
								for (int j = 0; j < f.referenceOfKeys.size(); j++) {
//System.out.println(f.referenceOfKeys.get(j) + "");
									result.add(f.referenceOfKeys.get(j) + " ");
								}
							}
						}
					}
				}
			}
		}
		return result;
//int index = leaf.searchMin(key);
//return (index == -1) ? null : leaf.getValue(index);
	}

	public ArrayList<String> rangeMaxSearch(Polygon poly) { // returns RTreeReferenceValues that contains a list of overflow
		TKey key = (TKey)new myPolygon(poly);
		// nodes
		// RTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		ArrayList<RTreeLeafNode<TKey, TValue>> leaves = new ArrayList<RTreeLeafNode<TKey, TValue>>();
		leaves = this.findLeafNodeStopKey(key);
		 //System.out.println(leaf.keys[1]);
		ArrayList<String> result = new ArrayList<String>();
		//System.out.println(leaves.size());
		for (int w = 0; w < leaves.size(); w++) {
			RTreeLeafNode<TKey, TValue> leaf = leaves.get(w);
			//System.out.println(leaf.keys[1]);
			for (int i = 0; i < leaf.keys.length; i++) {
				if (leaf.getKey(i) != null) {
					if (leaf.getKey(i).compareTo(key) <= 0) {
						//System.out.println(leaf.keys[i]);
						int index = leaf.searchMin(leaf.getKey(i));
						 //System.out.println(index + "s" + leaf.keys[i]);
						if (index != -1) {
							RTreeReferenceValues ref = (RTreeReferenceValues) leaf.getValue(index);
							//System.out.println(ref.getReferences().size());
							for (int z = 0; z < ref.getRTreeOverflowNodes().size(); z++) {
								RTreeOverflowNode f = ref.getRTreeOverflowNodes().get(z);
								for (int j = 0; j < f.referenceOfKeys.size(); j++) {
									//System.out.println(f.referenceOfKeys.get(j) + "");
									result.add(f.referenceOfKeys.get(j) + " ");
								}
							}
						}
					}
				}
			}
		}
		return result;
//int index = leaf.searchMin(key);
//return (index == -1) ? null : leaf.getValue(index);
	}

	private ArrayList<RTreeLeafNode<TKey, TValue>> findLeafNodeStopKey(TKey key) {
		RTreeNode<TKey> node = this.root;
		ArrayList<RTreeLeafNode<TKey, TValue>> result = new ArrayList<RTreeLeafNode<TKey, TValue>>();
		while (node.getNodeType() == TreeNodeType.InnerNode) {
			// System.out.println("check");
			node = ((RTreeInnerNode<TKey>) node).getChild(node.search(key));
		}
		// System.out.println("check");
		result.add((RTreeLeafNode<TKey, TValue>) node);
		while ((RTreeLeafNode<TKey, TValue>) node.leftSibling != null) {
			result.add((RTreeLeafNode<TKey, TValue>) node.leftSibling);
			node = (RTreeLeafNode<TKey, TValue>) node.leftSibling;
		}

		return result;
		// return (RTreeLeafNode<TKey, TValue>) node;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return root.toString();
	}

	public RTree() throws DBAppException {
		this.root = new RTreeLeafNode<TKey, TValue>();
	}

	/**
	 * Insert a new key and its associated value into the B+ tree.
	 * 
	 * @throws DBAppException
	 */
	public void insert(Polygon poly, TValue value) throws DBAppException {
		TKey key = (TKey)new myPolygon(poly);
		RTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
	
		leaf.insertKey(key, value);

		if (leaf.isOverflow()) {

			RTreeNode<TKey> n = leaf.dealOverflow();
			if (n != null)
				this.root = n;
		}
	}

	/**
	 * Search a key value on the tree and return its associated value.
	 */

	public TValue search(Polygon poly) { // returns RTreeReferenceValues that contains a list of overflow nodes
		TKey key = (TKey)new myPolygon(poly);
		RTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);

		int index = leaf.search(key);
		return (index == -1) ? null : leaf.getValue(index);
	}

	/**
	 * Delete a key and its associated value from the tree.
	 * 
	 * @throws DBAppException
	 */
	public void delete(Polygon poly, TValue value) throws DBAppException { // key=fady tvalue =page 1 deletes only one
																		// instance of key fady and page 1
		TKey key = (TKey)new myPolygon(poly);
		RTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		if (leaf.delete(key, value) && leaf.isUnderflow()) {		
			RTreeNode<TKey> n = leaf.dealUnderflow();
			if (n != null)
				this.root = n;
		}
		

	}

	public void update(Polygon poly, TValue oldRef, TValue newRef) { // fady page 1 wadeto page 2 (fady,page1,page2) only
																	// one instance
		TKey key = (TKey)new myPolygon(poly);
		RTreeLeafNode node = findLeafNodeShouldContainKey(key);
		node.update(key, oldRef, newRef);
	}

	/**
	 * Search the leaf node which should contain the specified key
	 */
	@SuppressWarnings("unchecked")
	private RTreeLeafNode<TKey, TValue> findLeafNodeShouldContainKey(TKey key) {
		RTreeNode<TKey> node = this.root;
		while (node.getNodeType() == TreeNodeType.InnerNode) {
			node = ((RTreeInnerNode<TKey>) node).getChild(node.search(key));
		}

		return (RTreeLeafNode<TKey, TValue>) node;
	}

	public void serializeTree() throws DBAppException, IOException {

		try {
			String n = this.treeName;
			ObjectOutputStream bin = new ObjectOutputStream(new FileOutputStream("data//" + n + ".class"));
			bin.writeObject(this);
			bin.flush();
			bin.close();
		} catch (Exception e) {
			throw new DBAppException("error in serialization");
		}
	}
}