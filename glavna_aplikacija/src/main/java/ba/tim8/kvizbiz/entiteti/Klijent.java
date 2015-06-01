package ba.tim8.kvizbiz.entiteti;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "klijent")
@PrimaryKeyJoinColumn(name = "idKlijent", referencedColumnName = "idOsoba")
public class Klijent extends Osoba implements  java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "telefon", nullable = true)
	private String _telefon;
	@Column(name = "eMail", nullable = true)
	private String _eMail;
	@Column(name = "datumPrijave", nullable = false)
	private Date _datumPrijave;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "idKviz", nullable = true)
	private Kviz _popunjeniKviz;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="klijent_odgovor", joinColumns = { 
			@JoinColumn(name = "idKlijent", referencedColumnName="idKlijent", nullable = true, updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "idOdgovor", 
					nullable = true, referencedColumnName="idOdgovor", updatable = true) })
	private Set<Odgovor> _listaOdgovora = new HashSet<Odgovor>(0); //NOSONAR
	
	public Date get_datumPrijave() {
		return _datumPrijave;
	}

	public void set_datumPrijave(Date _datumPrijave) {
		this._datumPrijave = _datumPrijave;
	}

	public Kviz get_popunjeniKviz() {
		return _popunjeniKviz;
	}

	public void set_popunjeniKviz(Kviz _popunjeniKviz) {
		this._popunjeniKviz = _popunjeniKviz;
	}

	public Set<Odgovor> get_listaOdgovora() {
		return _listaOdgovora;
	}

	public void set_listaOdgovora(Set<Odgovor> _listaOdgovora) {
		this._listaOdgovora = _listaOdgovora;
	}

	public String get_telefon() {
		return _telefon;
	}

	public void set_telefon(String _telefon) {
		this._telefon = _telefon;
	}

	public String get_eMail() {
		return _eMail;
	}

	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}

	public Klijent() {
		super();
	}
	
	public Klijent(long _id, String _ime, String _prezime, Spol _spol,
			String _adresa, Date _datumRodjenja, String _brojtelefona,
			String _eMail, Date _datumPrijave, Kviz _popunjeniKviz, Set<Odgovor> _listaOdgovora) {
		super(_id,_ime,_prezime,_spol,_adresa,_datumRodjenja);
		this._telefon=_brojtelefona;
		this._eMail=_eMail;
		this._datumPrijave=_datumPrijave;
		this._popunjeniKviz=_popunjeniKviz;
		this._listaOdgovora=_listaOdgovora;
	}
	
	@Override
	public String toString() {
		return this.get_ime()+" "+this.get_prezime();
	}

}
