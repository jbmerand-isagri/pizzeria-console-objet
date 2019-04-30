/**
 * 
 */
package fr.diginamic.pizzeria.database;

import java.util.ArrayList;

import fr.diginamic.pizzeria.model.Pizza;

/**
 * Assure la gestion des stocks de la pizzeria.
 * 
 * @author Jean-Baptiste
 *
 */
public class Stocks {
	private ArrayList<Pizza> listeDesPizzas = new ArrayList<>();

	/**
	 * Getter
	 * 
	 * @return the listeDesPizzas
	 */
	public ArrayList<Pizza> getListeDesPizzas() {
		return listeDesPizzas;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesPizzas
	 *            the listeDesPizzas to set
	 */
	public void setListeDesPizzas(ArrayList<Pizza> listeDesPizzas) {
		this.listeDesPizzas = listeDesPizzas;
	}
}
