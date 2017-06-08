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
import br.ufes.inf.nemo.mscheduler.domain.Resource;
import br.ufes.inf.nemo.mscheduler.persistence.MeetingDAO;
import br.ufes.inf.nemo.mscheduler.persistence.ResourceDAO;

@Stateless
@PermitAll
public class manageResourcesServiceBean extends CrudServiceBean<Resource> implements ManageResourcesService{

	
	@EJB
	private ResourceDAO resourceDAO;
	
	@Override
	public BaseDAO<Resource> getDAO() {
		// TODO Auto-generated method stub
		return resourceDAO;
	}
	
}
