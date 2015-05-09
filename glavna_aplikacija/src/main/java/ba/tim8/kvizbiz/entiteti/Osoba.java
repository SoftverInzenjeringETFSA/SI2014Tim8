package ba.tim8.kvizbiz.entiteti;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "osoba")
public abstract class Osoba implements java.io.Serializable {
	@Id
	@Column(name = "idOsoba", unique = true, nullable = false)
	private long _id;
	@Column(name = "ime", nullable = false)
	private String _ime;
	@Column(name = "prezime", nullable = false)
	private String _prezime;
	@Column(name = "spol", nullable = false)
	private Spol _spol;
	@Column(name = "adresa", nullable = false)
	private String _adresa;
	@Column(name = "datumRodjenja", nullable = false)
	private Date _datumRodjenja;
	//ne nzma kako bi izmapirao
	private String _brojtelefona;
	//ne nzma kako bi izmapirao
	private String _eMail;
	
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public String get_ime() {
		return _ime;
	}
	public void set_ime(String _ime) {
		this._ime = _ime;
	}
	public String get_prezime() {
		return _prezime;
	}
	public void set_prezime(String _prezime) {
		this._prezime = _prezime;
	}
	public Spol get_spol() {
		return _spol;
	}
	public void set_spol(Spol _spol) {
		this._spol = _spol;
	}
	public String get_adresa() {
		return _adresa;
	}
	public void set_adresa(String _adresa) {
		this._adresa = _adresa;
	}
	public Date get_datumRodjenja() {
		return _datumRodjenja;
	}
	public void set_datumRodjenja(Date _datumRodjenja) {
		this._datumRodjenja = _datumRodjenja;
	}
	public String get_brojtelefona() {
		return _brojtelefona;
	}
	public void set_brojtelefona(String _brojtelefona) {
		this._brojtelefona = _brojtelefona;
	}
	public String get_eMail() {
		return _eMail;
	}
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}
	
	public Osoba(){}
	
	public Osoba(long _id, String _ime, String _prezime, Spol _spol,
			String _adresa, Date _datumRodjenja, String _brojtelefona,
			String _eMail) {
		super();
		this._id = _id;
		this._ime = _ime;
		this._prezime = _prezime;
		this._spol = _spol;
		this._adresa = _adresa;
		this._datumRodjenja = _datumRodjenja;
		this._brojtelefona = _brojtelefona;
		this._eMail = _eMail;
	}

}