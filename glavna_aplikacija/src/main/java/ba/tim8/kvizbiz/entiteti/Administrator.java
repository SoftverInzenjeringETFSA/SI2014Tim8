package ba.tim8.kvizbiz.entiteti;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
@PrimaryKeyJoinColumn(name = "idAdministrator", referencedColumnName = "idOsoba")
public class Administrator extends Osoba implements java.io.Serializable 
{
	
	
	@Column(name = "telefon", nullable = false)
	private String _telefon;
	@Column(name = "eMail", nullable = false)
	private String _eMail;
	@Column(name = "username", nullable = false)
	private String _username;
	@Column(name = "password", nullable = false)
	private String _password;
	
	
	
	public String get_username() {
		return _username;
	}
	public void set_username(String _username) {
		this._username = _username;
	}
	public String get_password() {
		return _password;
	}
	public void set_password(String _password) {
		this._password = _password;
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
	public Administrator() {
		super();
	}
	
	public Administrator(long _id, String _ime, String _prezime, Spol _spol,
			String _adresa, Date _datumRodjenja, String _brojtelefona,
			String _eMail, String _username, String _password) {
		super(_id,_ime,_prezime,_spol,_adresa,_datumRodjenja);
		this._username = _username;
		this._password = _password;
		this._telefon=_brojtelefona;
		this._eMail=_eMail;
	}
	
	@Override
	public String toString() {
		return this.get_username();
	}
}

