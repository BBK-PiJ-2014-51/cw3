public class ReturnObjectImpl implements ReturnObject{
	
	private boolean hasError;
	private ErrorMessage errMsg;
	private Object returnValue;
	
	/*
	 * Constructor used to wrap error messages
	 */
	public ReturnObjectImpl(ErrorMessage msg){
		//TO DO: Implement
	}
	
	
	/*
	 * Constructor used to wrap return values
	 */
	public ReturnObjectImpl(Object value){
		//TO DO: Implement
	}
	
	@Override
	public boolean hasError() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ErrorMessage getError() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getReturnValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
}