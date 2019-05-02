/**
 * 
 */
package fr.diginamic.pizzeria.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.pizzeria.dao.IPizzaDao;
import fr.diginamic.pizzeria.model.Pizza;

/**
 * Classe pour la récupération et l'affichage des pizzas.
 * 
 * @author Jean-Baptiste
 *
 */
public class ListerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) {
		System.out.println("*** Liste des pizzas ***");
		List<Pizza> listeDesPizzas = dao.findAllPizzas();
		for (int i = 0; i < listeDesPizzas.size(); i++) {
			System.out.println(listeDesPizzas.get(i).toString());
		}
	}

}
