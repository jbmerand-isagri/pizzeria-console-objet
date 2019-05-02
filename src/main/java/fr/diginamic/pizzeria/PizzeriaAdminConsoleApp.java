package fr.diginamic.pizzeria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import fr.diginamic.pizzeria.model.Pizza;
import fr.diginamic.pizzeria.view.Menu;

/**
 * Hello world!
 *
 */
public class PizzeriaAdminConsoleApp {

	public static ArrayList<Pizza> listeDesPizzas;

	public static void main(String[] args) {

		Pizza pizza1 = new Pizza(0, "PEP", "Pépéroni", 12.50);
		Pizza pizza2 = new Pizza(1, "MAR", "Margherita", 14.00);
		Pizza pizza3 = new Pizza(2, "REIN", "La Reine", 11.50);
		Pizza pizza4 = new Pizza(3, "FRO", "La 4 fromage", 12.00);
		Pizza pizza5 = new Pizza(4, "CAN", "La cannibale", 12.50);
		Pizza pizza6 = new Pizza(5, "SAV", "La savoyarde", 13.00);
		Pizza pizza7 = new Pizza(6, "ORI", "L'orientale", 13.50);
		Pizza pizza8 = new Pizza(7, "IND", "L'indienne", 14.00);

		listeDesPizzas = new ArrayList<>();

		listeDesPizzas.addAll(Arrays.asList(pizza1, pizza2, pizza3, pizza4, pizza5, pizza6, pizza7, pizza8));

		programmeCRUD();
	}

	/**
	 * Lance l'interface de gestion des stocks de pizzas.
	 */
	public static void programmeCRUD() {
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu();
		menu.afficherMenu();
		menu.recueillirChoixUtilisateur();

	}
}
