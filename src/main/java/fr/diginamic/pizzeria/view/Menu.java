/**
 * 
 */
package fr.diginamic.pizzeria.view;

import java.util.Scanner;

import fr.diginamic.pizzeria.controller.MenuController;

/**
 * @author Jean-Baptiste
 *
 */
public class Menu {

	Scanner scanner;

	/**
	 * Affiche les options d'administration du menu.
	 */
	public void afficherMenu() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}

	/**
	 * Recueille le choix du menu opéré par l'utilisateur et le fait traiter au
	 * controller.
	 * 
	 * @return int numero du menu
	 */
	public void recueillirChoixUtilisateur() {
		Scanner scanner = new Scanner(System.in);
		int choixUtilisateur = Integer.parseInt(scanner.nextLine());
		MenuController menuController = new MenuController(choixUtilisateur);
		menuController.executeChoix();
	}

}
