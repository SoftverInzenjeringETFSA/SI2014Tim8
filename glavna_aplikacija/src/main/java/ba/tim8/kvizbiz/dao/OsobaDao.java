package ba.tim8.kvizbiz.dao;

import ba.tim8.kvizbiz.entiteti.Osoba;

public class OsobaDao extends BaseDao<Osoba> {

	private static OsobaDao odao = null;

	public static OsobaDao get() {
		return (odao == null) ? odao = new OsobaDao() : odao;
	}
	
	private OsobaDao(){}

	
}
