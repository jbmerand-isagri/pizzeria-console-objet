/**
 * 
 */
package fr.diginamic.pizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.diginamic.pizzeria.model.CategoriePizza;
import fr.diginamic.pizzeria.model.Pizza;

/**
 *
 */
public class PizzaMemDaoTest {

	@Test
	public void testFindAllPizzas() {
		List<Pizza> listeDesPizzas = new ArrayList<>();
		listeDesPizzas.add(new Pizza("FOR", "Forestiere", 19.50, CategoriePizza.VIANDE));
		listeDesPizzas.add(new Pizza("VEG", "Vegetarienne", 20.50, CategoriePizza.SANS_VIANDE));
		assertEquals(2, listeDesPizzas.size());
	}

	@Test
	public void testSaveNewPizzaWithOnePizza() {
		PizzaMemDao dao = new PizzaMemDao();
		Pizza pizza = new Pizza("FOR", "Forestiere", 19.50, CategoriePizza.VIANDE);
		dao.saveNewPizza(pizza);
		assertEquals(pizza, dao.findPizzaByCode("FOR"));
	}

	@Test
	public void testUpdatePizza() {
		PizzaMemDao dao = new PizzaMemDao();
		Pizza pizza = new Pizza("FOR", "Forestiere", 19.50, CategoriePizza.VIANDE);
		dao.updatePizza("PEP", pizza);
		assertEquals(pizza, dao.findPizzaByCode("FOR"));
	}

	@Test
	public void testDeletePizza() {
		PizzaMemDao dao = new PizzaMemDao();
		dao.deletePizza("PEP");
		assertNull(dao.findPizzaByCode("PEP"));
	}

	@Test
	public void testFindPizzaByCodeWithNull() {
		PizzaMemDao dao = new PizzaMemDao();
		assertNull(dao.findPizzaByCode("FOR"));
	}

	@Test
	public void testFindPizzaByCodeWith1Pizza() {
		PizzaMemDao dao = new PizzaMemDao();
		Pizza pizza = new Pizza("FOR", "Forestiere", 19.50, CategoriePizza.VIANDE);
		dao.saveNewPizza(pizza);
		assertEquals(pizza, dao.findPizzaByCode("FOR"));
	}

	@Test
	public void testPizzaExistsWithAnExistingPizza() {
		PizzaMemDao dao = new PizzaMemDao();
		boolean obtenu = dao.pizzaExists("PEP");
		assertTrue(obtenu);
	}

	@Test
	public void testPizzaExistsWithNoExistingPizza() {
		PizzaMemDao dao = new PizzaMemDao();
		boolean obtenu = dao.pizzaExists("PLE");
		assertFalse(obtenu);
	}

}
