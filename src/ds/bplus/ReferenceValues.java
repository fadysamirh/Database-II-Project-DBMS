package ds.bplus;

import java.util.ArrayList;

import eminem.DBAppException;

public class ReferenceValues {
	ArrayList <OverflowNode> overFlowNodes;
	 
	public ReferenceValues() {
		overFlowNodes= new ArrayList<OverflowNode>();
	}
	
	public void setReference(Object strReference) throws DBAppException {
		for(int i=0;i<overFlowNodes.size();i++) {
			if(overFlowNodes.get(i)==null) {
				OverflowNode ofn= new OverflowNode();
				ofn.referenceOfKeys.add(strReference);
				overFlowNodes.set(i, ofn);
			}
			else {
				OverflowNode ofn=overFlowNodes.get(i);
				if(ofn.nodeOrder>ofn.referenceOfKeys.size()) {
					ofn.referenceOfKeys.add(strReference);
					break;
				}
			}
		}
	}
	public ArrayList <OverflowNode> getReferences(){
		return overFlowNodes;
	}
	public void removeReference(Object strReference) {
		for(int i=0;i<overFlowNodes.size();i++) {
			OverflowNode ofn=overFlowNodes.get(i);
			ArrayList <Object> referenceOfKeys=ofn.referenceOfKeys;
			if(referenceOfKeys.contains(strReference)) {
				referenceOfKeys.remove(strReference);
				break;
			}
		}
	}

	public void replaceRef(Object oldRef, Object newRef) {
		for(int i=0;i<overFlowNodes.size();i++) {
			OverflowNode ofn=overFlowNodes.get(i);
			ArrayList <Object> referenceOfKeys=ofn.referenceOfKeys;
			if(referenceOfKeys.contains(oldRef)) {
				
				int indexOfOld=referenceOfKeys.indexOf(oldRef);
				referenceOfKeys.set(indexOfOld, newRef);
				break;
			}
		}
	}

}
