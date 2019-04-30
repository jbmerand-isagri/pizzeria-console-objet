package fr.diginamic.pizzeria;

import fr.diginamic.pizzeria.controller.MenuController;
import fr.diginamic.pizzeria.view.Menu;

/**
 * Hello world!
 *
 */
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		programme();
	}

	public static void programme() {
		Menu menu = new Menu();
		menu.afficherMenu();
		int choix = menu.recueillirChoixUtilisateur();
		MenuController menuController = new MenuController(choix);
		menuController.executeChoix();
	}
}
