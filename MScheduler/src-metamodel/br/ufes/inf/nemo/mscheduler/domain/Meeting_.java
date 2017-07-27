package br.ufes.inf.nemo.mscheduler.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-07-27T12:01:46.378-0300")
@StaticMetamodel(Meeting.class)
public class Meeting_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Meeting, String> theme;
	public static volatile SingularAttribute<Meeting, String> agenda;
	public static volatile SingularAttribute<Meeting, String> minutes;
	public static volatile SingularAttribute<Meeting, Academic> requester;
	public static volatile SetAttribute<Meeting, Academic> participants;
	public static volatile SingularAttribute<Meeting, MeetingRoom> room;
	public static volatile SingularAttribute<Meeting, String> name;
	public static volatile SingularAttribute<Meeting, Date> initialDate;
	public static volatile SingularAttribute<Meeting, Date> endDate;
}
