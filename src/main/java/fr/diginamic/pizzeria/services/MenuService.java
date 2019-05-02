/**
 * 
 */
package fr.diginamic.pizzeria.services;

import java.util.Scanner;

import fr.diginamic.pizzeria.dao.PizzaMemDao;

/**
 * Classe mère des services CRUD liés à l'application.
 * 
 * @author Jean-Baptiste
 *
 */
public abstract class MenuService {

	/**
	 * @param scanner
	 *            pour récupèrer le texte entré par les utilisateurs
	 * @param dao
	 *            contenant la liste des pizzas et les méthodes CRUD agissant sur
	 *            cette liste
	 */
	abstract void executeUC(Scanner scanner, PizzaMemDao dao);

}
