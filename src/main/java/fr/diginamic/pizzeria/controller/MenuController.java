/**
 * 
 */
package fr.diginamic.pizzeria.controller;

import fr.diginamic.pizzeria.PizzeriaAdminConsoleApp;
import fr.diginamic.pizzeria.database.Stocks;
import fr.diginamic.pizzeria.view.Menu;

/**
 * @author Jean-Baptiste
 *
 */
public class MenuController {

	private int numeroChoisi;

	/**
	 * Constructor
	 * 
	 * @param numero
	 */
	public MenuController(int numeroChoisi) {
		this.numeroChoisi = numeroChoisi;
	}

	// TODO
	public boolean executeChoix() {
		if (numeroChoisi == 1) {
			listerPizzas();
			return true;
		} else if (numeroChoisi == 2)
			ajouterPizza();
		else if (numeroChoisi == 3)
			editerPizza();
		else if (numeroChoisi == 4)
			supprimerPizza();
		else if (numeroChoisi == 99)
			sortir();
		else
			afficherErreurDeChoix();

	}

	// TODO
	public void listerPizzas() {
		System.out.println("Liste des pizzas");
		Stocks pizzaStock = new Stocks();
		System.out.println(pizzaStock.getListeDesPizzas());
		PizzeriaAdminConsoleApp.programme();
	}

	// TODO
	public void ajouterPizza() {
		Stocks pizzaStock = new Stocks();
		System.out.println("Ajout d'une nouvelle pizza");
	}

	public void editerPizza() {
		System.out.println("Mise à jour d'une pizza");
	}

	public void supprimerPizza() {
		System.out.println("Suppression d'une pizza");
	}

	public void sortir() {
		System.out.println("Au revoir :-(");
	}

	public void afficherErreurDeChoix() {
		System.out.println("Choix impossible. Merci de recommencer.");
		Menu menu = new Menu();
		numeroChoisi = menu.recueillirChoixUtilisateur();
		executeChoix();
	}

}
