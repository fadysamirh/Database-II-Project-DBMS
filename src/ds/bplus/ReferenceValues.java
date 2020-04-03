package ds.bplus;

import java.util.ArrayList;

public class ReferenceValues {
	ArrayList <Object> referencesOfKey;
	 
	public ReferenceValues() {
		referencesOfKey= new ArrayList<Object>();
	}
	
	public void setReference(Object strReference) {
		referencesOfKey.add(strReference);
	}
	public ArrayList <Object> getReferences(){
		return referencesOfKey;
	}
	public void removeReference(Object reference) {
		referencesOfKey.remove(reference);
	}

	public void replaceRef(Object oldRef, Object newRef) {
		
		int indexOfOld=referencesOfKey.indexOf(oldRef);
		referencesOfKey.set(indexOfOld, newRef);
	}

}
