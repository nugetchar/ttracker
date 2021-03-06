package adhocpes.erp.timetracker.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import adhocpes.erp.domain.Consultant;
import adhocpes.erp.domain.Projet;

/**
 * 
 * @author toledo
 * 
 */
@Entity(name = "T_Affectation")
public class Affectation{

	@Id
	@Column(name = "affectationId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "consultantId")
	@NotNull
	private Consultant consultantAffecte;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "projetId")
	@NotNull
	private Projet projetAffecte;

	public Affectation() {
		super();
	}

	public Affectation(Consultant c, Projet p) {
		this();
		this.consultantAffecte = c;
		this.projetAffecte = p;
	}

	public void setConsultant(Consultant c) {
		this.consultantAffecte = c;
	}

	public void setProjet(Projet p) {
		this.projetAffecte = p;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Consultant getConsultant() {
		return consultantAffecte;
	}

	public Projet getProjet() {
		return projetAffecte;
	}

	public long getId() {
		return id;
	}

	public String toString() {
		return "{\"id\":\"" + this.id + "\",\"projet\":\""
				+ this.projetAffecte.getNom() + "\",\"consultant\":\""
				+ this.consultantAffecte.getNom() + "\"}";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Affectation other = (Affectation) obj;
		if (!(id == other.id))
			return false;
		return true;
	}

	public static String stringifyList(List<Affectation> affectations) {
		String res = "[" + affectations.get(0);
		for (int i = 1; i < affectations.size(); ++i)
			res += "," + affectations.get(i);
		res += "]";
		return res;
	}

}
