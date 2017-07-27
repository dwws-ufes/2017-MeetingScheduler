package br.ufes.inf.nemo.mscheduler.application;

import java.util.List;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.marvin.core.controller.SessionController;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;
import br.ufes.inf.nemo.mscheduler.domain.Resource;
import br.ufes.inf.nemo.mscheduler.persistence.MeetingRoomDAO;
import br.ufes.inf.nemo.mscheduler.persistence.ResourceDAO;

@Stateless
@PermitAll
public class ManageMeetingRoomsServiceBean extends CrudServiceBean<MeetingRoom> implements ManageMeetingRoomsService{

	@EJB
	private MeetingRoomDAO meetingRoomDAO;
	
	@EJB
	private ResourceDAO resourceDAO;

	
	
	@Override
	protected MeetingRoom validate(MeetingRoom newEntity, MeetingRoom oldEntity){
		System.out.println("validating...");
		
		
		return newEntity;
	}
	
	
	@Override
	public BaseDAO<MeetingRoom> getDAO() {
		// TODO Auto-generated method stub
		return meetingRoomDAO;
	}
	
}
