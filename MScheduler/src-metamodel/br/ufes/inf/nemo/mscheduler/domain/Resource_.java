package br.ufes.inf.nemo.mscheduler.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-05T16:31:47.568-0300")
@StaticMetamodel(Resource.class)
public class Resource_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Resource, Boolean> fixedOnRoom;
	public static volatile SingularAttribute<Resource, String> type;
	public static volatile SingularAttribute<Resource, String> description;
	public static volatile SingularAttribute<Resource, MeetingRoom> belongs;
}
