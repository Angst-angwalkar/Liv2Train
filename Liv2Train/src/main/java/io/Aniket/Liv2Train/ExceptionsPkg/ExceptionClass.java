package io.Aniket.Liv2Train.ExceptionsPkg;

public class ExceptionClass extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceptionClass(String message){
		super(message);
	}
	
	public static String NotFoundException(String CenterCode) {
		return "Center with code " + CenterCode + " not found!";
	}
	
	public static String AlreadyExistsException(String CenterCode) {
		return "Center with the Center Code "+ CenterCode +" already exists!";
	}
	

}
