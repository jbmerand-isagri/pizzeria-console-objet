/**
 * 
 */
package fr.diginamic.pizzeria.model;

/**
 * @author Jean-Baptiste
 *
 */
public class Pizza {

	private Integer id;
	private String code;
	private String libelle;
	private Double prix;
	private static int idCount = 0;

	/**
	 * Constructor
	 * 
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(String code, String libelle, Double prix) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.id = Pizza.idCount++;
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(Integer id, String code, String libelle, Double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
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
	 * @param id
	 *            the id to set
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
	 * @param code
	 *            the code to set
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
	 * @param libelle
	 *            the libelle to set
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
	 * @param prix
	 *            the prix to set
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
	 * @param idCount
	 *            the idCount to set
	 */
	public static void setIdCount(int idCount) {
		Pizza.idCount = idCount;
	}
}
