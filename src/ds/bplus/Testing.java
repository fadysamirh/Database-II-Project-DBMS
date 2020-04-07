package ds.bplus;

import java.util.ArrayList;

import eminem.DBAppException;

public class Testing {
	public static void main(String[] args) throws DBAppException {
		BTree btree = new BTree();
		btree.insert(1, "page1");
//		btree.insert(1, 1);
//		btree.insert(1, 1);
//
//		btree.insert(3, 1);
//		btree.insert(3, 2);
//		btree.insert(3, 1);
//		btree.insert(3, 3);
//		btree.insert(3, 1);
//		btree.insert(3, 1);
//		btree.insert(3, 3);
//		btree.insert(3, 1);
//		btree.insert(3, 1);
//		btree.insert(3, 3);

//		btree.insert(4, 1);
//		btree.insert(4, 1);
//		btree.insert(4, 4);

//		btree.insert(4, 3);
//		btree.insert(4, 1);
//		btree.insert(4, 1);
//		btree.insert(4, 4);


		btree.insert(4, 3);
		btree.insert(5, 3);
		btree.insert(6, 4);
		btree.insert(7, 3);
		btree.insert(8, 3);
		btree.insert(9, 3);
		btree.insert(1, 1);
//		btree.insert(1, 1);
//		btree.insert(1, 1);
//
		btree.insert(3, 1);
		btree.insert(3, 2);
		btree.insert(3, 1);
		btree.insert(3, 3);
//		btree.insert(3, 1);
//		btree.insert(3, 1);
//		btree.insert(3, 3);
//		btree.insert(3, 1);
//		btree.insert(3, 1);
//		btree.insert(3, 3);

		btree.insert(4, 1);
		btree.insert(4, 1);
		btree.insert(4, 4);

		btree.insert(4, 3);
		btree.insert(4, 1);
		btree.insert(4, 1);
		btree.insert(4, 4);

		btree.insert(4, 3);
		btree.insert(5, 3);
		btree.insert(6, 4);
		btree.insert(7, 3);
		btree.insert(8, 3);
		btree.insert(9, 3);
		btree.insert(1, 1);
//		btree.insert(1, 1);
//		btree.insert(1, 1);
//
		btree.insert(3, 1);
		btree.insert(3, 2);
		btree.insert(3, 1);
		btree.insert(3, 3);
//		btree.insert(3, 1);
//		btree.insert(3, 1);
//		btree.insert(3, 3);
//		btree.insert(3, 1);
//		btree.insert(3, 1);
//		btree.insert(3, 3);

		btree.insert(4, 1);
		btree.insert(4, 1);
		btree.insert(4, 4);

		btree.insert(4, 3);
		btree.insert(4, 1);
		btree.insert(4, 1);
		btree.insert(4, 4);

		btree.insert(1, 3);
		btree.insert(202, 3);
		btree.insert(10, 4);
		btree.insert(100, 3);
		btree.insert(74, 3);
		btree.insert(9, 3);
		btree.insert(10, 3);
		btree.insert(11, 5);
		btree.insert(12, 6);
		btree.insert(13, 2);
		btree.insert(14, 7);
		btree.insert(15, 3);
		btree.insert(16, 3);

	System.out.println(btree.toString());

		// System.out.println(btree.toString());

		// ReferenceValues ref = (ReferenceValues) btree.search(4);

		// System.out.println(ref.getReferences().size());
		// btree.update(3, 1, 2);
//		btree.delete(1, "page1");
//		btree.delete(3, 3);
//		btree.delete(3, 3);

//		for (int i = 0; i < ref.getOverflowNodes().size(); i++) {
//			OverflowNode b = ref.getOverflowNodes().get(i);
//			//System.out.println("size =" + b.referenceOfKeys.size());
//			for (int j = 0; j < b.referenceOfKeys.size(); j++) {
//				System.out.print(b.referenceOfKeys.get(j) + " ");
//			}
//			System.out.println();
//		}

//		ArrayList<String> ref = new ArrayList<String>();
//		ref = btree.rangeMaxSearch(1);
//		for (int i = 0; i < ref.size(); i++) {
//			System.out.println(ref.get(i));
//		}

//		for (int i = 0; i < ref.getOverflowNodes().size(); i++) {
//			OverflowNode b = ref.getOverflowNodes().get(i);
//			System.out.println("size =" + b.referenceOfKeys.size());
//			for (int j = 0; j < b.referenceOfKeys.size(); j++) {
//				System.out.print(b.referenceOfKeys.get(j) + " ");
//			}
//			System.out.println();
//		}
	}

//		ArrayList<String> ref = new ArrayList<String>();
//		ref = btree.rangeMinSearch(4);
//		for (int i = 0; i < ref.size(); i++) {
//			System.out.println(ref.get(i));
//		}

//		ArrayList a = new ArrayList<>();
//		a.add(10);
//		a.add(20);
//		System.out.println(a.size());

}