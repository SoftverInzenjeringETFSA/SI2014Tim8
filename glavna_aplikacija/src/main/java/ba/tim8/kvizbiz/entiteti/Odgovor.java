package ba.tim8.kvizbiz.entiteti;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "odgovor")
public class Odgovor implements java.io.Serializable{
	@Id
	@Column(name = "idOdgovor", unique = true, nullable = false)
	private long _id;
	@Column(name = "tekstOdgovora", nullable = false)
	private String _tekstOdgovora;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPitanje", nullable = true, updatable = true)
	private Pitanje _pitanje;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "_listaOdgovora")
	private Set<Klijent> _klijenti = new HashSet<Klijent>();
	
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public String get_tekstOdgovora() {
		return _tekstOdgovora;
	}
	public void set_tekstOdgovora(String _tekstOdgovora) {
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
	
	public Odgovor(long _id, String _tekstOdgovora, Pitanje _pitanje, Set<Klijent> _klijenti) {
		super();
		this._id = _id;
		this._tekstOdgovora = _tekstOdgovora;
		this._pitanje = _pitanje;
		this._klijenti = _klijenti;
	}
	
}
