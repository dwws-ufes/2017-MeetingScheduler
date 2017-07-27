package br.ufes.inf.nemo.mscheduler.application;

import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
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
	
	public List<Resource> retrieveByDescriptionName(String nomeDescricao) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		return ((ResourceDAO) getDAO()).retrieveByNomeDescricao(nomeDescricao);
	}

	public ResourceDAO getResourceDAO() {
		return resourceDAO;
	}

	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}
	
	
	
}
