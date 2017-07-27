package br.ufes.inf.nemo.mscheduler.application;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.marvin.core.controller.SessionController;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;
import br.ufes.inf.nemo.mscheduler.persistence.MeetingDAO;

@Stateless
@PermitAll
public class ManageMeetingsServiceBean extends CrudServiceBean<Meeting> implements ManageMeetingsService{

	
	@EJB
	private MeetingDAO meetingDAO;

	
	@Override
	public BaseDAO<Meeting> getDAO() {
		// TODO Auto-generated method stub
		return meetingDAO;
	}
	

}
