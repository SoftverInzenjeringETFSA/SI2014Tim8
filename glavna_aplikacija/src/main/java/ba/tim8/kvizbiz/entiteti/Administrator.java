package ba.tim8.kvizbiz.entiteti;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
public class Administrator extends Osoba implements java.io.Serializable 
{
	@Column(name = "name", nullable = false)
	private String _username;
	@Column(name = "name", nullable = false)
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
	
	public Administrator() {
		super();
	}
	
	public Administrator(long _id, String _ime, String _prezime, Spol _spol,
			String _adresa, Date _datumRodjenja, String _brojtelefona,
			String _eMail, String _username, String _password) {
		super(_id,_ime,_prezime,_spol,_adresa,_datumRodjenja,_brojtelefona,_eMail);
		this._username = _username;
		this._password = _password;
	}
}
