package br.ufes.inf.nemo.mscheduler.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

@Entity
public class Resource extends PersistentObjectSupport implements Comparable<Resource>{

private static final long serialVersionUID = 1L;
	
	@Basic
	@NotNull
	private boolean fixedOnRoom;
	
	@Basic
	@NotNull
	@Size(max = 100)
	private String type;
	
	@Basic
	@Size(max = 500)
	private String description;

	@ManyToOne
	private MeetingRoom belongs;
	
	
	
	public boolean isFixedOnRoom() {
		return fixedOnRoom;
	}



	public void setFixedOnRoom(boolean fixedOnRoom) {
		this.fixedOnRoom = fixedOnRoom;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public MeetingRoom getBelongs() {
		return belongs;
	}



	public void setBelongs(MeetingRoom belongs) {
		this.belongs = belongs;
	}



	@Override
	public int compareTo(Resource o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
