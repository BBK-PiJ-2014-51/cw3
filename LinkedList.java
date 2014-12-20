 
public class LinkedList implements List{
	Node head = null;
	int size = 0;

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ReturnObject get(int index) {
		if (isEmpty()) return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		if (index < 0 || index >= size) return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		Node returnValue = head;
		for (int i = 0; i < index; i++){
			returnValue = returnValue.getNext();
		}
		return new ReturnObjectImpl(returnValue.getValue());
	}

	@Override
	public ReturnObject remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnObject add(Object item) {
		// TODO Auto-generated method stub
		return null;
	}

}
