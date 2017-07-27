package br.ufes.inf.nemo.mscheduler.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;

@Local
public interface MeetingDAO extends BaseDAO<Meeting>{

	
	
}
