/**
 * 
 */
package fr.diginamic.pizzeria.model;

/**
 * Représente une pizza.
 * 
 * @author Jean-Baptiste
 *
 */
public class Pizza {

	/** id : Integer pour authentifier la pizza (id unique) */
	private Integer id;
	/** code : String code unique de dénomination de la pizza */
	private String code;
	/** libelle : String nom de la pizza */
	private String libelle;
	/** prix : Double prix en € de la pizza */
	private Double prix;
	/** idCount : int compteur pour gérer les id */
	private static int idCount = 0;
	/** categorie : CategoriePizza */
	private CategoriePizza categorie;

	/**
	 * Constructor
	 * 
	 * @param code
	 * @param libelle
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String libelle, Double prix, CategoriePizza categorie) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.id = Pizza.idCount++;
		this.categorie = categorie;
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 * @param categorie
	 */
	public Pizza(Integer id, String code, String libelle, Double prix, CategoriePizza categorie) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter
	 * 
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the prix
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * Setter
	 * 
	 * @param prix the prix to set
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	/**
	 * Getter
	 * 
	 * @return the idCount
	 */
	public static int getIdCount() {
		return idCount;
	}

	/**
	 * Setter
	 * 
	 * @param idCount the idCount to set
	 */
	public static void setIdCount(int idCount) {
		Pizza.idCount = idCount;
	}

	/**
	 * Getter
	 * 
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/**
	 * Setter
	 * 
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return code + " -> " + libelle + "(" + prix + " €)" + ", catégorie : " + categorie.getNom() + ".";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (categorie != other.categorie)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		return true;
	}
}
