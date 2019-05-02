/**
 * 
 */
package fr.diginamic.pizzeria.exception;

/**
 * Exception liée à un ajout de pizza.
 * 
 * @author Jean-Baptiste
 *
 */
public class SavePizzaException extends StockageException {
	/**
	 * Constructor
	 * 
	 */
	public SavePizzaException() {
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public SavePizzaException(String message) {
		super(message);
	}
}
