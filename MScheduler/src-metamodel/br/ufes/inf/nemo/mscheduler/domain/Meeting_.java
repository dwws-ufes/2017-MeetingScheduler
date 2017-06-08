package br.ufes.inf.nemo.mscheduler.domain;

import br.ufes.inf.nemo.marvin.core.domain.Academic;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-02T15:50:46.752-0300")
@StaticMetamodel(Meeting.class)
public class Meeting_ extends Appointment_ {
	public static volatile SingularAttribute<Meeting, String> theme;
	public static volatile SingularAttribute<Meeting, String> agenda;
	public static volatile SingularAttribute<Meeting, String> minutes;
	public static volatile SingularAttribute<Meeting, Academic> requester;
	public static volatile SetAttribute<Meeting, Invitation> invitations;
	public static volatile SingularAttribute<Meeting, MeetingRoom> room;
}
