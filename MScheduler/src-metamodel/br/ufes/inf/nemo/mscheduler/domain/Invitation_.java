package br.ufes.inf.nemo.mscheduler.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-02T15:48:06.430-0300")
@StaticMetamodel(Invitation.class)
public class Invitation_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Invitation, Boolean> confirmedPresence;
	public static volatile SingularAttribute<Invitation, String> reason;
	public static volatile SingularAttribute<Invitation, Academic> invited;
	public static volatile SingularAttribute<Invitation, Meeting> meeting;
}
