/**
 * 
 */
package fr.diginamic.pizzeria.services;

import java.util.Scanner;

import fr.diginamic.pizzeria.dao.IPizzaDao;

/**
 * Classe mère des services CRUD liés à l'application.
 * 
 * @author Jean-Baptiste
 *
 */
public abstract class MenuService {

	/**
	 * Gère l'interaction avec l'utilisateur et exécute le cas d'utilisation
	 * approprié
	 * 
	 * @param scanner
	 *            pour récupèrer le texte entré par les utilisateurs
	 * @param dao
	 *            contenant la liste des pizzas et les méthodes CRUD agissant sur
	 *            cette liste
	 */
	abstract void executeUC(Scanner scanner, IPizzaDao dao);

}
