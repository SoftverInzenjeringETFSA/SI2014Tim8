package ba.tim8.kvizbiz.entiteti;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "osoba")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Osoba implements java.io.Serializable {
	@Id
	@Column(name = "idOsoba", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long _id;
	@Column(name = "ime", nullable = false)
	private String _ime;
	@Column(name = "prezime", nullable = false)
	private String _prezime;
	@Column(name = "spol", nullable = false)
	@Enumerated(EnumType.STRING) 
	private Spol _spol;
	@Column(name = "adresa", nullable = false)
	private String _adresa;
	@Column(name = "datumRodjenja", nullable = false)
	private Date _datumRodjenja;
	
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
	
	public Osoba(){}
	
	public Osoba(long _id, String _ime, String _prezime, Spol _spol,
			String _adresa, Date _datumRodjenja) {
		super();
		this._id = _id;
		this._ime = _ime;
		this._prezime = _prezime;
		this._spol = _spol;
		this._adresa = _adresa;
		this._datumRodjenja = _datumRodjenja;
	}

}
