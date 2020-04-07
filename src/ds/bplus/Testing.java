package ds.bplus;

import java.util.ArrayList;

import eminem.DBAppException;

public class Testing {
	public static void main(String[] args) throws DBAppException {
		BTree btree = new BTree();
		btree.insert(50,"Student0");
		btree.insert(40,"Student0");
		btree.insert(40,"Student0");
		btree.insert(25,"Student0");
		btree.insert(25,"Student1");
		btree.insert(25,"Student1");
		btree.insert(50,"Student1");

	//System.out.println(btree.toString());

		// System.out.println(btree.toString());

		 ReferenceValues ref = (ReferenceValues) btree.search(50);

		// System.out.println(ref.getReferences().size());
		// btree.update(3, 1, 2);
//		btree.delete(3, 3);
//		btree.delete(3, 3);
//		btree.delete(3, 3);

		for (int i = 0; i < ref.getOverflowNodes().size(); i++) {
			OverflowNode b = ref.getOverflowNodes().get(i);
			//System.out.println("size =" + b.referenceOfKeys.size());
			for (int j = 0; j < b.referenceOfKeys.size(); j++) {
				System.out.print(b.referenceOfKeys.get(j) + " ");
			}
			System.out.println();
		}

//		ArrayList<String> ref = new ArrayList<String>();
//		ref = btree.rangeMaxSearch(5);
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