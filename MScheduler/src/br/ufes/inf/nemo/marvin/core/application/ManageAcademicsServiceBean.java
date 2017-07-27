package br.ufes.inf.nemo.marvin.core.application;

import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import br.ufes.inf.nemo.marvin.core.persistence.AcademicDAO;
import br.ufes.inf.nemo.mscheduler.persistence.ResourceDAO;

@Stateless
@PermitAll
public class ManageAcademicsServiceBean extends CrudServiceBean<Academic> implements ManageAcademicsService {

	
	@EJB
	private AcademicDAO academicDAO;
	
	@Override
	public BaseDAO<Academic> getDAO() {
		// TODO Auto-generated method stub
		return academicDAO;
	}
	
	@Override
	protected Academic validate(Academic newEntity, Academic oldEntity){
		Date now = new Date(System.currentTimeMillis());
		if(oldEntity == null) newEntity.setCreationDate(now);
		
		newEntity.setLastUpdateDate(now);
		
		newEntity.setShortName(newEntity.getName().substring(newEntity.getName().indexOf(" ")));
		
		return newEntity;
	}
	
	public List<Academic> retrieveByName(String name) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		return ((AcademicDAO) getDAO()).retrieveByName(name);
	}

}
