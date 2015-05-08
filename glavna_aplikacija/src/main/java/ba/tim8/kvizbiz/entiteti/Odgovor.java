package ba.tim8.kvizbiz.entiteti;

public class Odgovor implements java.io.Serializable{
	private long _id;
	private String _tekstOdgovora;
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
