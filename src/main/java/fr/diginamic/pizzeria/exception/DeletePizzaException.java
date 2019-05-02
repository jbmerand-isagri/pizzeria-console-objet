/**
 * 
 */
package fr.diginamic.pizzeria.exception;

/**
 * Exception liée à la suppression de pizzas.
 * 
 * @author Jean-Baptiste
 *
 */
public class DeletePizzaException extends StockageException {
	/**
	 * Constructor
	 * 
	 */
	public DeletePizzaException() {
	}

	/**
	 * Constructor
	 * 
	 * @param msg
	 */
	public DeletePizzaException(String msg) {
		super(msg);
	}
}
