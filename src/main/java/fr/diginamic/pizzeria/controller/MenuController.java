/**
 * 
 */
package fr.diginamic.pizzeria.controller;

import java.util.Scanner;

import fr.diginamic.pizzeria.PizzeriaAdminConsoleApp;
import fr.diginamic.pizzeria.model.Pizza;
import fr.diginamic.pizzeria.view.Menu;

/**
 * @author Jean-Baptiste
 *
 */
public class MenuController {

	private int numeroChoisi;
	private boolean isCorrectChoice;
	// TODO ne pas répéter utilisation scanner
	Scanner scanner = new Scanner(System.in);

	/**
	 * Constructor
	 * 
	 * @param numero
	 */
	public MenuController(int numeroChoisi) {
		this.numeroChoisi = numeroChoisi;
	}

	/**
	 * Execute les méthodes qui correspondent au choix de l'utilisateur.
	 * 
	 */
	public void executeChoix() {
		if (numeroChoisi == 1) {
			listerPizzas();
		} else if (numeroChoisi == 2) {
			ajouterPizza();
		} else if (numeroChoisi == 3) {
			editerPizza();
		} else if (numeroChoisi == 4) {
			supprimerPizza();
		} else if (numeroChoisi == 99) {
			sortir();
		} else {
			afficherErreurDeChoix();
		}
	}

	/**
	 * Affiche les pizzas présentes en stock, relance le choix.
	 */
	public void listerPizzas() {
		System.out.println("Liste des pizzas");
		for (int i = 0; i < PizzeriaAdminConsoleApp.listeDesPizzas.size(); i++) {
			Pizza pizza = PizzeriaAdminConsoleApp.listeDesPizzas.get(i);
			System.out.println(pizza.getCode() + " -> " + pizza.getLibelle() + " (" + pizza.getPrix() + " €)");
		}

		// Stocks pizzaStock = new Stocks();
		// System.out.println(pizzaStock.getListeDesPizzas());
		PizzeriaAdminConsoleApp.programmeCRUD();
	}

	/**
	 * Ajoute une pizza dans le stock, relance le choix.
	 */
	public void ajouterPizza() {
		// Stocks pizzaStock = new Stocks();
		System.out.println("Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code :");
		String choixCode = scanner.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String choixNom = scanner.nextLine();
		System.out.println("Veuillez saisir le prix :");
		Double choixPrix = Double.parseDouble(scanner.nextLine());
		Pizza nouvellePizza = new Pizza(choixCode, choixNom, choixPrix);
		PizzeriaAdminConsoleApp.listeDesPizzas.add(nouvellePizza);
		PizzeriaAdminConsoleApp.programmeCRUD();
	}

	/**
	 * Edite une pizza présente dans le stock, relance le choix.
	 */
	public void editerPizza() {
		System.out.println("Mise à jour d'une pizza");
		for (int i = 0; i < PizzeriaAdminConsoleApp.listeDesPizzas.size(); i++) {
			Pizza pizza = PizzeriaAdminConsoleApp.listeDesPizzas.get(i);
			System.out.println(pizza.getCode() + " -> " + pizza.getLibelle() + " (" + pizza.getPrix() + " €)");
		}
		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		String choixCode = scanner.nextLine().toUpperCase();

		// TODO possibilité d'afficher quelque chose si code existe pas
		int pizzaIndex = 0;
		for (int i = 0; i < PizzeriaAdminConsoleApp.listeDesPizzas.size(); i++) {
			if (PizzeriaAdminConsoleApp.listeDesPizzas.get(i).getCode().equals(choixCode)) {
				pizzaIndex = i;
			}
		}

		System.out.println("Veuillez saisir le nouveau code");
		String nouveauCode = scanner.nextLine();
		System.out.println("Veuillez saisir le nouveau nom (sans espace)");
		String nouveauNom = scanner.nextLine();
		System.out.println("Veuillez saisir le nouveau prix");
		Double nouveauPrix = Double.parseDouble(scanner.nextLine());

		PizzeriaAdminConsoleApp.listeDesPizzas.get(pizzaIndex).setCode(nouveauCode);
		PizzeriaAdminConsoleApp.listeDesPizzas.get(pizzaIndex).setLibelle(nouveauNom);
		PizzeriaAdminConsoleApp.listeDesPizzas.get(pizzaIndex).setPrix(nouveauPrix);

		PizzeriaAdminConsoleApp.programmeCRUD();
	}

	/**
	 * Supprime une pizza du stock, relance le choix.
	 */
	public void supprimerPizza() {
		System.out.println("Suppression d'une pizza");
		System.out.println("Veuillez choisir le code de la pizza à supprimer.");
		String choixCode = scanner.nextLine().toUpperCase();

		// TODO possibilité d'afficher quelque chose si code existe pas
		int pizzaASupprIndex = 0;
		for (int i = 0; i < PizzeriaAdminConsoleApp.listeDesPizzas.size(); i++) {
			if (PizzeriaAdminConsoleApp.listeDesPizzas.get(i).getCode().equals(choixCode)) {
				pizzaASupprIndex = i;
			}
		}

		PizzeriaAdminConsoleApp.listeDesPizzas.remove(pizzaASupprIndex);
		PizzeriaAdminConsoleApp.programmeCRUD();
	}

	/**
	 * Quitte le menu.
	 */
	public void sortir() {
		System.out.println("Au revoir :-(");
	}

	/**
	 * Affiche une erreur et redemande à l'utilisateur de faire son choix.
	 */
	public void afficherErreurDeChoix() {
		System.out.println("Choix impossible. Merci de recommencer.");
		Menu menu = new Menu();
		menu.recueillirChoixUtilisateur();
	}

}
