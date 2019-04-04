package fr.eni.ecole.bll;

public class BuisnessException extends Exception {
	public BuisnessException(String message) {
		super(message);
	}
	
	public BuisnessException(String message, Throwable exception) {
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
