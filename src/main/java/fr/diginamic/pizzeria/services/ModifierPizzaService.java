/**
 * 
 */
package fr.diginamic.pizzeria.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.pizzeria.dao.IPizzaDao;
import fr.diginamic.pizzeria.exception.UpdatePizzaException;
import fr.diginamic.pizzeria.model.CategoriePizza;
import fr.diginamic.pizzeria.model.Pizza;

/**
 * Classe pour la modification des informations d'une pizza de la liste.
 * 
 * @author Jean-Baptiste
 *
 */
public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws UpdatePizzaException {
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
			throw new UpdatePizzaException("Cette pizza n'existe pas.");
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
				throw new UpdatePizzaException("Vous n'avez pas entré un prix correct.");
			}
			System.out.println(
					"Veuillez saisir le numéro correspondant à sa catégorie (1.VIANDE / 2.POISSON / 3.SANS_VIANDE)");
			String choixCategorie = scanner.nextLine();
			if (!NumberUtils.isParsable(choixCategorie)) {
				throw new UpdatePizzaException("Vous n'avez pas saisi une catégorie correcte.");
			}
			int choixCateInt = Integer.parseInt(choixCategorie);
			if (choixCateInt > 3 || choixCateInt < 1) {
				throw new UpdatePizzaException("Le numéro de catégorie saisi n'existe pas.");
			}

			// Initialisation par défault avec VIANDE
			CategoriePizza categoChoisie = CategoriePizza.VIANDE;
			if (choixCateInt == 2)
				categoChoisie = CategoriePizza.POISSON;
			else if (choixCateInt == 3)
				categoChoisie = CategoriePizza.SANS_VIANDE;
			// création et envoie de la nouvelle pizza
			Pizza nouvellePizza = new Pizza(nouveauCode, nouveauNom, Double.parseDouble(nouveauPrix), categoChoisie);
			dao.updatePizza(choixCode, nouvellePizza);
		}

	}

}
