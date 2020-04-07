package ds.Rtree;

import java.awt.Polygon;
import java.util.ArrayList;

import eminem.DBAppException;

public class Testing {
	public static void main(String[] args) throws DBAppException {
		RTree tree = new RTree();
		
		Polygon p = new Polygon();
		p.addPoint(1,3);
		p.addPoint(2,4);
		tree.insert(p, "shape0");
		Polygon p2 = new Polygon();
		p2.addPoint(1,3);
		p2.addPoint(2,20);
		tree.insert(p2, "shape0");
		Polygon p3 = new Polygon();
		p3.addPoint(1,3);
		p3.addPoint(20,20);
		tree.insert(p3, "shape0");
		Polygon p4 = new Polygon();
		p4.addPoint(1,3);
		p4.addPoint(1,3);
		tree.insert(p4, "shape0");
		Polygon p5 = new Polygon();
		p5.addPoint(1,3);
		p5.addPoint(20,30);
		tree.insert(p5, "shape0");
		Polygon p6 = new Polygon();
		p6.addPoint(1,3);
		p6.addPoint(20,10);
		tree.insert(p6, "shape0");
		 System.out.println(tree);
		
		
	}
//		BTree btree = new BTree();
//
//		btree.insert(0,"Student0");
//		btree.insert(1,"Student0");
//		btree.insert(3,"Student0");
//		btree.insert(3,"Student0");
//		
//		btree.insert(2,"Student1");
//		
//	//	btree.insert(2,"Student1");
//
//
//	//System.out.println(btree.toString());
//
//
//
//		// System.out.println(btree.toString());
//
//		 ReferenceValues ref = (ReferenceValues) btree.search(2);
//
//		// System.out.println(ref.getReferences().size());
//		// btree.update(3, 1, 2);
////		btree.delete(1, "page1");
////		btree.delete(3, 3);
////		btree.delete(3, 3);
//
//		for (int i = 0; i < ref.getOverflowNodes().size(); i++) {
//			OverflowNode b = ref.getOverflowNodes().get(i);
//			//System.out.println("size =" + b.referenceOfKeys.size());
//			for (int j = 0; j < b.referenceOfKeys.size(); j++) {
//				System.out.print(b.referenceOfKeys.get(j) + " ");
//			}
//			System.out.println();
//		}
//
////		ArrayList<String> ref = new ArrayList<String>();
////		ref = btree.rangeMaxSearch(1);
////		for (int i = 0; i < ref.size(); i++) {
////			System.out.println(ref.get(i));
////		}
//
////		for (int i = 0; i < ref.getOverflowNodes().size(); i++) {
////			OverflowNode b = ref.getOverflowNodes().get(i);
////			System.out.println("size =" + b.referenceOfKeys.size());
////			for (int j = 0; j < b.referenceOfKeys.size(); j++) {
////				System.out.print(b.referenceOfKeys.get(j) + " ");
////			}
////			System.out.println();
////		}
//	}
//
////		ArrayList<String> ref = new ArrayList<String>();
////		ref = btree.rangeMinSearch(4);
////		for (int i = 0; i < ref.size(); i++) {
////			System.out.println(ref.get(i));
////		}
//
////		ArrayList a = new ArrayList<>();
////		a.add(10);
////		a.add(20);
////		System.out.println(a.size());

}