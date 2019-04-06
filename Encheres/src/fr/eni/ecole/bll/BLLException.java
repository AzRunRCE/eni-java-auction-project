package fr.eni.ecole.bll;

public class BLLException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4738035485198035074L;

	public BLLException(String message) {
		super(message);
	}
	
	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}

	//Methodes
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche BLL - ");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}
}
