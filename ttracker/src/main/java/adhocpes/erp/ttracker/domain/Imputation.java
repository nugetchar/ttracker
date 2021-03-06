package adhocpes.erp.ttracker.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import adhocpes.erp.ref.model.Consultant;
import adhocpes.erp.ttracker.utils.Charge;

@Entity
@Table(name="IMPUTATION")
public class Imputation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private double charge;
	
	@Id
	@Column(name="jour")
	@NotNull
	private DateTime jour;
	
	
	private Consultant consultant;
	private Tache tache;

	public Imputation(){
		super();
	}

	public Imputation(double charge, DateTime jour, Consultant consultant, Tache tache){
		this();
		this.charge = charge;
		this.jour = jour;
		this.consultant = consultant;
		this.tache = tache;
	}

	public void setCharge(double charge) {
		assert(Charge.isAValidCharge(charge));
		this.charge = charge;
	}

	public int getMonth(){
		return jour.getMonthOfYear();
	}

	public DateTime getJour() {
		return jour;
	}

	public void setJour(DateTime jour) {
		this.jour = jour;
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	public double getCharge() {
		return charge;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imputation other = (Imputation) obj;
		return (other.charge == this.charge) && (other.consultant.equals(this.consultant)) && 
				(other.jour.equals(this.jour)) && (other.tache.equals(this.tache));
	}
}
