package fr.diginamic.pizzeria;

import java.util.Scanner;

import fr.diginamic.pizzeria.dao.PizzaMemDao;
import fr.diginamic.pizzeria.services.AjouterPizzaService;
import fr.diginamic.pizzeria.services.ListerPizzaService;
import fr.diginamic.pizzeria.services.ModifierPizzaService;
import fr.diginamic.pizzeria.services.SupprimerPizzaService;

/**
 * Classe principale, d'entrée, de l'application Pizzeria.
 * 
 * @author Jean-Baptiste
 *
 */
public class PizzeriaAdminConsoleApp {

	/**
	 * Point d'entrée d'exécution de l'application pizzeria
	 * 
	 * @param args
	 *            non utilisés
	 */
	public static void main(String[] args) {

		// initialisation du scanner
		Scanner scanner = new Scanner(System.in);

		// initialisation du DAO
		PizzaMemDao dao = new PizzaMemDao();

		int choixUtilisateur = 0;

		while (choixUtilisateur != 99) {
			// afficher les options d'administration du menu
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");

			// recueille le choix de l'utilisateur et exécute le service qui correspond
			choixUtilisateur = Integer.parseInt(scanner.nextLine());
			switch (choixUtilisateur) {
			case 1:
				ListerPizzaService listerService = new ListerPizzaService();
				listerService.executeUC(scanner, dao);
				break;
			case 2:
				AjouterPizzaService ajouterService = new AjouterPizzaService();
				ajouterService.executeUC(scanner, dao);
				break;
			case 3:
				ModifierPizzaService modifierService = new ModifierPizzaService();
				modifierService.executeUC(scanner, dao);
				break;
			case 4:
				SupprimerPizzaService supprimerService = new SupprimerPizzaService();
				supprimerService.executeUC(scanner, dao);
				break;
			case 99:
				System.out.println("Au revoir :-)");
				break;
			default:
				System.out.println("Choix impossible. Merci de recommencer.");
				break;
			}
		}
		scanner.close();
	}
}
