package ba.tim8.kvizbiz.entiteti;

public class Pitanje implements java.io.Serializable{
	private long _id;
	private String _tekstPitanja;
	private TipPitanja _tipPitanja;
	private boolean obavezno;
	private Kviz _kviz;
	
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public String get_tekstPitanja() {
		return _tekstPitanja;
	}
	public void set_tekstPitanja(String _tekstPitanja) {
		this._tekstPitanja = _tekstPitanja;
	}
	public TipPitanja get_tipPitanja() {
		return _tipPitanja;
	}
	public void set_tipPitanja(TipPitanja _tipPitanja) {
		this._tipPitanja = _tipPitanja;
	}
	public boolean isObavezno() {
		return obavezno;
	}
	public void setObavezno(boolean obavezno) {
		this.obavezno = obavezno;
	}
	public Kviz get_kviz() {
		return _kviz;
	}
	public void set_kviz(Kviz _kviz) {
		this._kviz = _kviz;
	}
	
	public Pitanje(){}
	
	public Pitanje(long _id, String _tekstPitanja, TipPitanja _tipPitanja,
			boolean obavezno, Kviz _kviz) {
		super();
		this._id = _id;
		this._tekstPitanja = _tekstPitanja;
		this._tipPitanja = _tipPitanja;
		this.obavezno = obavezno;
		this._kviz = _kviz;
	}
	
}
