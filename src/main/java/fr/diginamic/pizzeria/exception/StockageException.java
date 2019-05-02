/**
 * 
 */
package fr.diginamic.pizzeria.exception;

/**
 * Classe mère des exceptions.
 * 
 * @author Jean-Baptiste
 *
 */
public abstract class StockageException extends Exception {

	/**
	 * Constructor
	 * 
	 */
	public StockageException() {
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public StockageException(String message) {
		super(message);
	}
}
