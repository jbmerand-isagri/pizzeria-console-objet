/**
 * 
 */
package fr.diginamic.pizzeria.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.pizzeria.dao.IPizzaDao;
import fr.diginamic.pizzeria.model.Pizza;

/**
 * Classe pour la modification des informations d'une pizza de la liste.
 * 
 * @author Jean-Baptiste
 *
 */
public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) {
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
		if (dao.pizzaExists(choixCode)) {
			// choix des nouvelles informations
			System.out.println("Veuillez saisir le nouveau code");
			String nouveauCode = scanner.nextLine();
			if (!dao.pizzaExists(nouveauCode)) {
				System.out.println("Veuillez saisir le nouveau nom (sans espace)");
				String nouveauNom = scanner.nextLine();
				System.out.println("Veuillez saisir le nouveau prix");
				Double nouveauPrix = Double.parseDouble(scanner.nextLine());
				// création et envoie de la nouvelle pizza
				Pizza nouvellePizza = new Pizza(nouveauCode, nouveauNom, nouveauPrix);
				dao.updatePizza(choixCode, nouvellePizza);
			}
		} else {
			System.out.println("Err : cette pizza n'existe pas !!");
		}

	}

}
