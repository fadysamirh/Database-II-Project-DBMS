package ds.bplus;

import java.util.ArrayList;

import eminem.DBAppException;

public class Testing {
	public static void main(String[] args) throws DBAppException {
		BTree btree = new BTree();
		btree.insert(1, 1);
		btree.insert(1, 1);
//		btree.insert(1, 1);
//
		btree.insert(3, 1);
		btree.insert(3, 2);
//		btree.insert(3, 1);
//		btree.insert(3, 3);
//		btree.insert(3, 1);
//		btree.insert(3, 1);
//		btree.insert(3, 3);
//		btree.insert(3, 1);
//		btree.insert(3, 1);
		btree.insert(3, 3);

		btree.insert(4, 3);
		btree.insert(4, 4);
//		btree.insert(4, 3);

		// ReferenceValues ref = (ReferenceValues) btree.search(3);
		// System.out.println(ref.getReferences().size());
		// btree.update(3, 1, 2);
//		btree.delete(3, 3);
//		btree.delete(3, 3);
//		btree.delete(3, 3);

//		for (int i = 0; i < ref.getReferences().size(); i++) {
//			OverflowNode b = ref.getReferences().get(i);
//			System.out.println("size =" + b.referenceOfKeys.size());
//			for (int j = 0; j < b.referenceOfKeys.size(); j++) {
//				System.out.print(b.referenceOfKeys.get(j) + " ");
//			}
//			System.out.println();
//		}

//		ArrayList<ReferenceValues> v = btree.rangeMinSearch(2);
//		System.out.println(v.size());
//		for (int i = 0; i < v.size(); i++) {
//			for (int j = 0; j < v.get(i).getReferences().size(); j++) {
//				OverflowNode b = v.get(i).getReferences().get(j);
//				for (int z = 0; z < b.referenceOfKeys.size(); z++) {
//					System.out.print(b.referenceOfKeys.get(z) + " ");
//				}
//				
//			}
//			System.out.println();
//		}

//		ArrayList a = new ArrayList<>();
//		a.add(10);
//		a.add(20);
//		System.out.println(a.size());

	}
}
