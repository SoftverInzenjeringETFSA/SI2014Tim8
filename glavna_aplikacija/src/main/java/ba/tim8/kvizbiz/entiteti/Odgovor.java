package ba.tim8.kvizbiz.entiteti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "odgovor")
public class Odgovor implements java.io.Serializable{
	@Id
	@Column(name = "idOdgovor", unique = true, nullable = false)
	private long _id;
	@Column(name = "tesktOdgovora", nullable = false)
	private String _tekstOdgovora;
	@Column(name = "idPitanje", nullable = false)
	private Pitanje _pitanje;
	
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
	
	public Odgovor() {}
	
	public Odgovor(long _id, String _tekstOdgovora, Pitanje _pitanje) {
		super();
		this._id = _id;
		this._tekstOdgovora = _tekstOdgovora;
		this._pitanje = _pitanje;
	}
	
}
