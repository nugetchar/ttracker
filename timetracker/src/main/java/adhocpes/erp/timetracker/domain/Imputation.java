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

/**
 * 
 * @author toledo
 *
 */
@Entity(name="T_Imputation")
public class Imputation implements Serializable{

	private static final long serialVersionUID = -6512600497880831081L;

	@Id
	@Column(name="imputationId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@NotNull
	private double charge;

	@NotNull
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate jour;


	private int month;
	private int year;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="consultantId")
	@NotNull
	private Consultant consultant;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="tacheId")
	@NotNull
	private Tache tache;


	public static String stringifyImputationList(List<Imputation> imputations, int month, int year){
		int cpt = 0;
		String res = "[";
		HashMap<Tache,List<Imputation>> taches = recupererTachesFromImputationList(imputations);
		Set<Tache> tmp = taches.keySet();
		List<Imputation> item;
		Imputation imp;
		for(Tache t : tmp){
			res += "{ \"projet\":\""+t.getprojet().getNom()+"\",\"tache\":\""
					+t.getNom()+"\",";
			item = taches.get(t);
			for(int i=1; i<32; ++i){
				if((imp=getImputationForThisDay(i,item)) != null){
					res += "\"" + i + "\":\"" + (int)imp.getCharge() + "\"";
				}
				else{
					res +="\"" + i + "\":\"0\"";
				}
				if(i<31)
					res +=",";
			}

			res += "}";
			cpt ++;
			if(cpt<tmp.size()-1)
				res +=",";
		}
		res +="]";
		return res;
	}

	private static Imputation getImputationForThisDay(int day,List<Imputation> imputations){
		for(Imputation i : imputations){
			if(i.getJour().getDayOfMonth() == day)
				return i;
		}
		return null;
	}

	public static List<Imputation >createImputationsFromMapTacheConsultant(Consultant c, Tache t, Map<String, String> map){
		List<Imputation> res = new ArrayList<Imputation>();
		Set<String> keys;

		int month = new Integer(map.get("month"));
		int year = new Integer(map.get("year"));
		Long i;

		map.remove("projetId");
		map.remove("tacheId");
		map.remove("month");
		map.remove("year");
		keys = map.keySet();

		String str;
		for(String s : keys){
			str = map.get(s).trim();
			i = new Long(str);
			if(!(i == 0))
				res.add(new Imputation(i,new LocalDate(year,month,new Integer(s)),c,t));
		}


		return res;
	}

	private static HashMap<Tache,List<Imputation>> recupererTachesFromImputationList(List<Imputation> imputations){
		HashMap<Tache,List<Imputation>> map = new HashMap<Tache,List<Imputation>>();
		for(Imputation i : imputations){
			if(map.get(i.getTache()) == null)
				map.put(i.getTache(), new ArrayList<Imputation>());
			map.get(i.getTache()).add(i);
		}
		return map;
	}

	public Imputation(){
		super();
	}

	public Imputation(double charge, LocalDate jour, Consultant consultant, Tache tache){
		this();
		//TODO renvoyer une exception à la place
		assert(Charge.isAValidCharge(charge));
		this.charge = charge;
		this.jour = jour;
		this.consultant = consultant;
		this.tache = tache;

		this.month = jour.getMonthOfYear();
		this.year = jour.getYear();
	}

	public void setCharge(double charge) {
		assert(Charge.isAValidCharge(charge));
		this.charge = charge;
	}

	public LocalDate getJour() {
		return jour;
	}

	public void setJour(LocalDate jour) {
		this.jour = jour;
		this.month = jour.getMonthOfYear();
		this.year = jour.getYear();
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

	public String toString(){
		return "ID: " + id +  ", Jour: " + jour + ", charge: " + charge;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private static class Charge {

		private static double[] charges = {1,0.5,0.25,0};

		public static boolean isAValidCharge(double c) {
			for(double d : charges){
				if(c == d)
					return true;
			}
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(charge);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((consultant == null) ? 0 : consultant.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((jour == null) ? 0 : jour.hashCode());
		result = prime * result + ((tache == null) ? 0 : tache.hashCode());
		return result;
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
