package entities;



import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Compte {
	private Integer code;
	private Float solde;
	private Date dateCreation;

	// CONSTRUCTEUR
	public Compte(Integer code, Float solde, Date dateCreation) {
		super();
		this.code = code;
		this.solde = solde;
		this.dateCreation = dateCreation;
	}

	public Compte() {

	}

	// GETTERS ET SETTERS
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Float getSolde() {
		return solde;
	}

	public void setSolde(Float solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

}
