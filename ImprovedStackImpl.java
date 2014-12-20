
public class ImprovedStackImpl implements ImprovedStack{
	Stack stack = new StackImpl(new LinkedList());
	
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public void push(Object item) {
		stack.push(item);
	}

	@Override
	public ReturnObject top() {
		return stack.top();
	}

	@Override
	public ReturnObject pop() {
		return stack.pop();
	}

	@Override
	public ImprovedStack reverse() {
		ImprovedStack reversedStack = new ImprovedStackImpl();
		for (int i = 0; i < stack.size(); i++){
			reversedStack.push(stack.pop());
		}
		return reversedStack;
	}

	@Override
	public void remove(Object object) {
		ImprovedStack newStack = new ImprovedStackImpl();
		for (int i = 0; i < stack.size(); i++){
			if (!stack.top().getReturnValue().equals(object))newStack.push(stack.pop());
			else stack.pop();
		}
		stack = newStack.reverse();
	}
}
