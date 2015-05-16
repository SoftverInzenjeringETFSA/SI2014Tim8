package ba.tim8.kvizbiz.entiteti;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "klijent")
@PrimaryKeyJoinColumn(name = "idKlijent", referencedColumnName = "idOsoba")
public class Klijent extends Osoba implements java.io.Serializable{
	@Column(name = "telefon", nullable = true)
	private String _telefon;
	@Column(name = "eMail", nullable = true)
	private String _eMail;
	@Column(name = "datumPrijave", nullable = false)
	private Date _datumPrijave;
	@Column(name = "idKviz", nullable = true)
	private Kviz _popunjeniKviz;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="klijent_odgovor", joinColumns = { 
			@JoinColumn(name = "idKlijent", nullable = true, updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "idOdgovor", 
					nullable = true, updatable = true) })
	private Set<Odgovor> _listaOdgovora = new HashSet(0);
	
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

}
