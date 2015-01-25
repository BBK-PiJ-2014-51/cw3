package stack;
import list.List;
import returnobject.ReturnObject;


public class StackImpl extends AbstractStack{

	public StackImpl(List list) {
		super(list);
	}

	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	@Override
	public int size() {
		return internalList.size();
	}

	@Override
	public void push(Object item) {
		internalList.add(item);
	}

	@Override
	public ReturnObject top() {
		return internalList.get(internalList.size() - 1);
	}

	@Override
	public ReturnObject pop() {
		ReturnObject top = top();
		internalList.remove(internalList.size() - 1);
		return top;
	}

}
