package br.ufes.inf.nemo.mscheduler.domain;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

@Entity
public class MeetingRoom extends PersistentObjectSupport implements Comparable<MeetingRoom> {

	private static final long serialVersionUID = 1L;

	@Basic
	@NotNull
	private String name;
	
	@Basic
	@NotNull
	private Integer capacity;
	
	@OneToMany(mappedBy="room")
	private Set<Meeting> meetings;
	
	
	@OneToMany(mappedBy="belongs", fetch=FetchType.EAGER)
	private Set<Resource> resource;

	@ManyToOne
	private Localization localization;
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Integer getCapacity() {
		return capacity;
	}




	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}




	public Set<Meeting> getMeetings() {
		return meetings;
	}




	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}




	public Set<Resource> getResource() {
		return resource;
	}




	public void setResource(Set<Resource> resource) {
		this.resource = resource;
	}




	public Localization getLocalization() {
		return localization;
	}




	public void setLocalization(Localization localization) {
		this.localization = localization;
	}




	@Override
	public int compareTo(MeetingRoom o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
