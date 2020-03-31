package eminem;

import java.util.Hashtable;

public class DBAppTest {

	public static void main(String[] args) throws DBAppException{
		DBApp dbApp = new DBApp();
		dbApp.init();
//		String strTableName = "IDClustering";
		String strTableName = "DoubleIndex";

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
//		dbApp.createTable(strTableName, "id", htblColNameType);
	
		
//insert tests
// insert more than one page
// check if insertion is done correctly
// check that the index is adjusted if any
// insert all types		
		
//		for (int i = 0; i < 210; i++) {
//		Hashtable htblColNameValue = new Hashtable();
//		htblColNameValue.put("id", new Integer(i));
//		htblColNameValue.put("name", new String("Ab"));
//		htblColNameValue.put("age", new Integer(i%50));
////		htblColNameValue.put("date", new Date(2000, 11, 23));
//////		System.out.println((new Date(2020, 11, 11).getClass()));
//////		System.out.println((new Date(2020, 11, 11)).toString());
//
////			htblColNameValue.put("gpa", new Double(2.0));
////		
////			if (4%2==0) {
////					htblColNameValue.put("grad", true);			
////			}
////			else			htblColNameValue.put("grad", false);
////		 Polygon p = new Polygon();
////		 p.addPoint(1,1);
////		 p.addPoint(2,2);
////		 System.out.println("n:"+p.npoints);
////		 htblColNameValue.put("shape", p);
////////
//		 dbApp.insertIntoTable(strTableName, htblColNameValue);
//		}
		
		dbApp.displayTableContent(strTableName);
	}



//delete tests
	// check if the last tuple in the page is deleted then the whole page is deleted
	// check that the index in adjusted if any

//update tests
	// check that all desired tuples are updated
	// check that if the needed tuples are in more than one page they are updated
	// check that all types can be updated
	// check that the index is updated correctly

//select tests
	// check that all operators are working correctly
	// try to select from more than one page
	// try invalid operators
	// if index is found use it

//create index tests
	// if the col type is polygon then only an R tree index can be created on it

}
