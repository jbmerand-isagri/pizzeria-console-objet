/**
 * 
 */
package fr.diginamic.pizzeria.services;

import java.util.Scanner;

import fr.diginamic.pizzeria.dao.PizzaMemDao;
import fr.diginamic.pizzeria.model.Pizza;

/**
 * Classe pour les ajouts de pizzas.
 * 
 * @author Jean-Baptiste
 *
 */
public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao dao) {
		System.out.println("*** Ajout d'une nouvelle pizza ***");
		System.out.println("Veuillez saisir le code :");
		String choixCode = scanner.nextLine();
		if (!dao.pizzaExists(choixCode)) {
			System.out.println("Veuillez saisir le nom (sans espace) :");
			String choixNom = scanner.nextLine();
			System.out.println("Veuillez saisir le prix :");
			Double choixPrix = Double.parseDouble(scanner.nextLine());
			Pizza nouvellePizza = new Pizza(choixCode, choixNom, choixPrix);
			dao.saveNewPizza(nouvellePizza);
			System.out.println("-> Pizza ajoutée.");
		} else {
			System.out.println("Err : ce code est déjà utilisé pour une autre pizza !!");
		}

	}
}
