package ba.tim8.kvizbiz.entiteti;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pitanje")
public class Pitanje implements java.io.Serializable{
	@Id
	@Column(name = "idPitanje", unique = true, nullable = false)
	private long _id;
	@Column(name = "tekstPitanja", nullable = false)
	private String _tekstPitanja;
	
	@Column(name="tipPitanja") 
	@Enumerated(EnumType.ORDINAL) 
	private TipPitanja _tipPitanja;
	
	@Column(name = "obavezno", nullable = false)
	private boolean obavezno;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idKviz", nullable = true, updatable=true)
	private Kviz _kviz;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "_pitanje")
	private Set<Odgovor> _listaOdgovora = new HashSet<Odgovor>();
	
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
	
	public Set<Odgovor> get_listaOdgovora() {
		return _listaOdgovora;
	}

	public void set_listaOdgovora(Set<Odgovor> _listaOdgovora) {
		this._listaOdgovora = _listaOdgovora;
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
