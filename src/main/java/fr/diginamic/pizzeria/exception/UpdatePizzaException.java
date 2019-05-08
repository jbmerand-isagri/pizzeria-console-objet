/**
 * 
 */
package fr.diginamic.pizzeria.exception;

/**
 * @author Jean-Baptiste
 *
 */
public class UpdatePizzaException extends StockageException {

	/**
	 * Constructor
	 * 
	 */
	public UpdatePizzaException() {
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public UpdatePizzaException(String message) {
		super(message);
	}

}
