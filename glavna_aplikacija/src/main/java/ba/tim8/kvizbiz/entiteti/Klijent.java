package ba.tim8.kvizbiz.entiteti;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "klijent")
public class Klijent extends Osoba implements java.io.Serializable{
	@Column(name = "datumPrijave", nullable = false)
	private Date _datumPrijave;
	@Column(name = "idKviz", nullable = false)
	private Kviz _popunjeniKviz;
	
	private List<Odgovor> _listaOdgovora;
	
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

	public List<Odgovor> get_listaOdgovora() {
		return _listaOdgovora;
	}

	public void set_listaOdgovora(List<Odgovor> _listaOdgovora) {
		this._listaOdgovora = _listaOdgovora;
	}

	public Klijent() {
		super();
	}
	
	public Klijent(long _id, String _ime, String _prezime, Spol _spol,
			String _adresa, Date _datumRodjenja, String _brojtelefona,
			String _eMail, Date _datumPrijave, Kviz _popunjeniKviz, List<Odgovor> _listaOdgovora) {
		super(_id,_ime,_prezime,_spol,_adresa,_datumRodjenja,_brojtelefona,_eMail);
		this._datumPrijave=_datumPrijave;
		this._popunjeniKviz=_popunjeniKviz;
		this._listaOdgovora=_listaOdgovora;
	}

}
