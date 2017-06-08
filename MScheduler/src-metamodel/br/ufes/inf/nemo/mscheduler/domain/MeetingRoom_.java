package br.ufes.inf.nemo.mscheduler.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-02T15:51:46.879-0300")
@StaticMetamodel(MeetingRoom.class)
public class MeetingRoom_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<MeetingRoom, String> name;
	public static volatile SingularAttribute<MeetingRoom, Integer> capacity;
	public static volatile SetAttribute<MeetingRoom, Meeting> meetings;
	public static volatile SetAttribute<MeetingRoom, Resource> resource;
	public static volatile SingularAttribute<MeetingRoom, Localization> localization;
}
