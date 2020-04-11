package eminem;

import java.awt.Polygon;
import java.util.Hashtable;

import ds.Rtree.RTree;
import ds.bplus.BTree;

public class DBAppTest {

	public static void main(String[] args) throws DBAppException {
		DBApp dbApp = new DBApp();
		dbApp.init();
		String strTableName = "PolygonClustering";
//		String strTableName = "DoubleIndex";

//create table tests
// create table with invalid types
// create more than one table
// try each type to be clustering

//		Hashtable<String, String> htblColNameType = new Hashtable();
//		htblColNameType.put("id", "java.lang.Integer");
//		htblColNameType.put("name", "java.lang.String");
//		htblColNameType.put("age", "java.lang.Integer");
//		htblColNameType.put("date", "java.util.Date");
//		htblColNameType.put("gpa", "java.lang.Double");
//		htblColNameType.put("shape", "java.awt.Polygon");
//		htblColNameType.put("grad", "java.lang.Boolean");
//		dbApp.createTable(strTableName, "shape", htblColNameType);

//insert tests
// insert more than one page
// check if insertion is done correctly
// check that the index is adjusted if any
// insert all types		

//		for (int i = 0; i < 210; i++) {
//		Hashtable htblColNameValue = new Hashtable();
//		htblColNameValue.put("id", new Integer(4));
//		htblColNameValue.put("name", new String("d"));
//		htblColNameValue.put("age", new Integer(80));
//		htblColNameValue.put("date", new Date(2000, 8, 23));
//////		System.out.println((new Date(2020, 11, 11).getClass()));
//////		System.out.println((new Date(2020, 11, 11)).toString());
//
////			htblColNameValue.put("gpa", new Double(2.0));
////		
////			if (4%2==0) {
////					htblColNameValue.put("grad", true);			
////			}
////			else			htblColNameValue.put("grad", false);
//		Polygon p = new Polygon();
//		p.addPoint(1, 1);
//		p.addPoint(7, 7);
////		 System.out.println("n:"+p.npoints);
//		htblColNameValue.put("shape", p);
////////
//		 dbApp.insertIntoTable(strTableName, htblColNameValue);
//		}

		// update tests
		Hashtable<String, Object> hash = new Hashtable();
//
//		Polygon p = new Polygon();
//		p.addPoint(2, 1);
//		p.addPoint(4, 5);
//		hash.put("shape", p);
//
		hash.put("age", new Integer(99));
		hash.put("name", new String("abc"));
//		////// hash.put("gpa", new Double(0.6));
//		hash.put("date", new Date(2020 - 02 - 3));

//		 dbApp.updateTable(strTableName, "(2,1),(4,5)", hash);

//		try {
//			 //dbApp.createBTreeIndex(strTableName, "age");
//			//dbApp.createRTreeIndex(strTableName, "shape");
////
//			BTree a = (BTree) (dbApp.getDeserlaized("data//" + "BTree" + strTableName + "age" + ".class"));
//			System.out.println(a.toString());
//			a.serializeTree();
//			RTree r = (RTree) (dbApp.getDeserlaized("data//" + "RTree" + strTableName + "shape" + ".class"));
//			System.out.println(r.toString());
//			r.serializeTree();
//		} catch (Exception e) {
//			System.out.println("error");
//		}

		dbApp.displayTableContent(strTableName);
	}

//delete tests
	// check if the last tuple in the page is deleted then the whole page is deleted
	// check that the index in adjusted if any

//select tests
	// check that all operators are working correctly
	// try to select from more than one page
	// try invalid operators
	// if index is found use it

//create index tests
	// if the col type is polygon then only an R tree index can be created on it

}
