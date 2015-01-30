package stack;
import list.List;
import returnobject.ReturnObject;


public class StackImpl extends AbstractStack{

	/**
	 * Constructor to pass list to super class
	 * 
	 * @param list
	 */
	public StackImpl(List list) {
		super(list);
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public int size() {
		return internalList.size();
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public void push(Object item) {
		internalList.add(item);
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public ReturnObject top() {
		return internalList.get(internalList.size() - 1);
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public ReturnObject pop() {
		ReturnObject top = top();
		internalList.remove(internalList.size() - 1);
		return top;
	}
}