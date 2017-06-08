package br.ufes.inf.nemo.mscheduler.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;
import br.ufes.inf.nemo.marvin.core.domain.Academic;

@MappedSuperclass
public class Appointment extends PersistentObjectSupport implements Comparable<Appointment> {
	/** Serialization id. */
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

	@ManyToMany
	protected Set<Academic> participants;
	
	@Override
	public int compareTo(Appointment o) {
		// TODO Auto-generated method stub
		return 0;
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

	public Set<Academic> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Academic> participants) {
		this.participants = participants;
	}

	
	
	
	
}