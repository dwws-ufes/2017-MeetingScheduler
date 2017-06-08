package br.ufes.inf.nemo.mscheduler.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-02T15:46:55.068-0300")
@StaticMetamodel(Appointment.class)
public class Appointment_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Appointment, String> name;
	public static volatile SingularAttribute<Appointment, Date> initialDate;
	public static volatile SingularAttribute<Appointment, Date> endDate;
	public static volatile SetAttribute<Appointment, Academic> participants;
}
