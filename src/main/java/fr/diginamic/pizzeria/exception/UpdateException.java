/**
 * 
 */
package fr.diginamic.pizzeria.exception;

/**
 * @author Jean-Baptiste
 *
 */
public class UpdateException extends StockageException {

	/**
	 * Constructor
	 * 
	 */
	public UpdateException() {
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public UpdateException(String message) {
		super(message);
	}

}
