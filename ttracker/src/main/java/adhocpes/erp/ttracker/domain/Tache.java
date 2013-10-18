package adhocpes.erp.ttracker.domain;


import org.joda.time.DateTime;

public class Tache {

	private String nom;
	private boolean fini;
	
	
	private DateTime date_debut;

	public Tache(){
		super();
	}

	public Tache(String nom, boolean fini, DateTime date_debut) {
		this();
		this.nom = nom;
		this.fini = fini;
		this.date_debut = date_debut;
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
