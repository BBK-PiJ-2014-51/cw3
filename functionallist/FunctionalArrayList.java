package functionallist;
import list.ArrayList;
import returnobject.ReturnObject;


public class FunctionalArrayList extends ArrayList implements FunctionalList {
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
		FunctionalList rest = new FunctionalArrayList();
		for (int i = 1; i < size(); i++){
			rest.add(get(i).getReturnValue());
		}
		return rest;
	}
}
