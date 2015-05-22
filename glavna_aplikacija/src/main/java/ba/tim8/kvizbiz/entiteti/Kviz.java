package ba.tim8.kvizbiz.entiteti;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "kviz")
public class Kviz implements java.io.Serializable{
	@Id
	@Column(name = "idKviz", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long _id;
	@Column(name = "naziv",nullable = false)
	private String _naziv;
	@Column(name = "vremenskoOgranicenje",nullable = false)
	private int _vremenskoOgranicenje;
	@Column(name = "aktivan",nullable = false)
	private boolean _aktivan;
	@Column(name = "arhiviran",nullable = false)
	private boolean _arhiviran;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "_popunjeniKviz")
	private Set<Klijent> _klijenti = new HashSet<Klijent>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "_kviz")
	private Set<Pitanje> _pitanja = new HashSet<Pitanje>();
	
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public String get_naziv() {
		return _naziv;
	}
	public void set_naziv(String _naziv) {
		this._naziv = _naziv;
	}
	public int get_vremenskoOgranicenje() {
		return _vremenskoOgranicenje;
	}
	public void set_vremenskoOgranicenje(int _vremenskoOgranicenje) {
		this._vremenskoOgranicenje = _vremenskoOgranicenje;
	}
	public boolean is_aktivan() {
		return _aktivan;
	}
	public void set_aktivan(boolean _aktivan) {
		this._aktivan = _aktivan;
	}
	public boolean is_arhiviran() {
		return _arhiviran;
	}
	public void set_arhiviran(boolean _arhiviran) {
		this._arhiviran = _arhiviran;
	}
	
	public Set<Klijent> get_klijenti()
	{
		return _klijenti;
	}
	public void set_klijenti(Set<Klijent> _klijenti)
	{
		this._klijenti = _klijenti;
	}
	
	public Set<Pitanje> get_pitanja()
	{
		return _pitanja;
	}
	public void set_pitanja(Set<Pitanje> _pitanja)
	{
		this._pitanja = _pitanja;
	}
	
	public Kviz(){}
	
	public Kviz(long _id, String _naziv, int _vremenskoOgranicenje,
			boolean _aktivan, boolean _arhiviran) {
		super();
		set_id(_id);
		set_naziv(_naziv);
		set_vremenskoOgranicenje(_vremenskoOgranicenje);
		set_aktivan(_aktivan);
		set_arhiviran(_arhiviran);
	}
	
	@Override
	public String toString() {
		return this.get_naziv();
	}
}
