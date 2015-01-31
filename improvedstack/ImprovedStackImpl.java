package improvedstack;
import list.LinkedList;
import list.List;
import returnobject.ReturnObject;
import stack.Stack;
import stack.StackImpl;


public class ImprovedStackImpl implements ImprovedStack{
private Stack stack;
	
	/**
	 * Constructor implementing underlying stack as a link list.
	 * 
	 */
	public ImprovedStackImpl(){
		stack = new StackImpl(new LinkedList()); 
	}
	
	/**
	 * Constructor uses supplied list to implement underlying stack.
	 * 
	 * @param list
	 */
	public ImprovedStackImpl(List list){
		stack = new StackImpl(list);
	}
	
	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public int size() {
		return stack.size();
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public void push(Object item) {
		stack.push(item);
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public ReturnObject top() {
		return stack.top();
	}

	/**
	 * @inheritDoc
	 * 
	 */
	@Override
	public ReturnObject pop() {
		return stack.pop();
	}

	/**
	 * @inheritDoc
	 * 
	 * Stack is completely popped to create reversed stack. A copy is kept and
	 * the original stack is the re-loaded.
	 */
	@Override
	public ImprovedStack reverse() {
		ImprovedStack reversedStack = new ImprovedStackImpl();
		Object[] originalValues = new Object[stack.size()];
		int index = stack.size() -1;
		
		while(stack.size() > 0){
			Object currentValue =stack.pop().getReturnValue();
			reversedStack.push(currentValue);
			originalValues[index--] = currentValue; // save copy of value
		}
		
		while (++index < originalValues.length){ //restore values
			stack.push(originalValues[index]);
		}
		
		return reversedStack;
	}
	
	/**
	 * @inheritDoc
	 *  
	 */
	@Override
	public void remove(Object object) {
		ImprovedStack newStack = new ImprovedStackImpl();
		while (stack.size() > 0){
			if (!stack.top().getReturnValue().equals(object))newStack.push(stack.pop().getReturnValue());
			else stack.pop();
		}
		stack = newStack.reverse();
	}
}
