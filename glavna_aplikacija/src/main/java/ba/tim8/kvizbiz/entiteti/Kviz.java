package ba.tim8.kvizbiz.entiteti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kviz")
public class Kviz implements java.io.Serializable{
	@Id
	@Column(name = "idKviz", unique = true, nullable = false)
	private long _id;
	@Column(name = "naziv",nullable = false)
	private String _naziv;
	@Column(name = "vremenskoOgranicenje",nullable = false)
	private int _vremenskoOgranicenje;
	@Column(name = "aktivan",nullable = false)
	private boolean _aktivan;
	@Column(name = "arhiviran",nullable = false)
	private boolean _arhiviran;
	
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
	
	public Kviz(){}
	
	public Kviz(long _id, String _naziv, int _vremenskoOgranicenje,
			boolean _aktivan, boolean _arhiviran) {
		super();
		this._id = _id;
		this._naziv = _naziv;
		this._vremenskoOgranicenje = _vremenskoOgranicenje;
		this._aktivan = _aktivan;
		this._arhiviran = _arhiviran;
	}
}
