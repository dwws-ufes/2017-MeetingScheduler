package br.ufes.inf.nemo.mscheduler.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.mscheduler.domain.Appointment;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;

@Local
public interface MeetingRoomDAO extends BaseDAO<MeetingRoom>{

	
	
}
