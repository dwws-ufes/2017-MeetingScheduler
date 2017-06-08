package br.ufes.inf.nemo.mscheduler.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;
import br.ufes.inf.nemo.marvin.core.domain.Academic;

@Entity
public class Invitation extends PersistentObjectSupport implements Comparable<Invitation>{
	
	private static final long serialVersionUID = 1L;
	
	@Basic
	@NotNull
	private boolean confirmedPresence;
	
	@Basic
	@Size(max = 500)
	private String reason;
	
	@ManyToOne
	private Academic invited;
	
	@ManyToOne
	private Meeting meeting;
	
		
	
	public boolean isConfirmedPresence() {
		return confirmedPresence;
	}

	public void setConfirmedPresence(boolean confirmedPresence) {
		this.confirmedPresence = confirmedPresence;
	}




	public String getReason() {
		return reason;
	}




	public void setReason(String reason) {
		this.reason = reason;
	}




	public Academic getInvited() {
		return invited;
	}




	public void setInvited(Academic invited) {
		this.invited = invited;
	}




	public Meeting getMeeting() {
		return meeting;
	}




	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}




	@Override
	public int compareTo(Invitation o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
