package ba.tim8.kvizbiz.entiteti;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "odgovor")
public class Odgovor implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idOdgovor", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long _id;
	@Column(name = "tekstOdgovora", nullable = false)
	private String _tekstOdgovora;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "idPitanje", nullable = true, updatable = true)
	private Pitanje _pitanje;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "_listaOdgovora",cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Klijent> _klijenti = new HashSet<Klijent>(); //NOSONAR
	
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public String get_tekstOdgovora() {
		return _tekstOdgovora;
	}
	public void set_tekstOdgovora(String _tekstOdgovora) throws Exception {
		if (_tekstOdgovora.trim().length() == 0) {
			throw new Exception("Tekst odgovora smije ostati prazan!");
		}
		
		this._tekstOdgovora = _tekstOdgovora;
	}
	public Pitanje get_pitanje() {
		return _pitanje;
	}
	public void set_pitanje(Pitanje _pitanje) {
		this._pitanje = _pitanje;
	}
	
	public Set<Klijent> get_klijenti()
	{
		return _klijenti;
	}
	public void set_klijenti(Set<Klijent> _klijenti)
	{
		this._klijenti = _klijenti;
	}
	
	public Odgovor() {}
	
	public Odgovor(long _id, String _tekstOdgovora, Pitanje _pitanje, Set<Klijent> _klijenti) throws Exception {
		super();
		set_id(_id);
		set_tekstOdgovora(_tekstOdgovora);
		set_pitanje(_pitanje);
		set_klijenti(_klijenti);
	}
	
}
