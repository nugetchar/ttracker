package adhocpes.erp.ttracker.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="TACHE")
public class Tache implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6536608948385686269L;

	@Id
	@Column(name="nom")
	@NotNull
	private String nom;
	
	@Column(name="fini")
	@NotNull
	private boolean fini;
	
	@Column(name="date_debut")
	@NotNull
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime date_debut;

	public Tache(){
		super();
	}

	public Tache(String nom, boolean fini) {
		this();
		this.nom = nom;
		this.fini = fini;
		this.date_debut = today();
	}
	
	public Tache(String nom, boolean fini, DateTime date_debut) {
		this();
		this.nom = nom;
		this.fini = fini;
		this.date_debut = date_debut;
	}
	
	private DateTime today(){
		return DateTime.now();
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isFini() {
		return fini;
	}

	public void setFini(boolean fini) {
		this.fini = fini;
	}

	public DateTime getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(DateTime date_debut) {
		this.date_debut = date_debut;
	}

	public String toString(){
		return "nom: " + this.nom + ". fini: " + this.fini + 
				". date début: " + this.date_debut + ".";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tache other = (Tache) obj;
		return (other.nom == this.nom) && (other.fini == this.fini) && 
				(other.date_debut.equals(this.date_debut));
	}
}
