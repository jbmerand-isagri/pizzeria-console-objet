/**
 * 
 */
package fr.diginamic.pizzeria.services;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.pizzeria.dao.IPizzaDao;
import fr.diginamic.pizzeria.exception.SavePizzaException;
import fr.diginamic.pizzeria.model.CategoriePizza;
import fr.diginamic.pizzeria.model.Pizza;

/**
 * Classe pour les ajouts de pizzas.
 * 
 * @author Jean-Baptiste
 *
 */
public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws SavePizzaException {
		System.out.println("*** Ajout d'une nouvelle pizza ***");
		System.out.println("Veuillez saisir le code :");
		String choixCode = scanner.nextLine();
		if (choixCode.equals("")) {
			throw new SavePizzaException("Veuillez entrer une valeur.");
		}
		if (dao.pizzaExists(choixCode)) {
			throw new SavePizzaException("Ce code est déjà utilisé pour une autre pizza.");
		}
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String choixNom = scanner.nextLine();
		System.out.println("Veuillez saisir le prix :");
		String choixPrix = scanner.nextLine();
		if (!NumberUtils.isParsable(choixPrix)) {
			throw new SavePizzaException("Vous n'avez pas entré un prix correct.");
		}
		System.out.println(
				"Veuillez saisir le numéro correspondant à sa catégorie (1.VIANDE / 2.POISSON / 3.SANS_VIANDE)");
		String choixCategorie = scanner.nextLine();
		if (!NumberUtils.isParsable(choixCategorie)) {
			throw new SavePizzaException("Vous n'avez pas saisi une catégorie correcte.");
		}
		int choixCateInt = Integer.parseInt(choixCategorie);
		if (choixCateInt > 3 || choixCateInt < 1) {
			throw new SavePizzaException("Le numéro de catégorie saisi n'existe pas.");
		}

		// Initialisation par défault avec VIANDE
		CategoriePizza categoChoisie = CategoriePizza.VIANDE;
		if (choixCateInt == 2)
			categoChoisie = CategoriePizza.POISSON;
		else if (choixCateInt == 3)
			categoChoisie = CategoriePizza.SANS_VIANDE;

		Pizza nouvellePizza = new Pizza(choixCode, choixNom, Double.parseDouble(choixPrix), categoChoisie);
		dao.saveNewPizza(nouvellePizza);
		System.out.println("-> Pizza ajoutée.");

	}
}
