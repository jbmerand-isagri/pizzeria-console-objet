/**
 * 
 */
package fr.diginamic.pizzeria.dao;

import java.util.List;

import fr.diginamic.pizzeria.model.Pizza;

/**
 * Interface pour implémenter les méthodes CRUD et utiles de l'application.
 * 
 * @author Jean-Baptiste
 *
 */
public interface IPizzaDao {

	/**
	 * Récupère la liste de pizzas.
	 * 
	 * @return List<Pizza> la liste complète
	 */
	List<Pizza> findAllPizzas();

	/**
	 * Ajoute une pizza à la liste de pizzas.
	 * 
	 * @param pizza
	 */
	void saveNewPizza(Pizza pizza);

	/**
	 * Modifie une pizza de la liste de pizzas.
	 * 
	 * @param codePizza
	 *            de la pizza à modifier
	 * @param pizza
	 *            qui remplace celle à modifier
	 */
	void updatePizza(String codePizza, Pizza pizza);

	/**
	 * Supprime une pizza de la liste des pizzas.
	 * 
	 * @param codePizza
	 */
	void deletePizza(String codePizza);

	/**
	 * Récupère la pizza avec son code.
	 * 
	 * @param codePizza
	 *            de la pizza à trouver
	 * @return Pizza
	 */
	Pizza findPizzaByCode(String codePizza);

	/**
	 * Vérifie si la pizza existe dans la liste de pizzas.
	 * 
	 * @param codePizza
	 *            de la pizza à vérifier
	 * @return
	 */
	boolean pizzaExists(String codePizza);

}
