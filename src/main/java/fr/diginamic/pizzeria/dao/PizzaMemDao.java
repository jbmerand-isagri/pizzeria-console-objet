/**
 * 
 */
package fr.diginamic.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.pizzeria.model.CategoriePizza;
import fr.diginamic.pizzeria.model.Pizza;

/**
 * Classe DAO de l'application Pizzeria.
 * 
 * @author Jean-Baptiste
 *
 */
public class PizzaMemDao implements IPizzaDao {

	/** listeDesPizzas : List<Pizza> Contient les Pizza du programme. */
	private List<Pizza> listeDesPizzas = new ArrayList<>();

	/**
	 * Constructor
	 * 
	 */
	public PizzaMemDao() {

		// ajout des pizzas dans la base de données
		listeDesPizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listeDesPizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listeDesPizzas.add(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		listeDesPizzas.add(new Pizza(3, "FRO", "La 4 fromage", 12.00, CategoriePizza.SANS_VIANDE));
		listeDesPizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listeDesPizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listeDesPizzas.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		listeDesPizzas.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return this.listeDesPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		listeDesPizzas.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		if (pizzaExists(codePizza)) {
			Pizza anciennePizza = findPizzaByCode(codePizza);
			pizza.setId(anciennePizza.getId());
			listeDesPizzas.remove(anciennePizza);
			listeDesPizzas.add(pizza);
			System.out.println("-> Pizza modifiée.");
		} else {
			System.out.println("Err : cette pizza n'existe pas !!");
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		listeDesPizzas.remove(findPizzaByCode(codePizza));
		System.out.println("-> Pizza supprimée.");
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (int i = 0; i < listeDesPizzas.size(); i++) {
			if (listeDesPizzas.get(i).getCode().equals(codePizza)) {
				return listeDesPizzas.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for (int i = 0; i < listeDesPizzas.size(); i++) {
			if (listeDesPizzas.get(i).getCode().equals(codePizza)) {
				return true;
			}
		}
		return false;
	}

}
