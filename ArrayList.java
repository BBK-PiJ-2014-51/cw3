
public class ArrayList implements List {
	private int size = 0;
	private int capacity = 10;
	private Object[] items = new Object[capacity];
	
	
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
		return (index < 0 || index >= size) ? new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS) : new ReturnObjectImpl(items[index]);
	}

	@Override
	public ReturnObject remove(int index) {
		if (index < 0 || index >= size) return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		ReturnObject removedObj = new ReturnObjectImpl(items[index]);
		//set index removed and all subsequent indices to the next element
		for (int i = index; i < size - 1; i++){
			items[i] = items[i+1];
		}
		size--;
		return removedObj;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if (index < 0 || index >= size) return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		else if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		if (size == capacity) expandArray();
		for (int i = size; i > index; i--){
			items[i-1] = items[i];
		}
		items[index] = item;
		size++;
		return new ReturnObjectImpl(items[index]);
	}

	@Override
	public ReturnObject add(Object item) {
		if (item == null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		if (size == capacity) expandArray();
		items[size] = item;
		return new ReturnObjectImpl(items[size++]);
	}
	
	private boolean expandArray(){
		Object[] newArray = new Object[capacity * 2];
		for (int i = 0; i < size; i++){
			newArray[i] = items[i];
		}
		items = newArray;
		capacity *= 2;
		return true; 
	}

}
