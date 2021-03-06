package functionallist;
import list.LinkedList;
import returnobject.ReturnObject;


public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public ReturnObject head() {
		return get(0);
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public FunctionalList rest() {
		FunctionalList rest = new FunctionalLinkedList();
		for (int i = 1; i < size(); i++){
			rest.add(get(i).getReturnValue());
		}
		return rest;
	}

}
