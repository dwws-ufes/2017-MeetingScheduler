package br.ufes.inf.nemo.mscheduler.domain;


import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.marvin.core.domain.Academic;

@Entity
public class Meeting extends Appointment{
	private static final long serialVersionUID = 1L;
	
	@Basic
	@NotNull
	@Size(max = 150)
	private String theme;
	
	@Basic
	@Size(max = 500)
	private String agenda;
	
	@Basic
	@Size(max = 1000)
	private String minutes;
	
	@NotNull
	@ManyToOne(optional = false)
	private Academic requester;
	
	@OneToMany(mappedBy="meeting")
	private Set<Invitation> invitations;

	@ManyToOne
	private MeetingRoom room;

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public Academic getRequester() {
		return requester;
	}

	public void setRequester(Academic requester) {
		this.requester = requester;
	}

	public Set<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(Set<Invitation> invitations) {
		this.invitations = invitations;
	}

	public MeetingRoom getRoom() {
		return room;
	}

	public void setRoom(MeetingRoom room) {
		this.room = room;
	}
	
	
	
	

}
