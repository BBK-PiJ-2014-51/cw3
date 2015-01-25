package tests;
import returnobject.ErrorMessage;
import returnobject.ReturnObject;
import returnobject.ReturnObjectImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ReturnObjectTest{
	ReturnObject returnValue;
	ReturnObject returnErr;
	
	@Before
	public void build(){
		returnValue = new ReturnObjectImpl(new Integer(3));
		returnErr = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
	}
	
	@Test
	public void validInputHasError(){
		assertEquals(false, returnValue.hasError());
	}
	
	@Test
	public void validInputReturnsValue(){
		assertEquals(new Integer(3), returnValue.getReturnValue());
	}
	
	@Test
	public void validInputReturnsNoError(){
		assertEquals(ErrorMessage.NO_ERROR, returnValue.getError());
	}
	
	@Test
	public void errorHasError(){
		assertEquals(true, returnErr.hasError());
	}
	
	@Test
	public void errorReturnsError(){
		assertEquals(ErrorMessage.INVALID_ARGUMENT, returnErr.getError());
	}
	
	@Test
	public void errorReturnsNullValue(){
		assertEquals(null, returnErr.getReturnValue());
	}
	
}