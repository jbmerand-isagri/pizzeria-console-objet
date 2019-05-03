/**
 * 
 */
package fr.diginamic.pizzeria.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.pizzeria.dao.IPizzaDao;
import fr.diginamic.pizzeria.exception.UpdateException;
import fr.diginamic.pizzeria.model.Pizza;

/**
 * Classe pour la modification des informations d'une pizza de la liste.
 * 
 * @author Jean-Baptiste
 *
 */
public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws UpdateException {
		System.out.println("*** Mise à jour d'une pizza ***");
		// affichage des pizzas
		List<Pizza> listeDesPizzas = dao.findAllPizzas();
		for (int i = 0; i < listeDesPizzas.size(); i++) {
			System.out.println(listeDesPizzas.get(i).toString());
		}
		// choix de la pizza à modifier
		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		String choixCode = scanner.nextLine().toUpperCase();
		// continuer que si la pizza existe bien
		if (!dao.pizzaExists(choixCode)) {
			throw new UpdateException("Cette pizza n'existe pas.");
		}
		// choix des nouvelles informations
		System.out.println("Veuillez saisir le nouveau code");
		String nouveauCode = scanner.nextLine();
		if (!dao.pizzaExists(nouveauCode)) {
			System.out.println("Veuillez saisir le nouveau nom (sans espace)");
			String nouveauNom = scanner.nextLine();
			System.out.println("Veuillez saisir le nouveau prix");
			String nouveauPrix = scanner.nextLine();
			if (!NumberUtils.isParsable(nouveauPrix)) {
				throw new UpdateException("Vous n'avez pas entré un prix correct.");
			}
			// création et envoie de la nouvelle pizza
			Pizza nouvellePizza = new Pizza(nouveauCode, nouveauNom, Double.parseDouble(nouveauPrix));
			dao.updatePizza(choixCode, nouvellePizza);
		}

	}

}
