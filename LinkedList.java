 
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
		if (isEmpty()) return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		if (index < 0 || index >= size) return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		Node returnValue = head;
		if (index == 0){
			head = head.getNext();
		} else {
			//move returnValue up to value right before value to return
			for (int i = 0; i < index - 1; i++){
				returnValue = returnValue.getNext();
			}
			Node previousValue = returnValue;
			//get value to return
			returnValue = previousValue.getNext();
			//make previous value "skip" removed value
			previousValue.setNext(returnValue.getNext());
		}
		size--;
		return new ReturnObjectImpl(returnValue.getValue());
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if (index < 0 || index >= size) return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		Node newNode = new NodeImpl(item);
		if(index == 0){
			if (size > 0) newNode.setNext(head);
			head = newNode;
		} else {
			Node currentNode = head;
			for (int i = 0; i < index - 1; i++){
				currentNode = currentNode.getNext();
			}
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);
		}
		size++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	@Override
	public ReturnObject add(Object item) {
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		if (head == null) head = new NodeImpl(item);
		else {
			Node currentNode = head;
			while (currentNode.getNext() != null){
				currentNode= currentNode.getNext();
			}
			currentNode.setNext(new NodeImpl(item));
		}
		size++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

}