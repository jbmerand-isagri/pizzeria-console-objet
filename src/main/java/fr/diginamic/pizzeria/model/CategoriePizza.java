package fr.diginamic.pizzeria.model;

/**
 * Enumération pour indiquer la catégorie de la pizza.
 */
public enum CategoriePizza {
	
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");
	
	/** nom : String */
	private String nom;
	
	/** Constructor
	 * @param nom
	 */
	private CategoriePizza(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
