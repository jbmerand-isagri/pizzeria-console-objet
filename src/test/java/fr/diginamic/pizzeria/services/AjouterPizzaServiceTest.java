/**
 * 
 */
package fr.diginamic.pizzeria.services;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.diginamic.pizzeria.dao.PizzaMemDao;
import fr.diginamic.pizzeria.exception.SavePizzaException;

/**
 * Classe de test du service AjouterPizzaService
 */
public class AjouterPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecuteUCWithCorrectDatas() throws SavePizzaException {
		PizzaMemDao dao = new PizzaMemDao();
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		systemInMock.provideLines("FOR", "Forestiere", "14.35", "1");
		ajouterPizzaService.executeUC(new Scanner(System.in), dao);
	}

	@Test(expected = SavePizzaException.class)
	public void testExecuteUCWithAnExistingPizza() throws SavePizzaException {
		PizzaMemDao dao = new PizzaMemDao();
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		systemInMock.provideLines("PEP", "Forestiere", "14.35", "1");
		ajouterPizzaService.executeUC(new Scanner(System.in), dao);
	}

	@Test(expected = SavePizzaException.class)
	public void testExecuteUCWithAnEmptyCode() throws SavePizzaException {
		PizzaMemDao dao = new PizzaMemDao();
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		systemInMock.provideLines("", "Forestiere", "14.35", "1");
		ajouterPizzaService.executeUC(new Scanner(System.in), dao);
	}

	@Test(expected = SavePizzaException.class)
	public void testExecuteUCWithNoParsablePrice() throws SavePizzaException {
		PizzaMemDao dao = new PizzaMemDao();
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		systemInMock.provideLines("FOR", "Forestiere", "BOB", "1");
		ajouterPizzaService.executeUC(new Scanner(System.in), dao);
	}

	@Test(expected = SavePizzaException.class)
	public void testExecuteUCWithNoParsableCategory() throws SavePizzaException {
		PizzaMemDao dao = new PizzaMemDao();
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		systemInMock.provideLines("FOR", "Forestiere", "16", "LENON");
		ajouterPizzaService.executeUC(new Scanner(System.in), dao);
	}

}
