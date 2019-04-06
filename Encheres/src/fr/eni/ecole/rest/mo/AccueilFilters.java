package fr.eni.ecole.rest.mo;

/**
 * Classe reprenant toutes les informations de filtres disponibles sur l'accueil
 * @author romai
 *
 */
public class AccueilFilters {
	private String nameFilter;
	private Integer noCategorie;
	private String radioButtons;
	private Boolean enchereOuverteChecked, 
					encheresEnCoursChecked,
					encheresRemporteesChecked,
					ventesEnCoursChecked,
					ventesNonDebuteesChecked,
					ventesTermineesChecked;
	
	public AccueilFilters(String nameFilter, Integer noCategorie, String radioButtons, Boolean enchereOuverteChecked,
			Boolean encheresEnCoursChecked, Boolean encheresRemporteesChecked, Boolean ventesEnCoursChecked,
			Boolean ventesNonDebuteesChecked, Boolean ventesTermineesChecked) {
		super();
		this.nameFilter = nameFilter;
		this.noCategorie = noCategorie;
		this.radioButtons = radioButtons;
		this.enchereOuverteChecked = enchereOuverteChecked;
		this.encheresEnCoursChecked = encheresEnCoursChecked;
		this.encheresRemporteesChecked = encheresRemporteesChecked;
		this.ventesEnCoursChecked = ventesEnCoursChecked;
		this.ventesNonDebuteesChecked = ventesNonDebuteesChecked;
		this.ventesTermineesChecked = ventesTermineesChecked;
	}
	public String getNameFilter() {
		return nameFilter;
	}
	public void setNameFilter(String nameFilter) {
		this.nameFilter = nameFilter;
	}
	public Integer getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getRadioButtons() {
		return radioButtons;
	}
	public void setRadioButtons(String radioButtons) {
		this.radioButtons = radioButtons;
	}
	public Boolean getEnchereOuverteChecked() {
		return enchereOuverteChecked;
	}
	public void setEnchereOuverteChecked(Boolean enchereOuverteChecked) {
		this.enchereOuverteChecked = enchereOuverteChecked;
	}
	public Boolean getEncheresEnCoursChecked() {
		return encheresEnCoursChecked;
	}
	public void setEncheresEnCoursChecked(Boolean encheresEnCoursChecked) {
		this.encheresEnCoursChecked = encheresEnCoursChecked;
	}
	public Boolean getEncheresRemporteesChecked() {
		return encheresRemporteesChecked;
	}
	public void setEncheresRemporteesChecked(Boolean encheresRemporteesChecked) {
		this.encheresRemporteesChecked = encheresRemporteesChecked;
	}
	public Boolean getVentesEnCoursChecked() {
		return ventesEnCoursChecked;
	}
	public void setVentesEnCoursChecked(Boolean ventesEnCoursChecked) {
		this.ventesEnCoursChecked = ventesEnCoursChecked;
	}
	public Boolean getVentesNonDebuteesChecked() {
		return ventesNonDebuteesChecked;
	}
	public void setVentesNonDebuteesChecked(Boolean ventesNonDebuteesChecked) {
		this.ventesNonDebuteesChecked = ventesNonDebuteesChecked;
	}
	public Boolean getVentesTermineesChecked() {
		return ventesTermineesChecked;
	}
	public void setVentesTermineesChecked(Boolean ventesTermineesChecked) {
		this.ventesTermineesChecked = ventesTermineesChecked;
	}
	
}
