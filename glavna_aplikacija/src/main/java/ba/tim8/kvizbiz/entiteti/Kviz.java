package ba.tim8.kvizbiz.entiteti;

public class Kviz implements java.io.Serializable{
	
	private long _id;
	private String _naziv;
	private int _vremenskoOgranicenje;
	private boolean _aktivan;
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
