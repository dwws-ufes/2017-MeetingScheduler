package br.ufes.inf.nemo.mscheduler.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.mscheduler.domain.Appointment;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;
import br.ufes.inf.nemo.mscheduler.domain.Resource;

@Local
public interface ResourceDAO extends BaseDAO<Resource>{

	
	
}
