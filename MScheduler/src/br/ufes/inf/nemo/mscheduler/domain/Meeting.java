package br.ufes.inf.nemo.mscheduler.domain;


import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;
import br.ufes.inf.nemo.marvin.core.domain.Academic;

@Entity
public class Meeting extends PersistentObjectSupport implements Comparable<Meeting>{
	private static final long serialVersionUID = 1L;
	
	/*Nome do Compromisso*/
	@Basic
	@NotNull
	@Size(max = 100)
	protected String name;
	
	/*Data e Hora do início do compromisso*/
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date initialDate;
	
	/*Data e Hora do final do compromisso*/
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date endDate;
	
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	
	private Set<Academic> participants;

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

	public MeetingRoom getRoom() {
		return room;
	}

	public void setRoom(MeetingRoom room) {
		this.room = room;
	}

	public Set<Academic> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Academic> participants) {
		this.participants = participants;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int compareTo(Meeting o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
