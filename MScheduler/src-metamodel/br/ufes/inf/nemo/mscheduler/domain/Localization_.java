package br.ufes.inf.nemo.mscheduler.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-05T16:31:47.339-0300")
@StaticMetamodel(Localization.class)
public class Localization_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Localization, String> description;
	public static volatile SingularAttribute<Localization, String> address;
	public static volatile SingularAttribute<Localization, String> city;
	public static volatile SingularAttribute<Localization, String> country;
}
